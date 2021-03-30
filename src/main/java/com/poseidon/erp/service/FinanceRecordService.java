package com.poseidon.erp.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.poseidon.erp.bean.dto.FinanceRecordDTO;
import com.poseidon.erp.bean.entity.*;
import com.poseidon.erp.bean.enums.FinanceRecordType;
import com.poseidon.erp.bean.search.FinanceRecordSearch;
import com.poseidon.erp.bean.search.StatisticsSearch;
import com.poseidon.erp.bean.vo.FinanceChatItemVO;
import com.poseidon.erp.bean.vo.FinanceChatVO;
import com.poseidon.erp.bean.vo.FinanceStatisticsVO;
import com.poseidon.erp.common.BaseService;
import com.poseidon.erp.common.Constants;
import com.poseidon.erp.dao.FinanceRecordDao;
import com.poseidon.erp.utils.ResponseCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 财务记录  Service
 *
 * @author mario on 2020-12-11
 */
@Service
@Transactional
public class FinanceRecordService extends BaseService<FinanceRecordDao, FinanceRecord, FinanceRecordDTO> {

    public FinanceRecordService() {
        super(FinanceRecord.class, ResponseCode.FINANCE_RECORD_NOT_FOUND);
    }

    /**
     * 创建销售额财务记录
     */
    public void create(CrossBorderIncome crossBorderIncome) {
        FinanceRecord financeRecord = findByRelationAndType(crossBorderIncome.getId(), FinanceRecordType.SALES);
        financeRecord
                .setRelationId(crossBorderIncome.getId())
                .setName(crossBorderIncome.getName())
                .setAmount(crossBorderIncome.getAmount())
                .setOperator(crossBorderIncome.getOperator());
        super.saveOrUpdate(financeRecord);
    }

    /**
     * 创建采购额财务记录
     */
    public void create(PurchaseOrder purchaseOrder) {
        FinanceRecord financeRecord = findByRelationAndType(purchaseOrder.getId(), FinanceRecordType.PURCHASE);
        financeRecord
                .setName(purchaseOrder.getOrderNo() + " " + purchaseOrder.getName())
                .setAmount(purchaseOrder.getTotalPrice())
                .setRemark(purchaseOrder.getRemark())
                .setOperator(purchaseOrder.getOperator())
                .setCreateTime(purchaseOrder.getPurchaseTime());
        super.saveOrUpdate(financeRecord);
    }

    /**
     * 创建其他收支财务记录
     */
    public void create(OtherExpense otherExpense) {
        FinanceRecord financeRecord = findByRelationAndType(otherExpense.getId(), FinanceRecordType.OTHER);
        financeRecord
                .setName(otherExpense.getName())
                .setAmount(otherExpense.getAmount())
                .setRemark(otherExpense.getRemark())
                .setOperator(otherExpense.getOperator());
        super.saveOrUpdate(financeRecord);
    }

    /**
     * 创建工资财务记录
     */
    public void create(Payroll payroll) {
        FinanceRecord financeRecord = findByRelationAndType(payroll.getId(), FinanceRecordType.SALARY);
        financeRecord
                .setName(payroll.getRealname())
                .setAmount(payroll.getTotal())
                .setRemark(payroll.getRemark())
                .setOperator(payroll.getOperator());
        super.saveOrUpdate(financeRecord);
    }

    /**
     * 创建运营支出财务记录
     */
    public void create(OperatingExpense operatingExpense) {
        FinanceRecord financeRecord = findByRelationAndType(operatingExpense.getId(), FinanceRecordType.OPERATING);
        financeRecord
                .setName(operatingExpense.getName())
                .setAmount(operatingExpense.getAmount())
                .setRemark(operatingExpense.getRemark())
                .setOperator(operatingExpense.getOperator());
        super.saveOrUpdate(financeRecord);
    }

    public FinanceStatisticsVO statistics(StatisticsSearch search) {
        checkDateRange(search);
        return baseMapper.selectStatistics(search.getStartDate(), search.getEndDate());
    }


    public FinanceChatVO statisticsChat(StatisticsSearch search) {
        checkDateRange(search);
        LocalDate startDate = search.getStartDate();
        LocalDate endDate = search.getEndDate();
        Map<FinanceRecordType, List<BigDecimal>> map = new HashMap<>();
        List<BigDecimal> list = new ArrayList<>();
        List<String> months = new ArrayList<>();
        for (LocalDate date = startDate; date.isBefore(endDate) || date.isEqual(endDate); date = date.plusMonths(1)) {
            list.add(BigDecimal.ZERO);
            months.add(date.format(DateTimeFormatter.ofPattern(Constants.MONTH)));
        }
        for (FinanceRecordType type : FinanceRecordType.values()) {
            map.put(type, new ArrayList<>(list));
        }
        List<FinanceChatItemVO> items = baseMapper.selectStatisticsChat(startDate, endDate);
        for (FinanceChatItemVO item : items) {
            int index = months.indexOf(item.getMonth());
            List<BigDecimal> amounts;
            BigDecimal amount = item.getAmount();
            FinanceRecordType type = item.getType();

            amounts = map.get(type);
            amounts.set(index, amount);

            List<BigDecimal> totalRevenue = map.get(FinanceRecordType.TOTAL_REVENUE);
            BigDecimal revenue = totalRevenue.get(index);
            totalRevenue.set(index, type == FinanceRecordType.OTHER || type == FinanceRecordType.SALES ? revenue.add(amount) : revenue.subtract(amount));
        }
        return new FinanceChatVO(map, months);
    }

    /**
     * 检查日期，默认值
     */
    private void checkDateRange(StatisticsSearch search) {
        LocalDate now = LocalDate.now();
        if (search.getStartDate() == null) {
            search.setStartDate(now.minusMonths(6));
        }
        if (search.getEndDate() == null) {
            search.setEndDate(now);
        }
    }

    /**
     * 根据关联ID和类型查询记录
     */
    private FinanceRecord findByRelationAndType(Long relationId, FinanceRecordType type) {
        FinanceRecord financeRecord = super.getOne(Wrappers
                .<FinanceRecord>lambdaQuery()
                .eq(FinanceRecord::getRelationId, relationId)
                .eq(FinanceRecord::getType, type)
        );
        if (financeRecord == null) {
            financeRecord = new FinanceRecord();
            financeRecord
                    .setRelationId(relationId)
                    .setType(type);
        }
        return financeRecord;
    }

    /**
     * 删除
     */
    public void remove(Long relationId, FinanceRecordType type) {
        super.remove(Wrappers
                .<FinanceRecord>lambdaQuery()
                .eq(FinanceRecord::getRelationId, relationId)
                .eq(FinanceRecord::getType, type)
        );
    }

    /**
     * 统计总金额
     */
    public BigDecimal statisticsAmount(FinanceRecordSearch search) {
        return baseMapper.statisticsAmount(search.query());
    }
}
