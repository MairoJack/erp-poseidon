package com.poseidon.erp.service;

import com.poseidon.erp.bean.dto.OtherExpenseDTO;
import com.poseidon.erp.bean.entity.OtherExpense;
import com.poseidon.erp.bean.enums.FinanceRecordType;
import com.poseidon.erp.common.BaseService;
import com.poseidon.erp.dao.OtherExpenseDao;
import com.poseidon.erp.utils.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 其他收支  Service
 *
 * @author mario on 2020-12-02
 */
@Service
public class OtherExpenseService extends BaseService<OtherExpenseDao, OtherExpense, OtherExpenseDTO> {

    @Autowired
    private FinanceRecordService financeRecordService;

    public OtherExpenseService() {
        super(OtherExpense.class, ResponseCode.OTHER_EXPENSE_FOUND);
    }

    @Override
    protected void afterCreate(OtherExpense otherExpense, OtherExpenseDTO dto) {
        financeRecordService.create(otherExpense);
    }

    @Override
    protected void afterModify(OtherExpense otherExpense, OtherExpenseDTO dto) {
        financeRecordService.create(otherExpense);
    }

    @Override
    protected void afterDelete(OtherExpense otherExpense) {
        financeRecordService.remove(otherExpense.getId(), FinanceRecordType.OTHER);
    }
}
