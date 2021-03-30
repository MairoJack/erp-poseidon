package com.poseidon.erp.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.poseidon.erp.bean.dto.PayrollDTO;
import com.poseidon.erp.bean.entity.Payroll;
import com.poseidon.erp.bean.entity.SysUser;
import com.poseidon.erp.bean.enums.FinanceRecordType;
import com.poseidon.erp.common.BaseService;
import com.poseidon.erp.dao.PayrollDao;
import com.poseidon.erp.exception.BusinessException;
import com.poseidon.erp.utils.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 工资单  Service
 *
 * @author mario on 2020-12-01
 */
@Service
public class PayrollService extends BaseService<PayrollDao, Payroll, PayrollDTO> {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private FinanceRecordService financeRecordService;

    public PayrollService() {
        super(Payroll.class, ResponseCode.PAYROLL_FOUND);
    }

    @Override
    protected void checkExist(Payroll entity, PayrollDTO dto) {
        if (exists(entity.getId(),
                Wrappers.<Payroll>lambdaQuery()
                        .eq(Payroll::getUserId, dto.getUserId())
                        .eq(Payroll::getDate, dto.getDate())
        )) {
            throw new BusinessException(ResponseCode.PAYROLL_HAS_EXISTED);
        }
    }

    @Override
    protected void createExtend(Payroll payroll) {
        SysUser sysUser = sysUserService.get(payroll.getUserId());
        payroll
                .setRealname(sysUser.getRealname())
                .setMobile(sysUser.getMobile())
                .summary();
    }

    @Override
    protected void modifyExtend(Payroll payroll) {
        payroll.summary();
    }

    @Override
    protected void afterCreate(Payroll payroll, PayrollDTO dto) {
        financeRecordService.create(payroll);
    }

    @Override
    protected void afterModify(Payroll payroll, PayrollDTO dto) {
        financeRecordService.create(payroll);
    }

    @Override
    protected void afterDelete(Payroll payroll) {
        financeRecordService.remove(payroll.getId(), FinanceRecordType.SALARY);
    }
}
