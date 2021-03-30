package com.poseidon.erp.service;

import com.poseidon.erp.bean.dto.CrossBorderIncomeDTO;
import com.poseidon.erp.bean.entity.CrossBorderIncome;
import com.poseidon.erp.bean.enums.FinanceRecordType;
import com.poseidon.erp.common.BaseService;
import com.poseidon.erp.dao.CrossBorderIncomeDao;
import com.poseidon.erp.utils.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 跨境返款  Service
 *
 * @author mario on 2021-01-18
 */
@Service
@Transactional
public class CrossBorderIncomeService extends BaseService<CrossBorderIncomeDao, CrossBorderIncome, CrossBorderIncomeDTO> {

    @Autowired
    private FinanceRecordService financeRecordService;

    public CrossBorderIncomeService() {
        super(CrossBorderIncome.class, ResponseCode.CROSS_BORDER_INCOME_NOT_FOUND);
    }

    @Override
    protected void afterCreate(CrossBorderIncome crossBorderIncome, CrossBorderIncomeDTO dto) {
        financeRecordService.create(crossBorderIncome);
    }

    @Override
    protected void afterModify(CrossBorderIncome crossBorderIncome, CrossBorderIncomeDTO dto) {
        financeRecordService.create(crossBorderIncome);
    }

    @Override
    protected void afterDelete(CrossBorderIncome crossBorderIncome) {
        financeRecordService.remove(crossBorderIncome.getId(), FinanceRecordType.SALES);
    }
}
