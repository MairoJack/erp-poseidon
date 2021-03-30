package com.poseidon.erp.bean.vo;

import com.poseidon.erp.bean.enums.FinanceRecordType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class FinanceChatItemVO {
    private String month;
    private FinanceRecordType type;
    private BigDecimal amount;

}
