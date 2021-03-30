package com.poseidon.erp.service;

import com.poseidon.erp.bean.dto.OperatingExpenseDTO;
import com.poseidon.erp.bean.entity.OperatingExpense;
import com.poseidon.erp.bean.enums.FinanceRecordType;
import com.poseidon.erp.common.BaseService;
import com.poseidon.erp.dao.OperatingExpenseDao;
import com.poseidon.erp.utils.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 运营支出  Service
 *
 * @author mario on 2021-01-18
 */
@Service
@Transactional
public class OperatingExpenseService extends BaseService<OperatingExpenseDao, OperatingExpense, OperatingExpenseDTO> {

    @Autowired
    private FinanceRecordService financeRecordService;

    public OperatingExpenseService() {
        super(OperatingExpense.class, ResponseCode.OPERATING_EXPENSE_NOT_FOUND);
    }

    @Override
    protected void afterCreate(OperatingExpense operatingExpense, OperatingExpenseDTO dto) {
        financeRecordService.create(operatingExpense);
    }

    @Override
    protected void afterModify(OperatingExpense operatingExpense, OperatingExpenseDTO dto) {
        financeRecordService.create(operatingExpense);
    }

    @Override
    protected void afterDelete(OperatingExpense operatingExpense) {
        financeRecordService.remove(operatingExpense.getId(), FinanceRecordType.OPERATING);
    }
}
