package com.poseidon.erp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.poseidon.erp.bean.dto.StockingRecordDTO;
import com.poseidon.erp.bean.entity.StockingPlan;
import com.poseidon.erp.bean.entity.StockingRecord;
import com.poseidon.erp.bean.entity.SysUser;
import com.poseidon.erp.bean.enums.TaskStatus;
import com.poseidon.erp.bean.search.StockingRecordSearch;
import com.poseidon.erp.bean.vo.StockingRecordVO;
import com.poseidon.erp.common.BaseService;
import com.poseidon.erp.dao.StockingRecordDao;
import com.poseidon.erp.exception.BusinessException;
import com.poseidon.erp.utils.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 备货记录  Service
 *
 * @author mario on 2021-01-21
 */
@Service
@Transactional
public class StockingRecordService extends BaseService<StockingRecordDao, StockingRecord, StockingRecordDTO> {

    @Autowired
    private StockingPlanService stockingPlanService;
    @Autowired
    private SysUserService sysUserService;

    public StockingRecordService() {
        super(StockingRecord.class, ResponseCode.STOCKING_RECORD_NOT_FOUND);
    }

    public IPage<StockingRecordVO> stockingRecordPage(Page<StockingRecord> page, StockingRecordSearch search) {
        return baseMapper.selectStockingRecordPage(page, search.query());
    }

    public List<StockingRecordVO> stockingRecordList(StockingRecordSearch search) {
        return baseMapper.selectStockingRecordList(search.query());
    }

    @Override
    protected void createExtend(StockingRecord stockingRecord) {
        StockingPlan plan = stockingPlanService.get(stockingRecord.getStockingPlanId());
        SysUser sysUser = sysUserService.get(stockingRecord.getFinishPersonId());

        stockingRecord.setFinishPerson(sysUser.getRealname());

        //更新车间任务时间、状态
        if (plan.getStatus() == TaskStatus.FINISHED) {
            throw new BusinessException(ResponseCode.STOCKING_PLAN_FINISHED);
        }
        if (plan.getStatus() == TaskStatus.PENDING_PRODUCE) {
            plan.setStatus(TaskStatus.IN_PRODUCTION);
        }
        plan.setModifyTime(LocalDateTime.now());
        stockingPlanService.updateById(plan);

    }

    /**
     * 查询备货数量总和
     */
    public Integer findTotalQuantity(Long stockingPlanId) {
        return baseMapper.selectTotalQuantity(stockingPlanId);
    }

}
