package com.poseidon.erp.bean.vo;

import com.poseidon.erp.bean.enums.FinanceRecordType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Setter
@Getter
public class FinanceChatVO {
    private Map<FinanceRecordType, List<BigDecimal>> data;
    private List<String> months;

    public FinanceChatVO(Map<FinanceRecordType, List<BigDecimal>> data, List<String> months) {
        this.data = data;
        this.months = months;
    }
}
