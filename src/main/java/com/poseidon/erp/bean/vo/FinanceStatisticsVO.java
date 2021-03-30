package com.poseidon.erp.bean.vo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class FinanceStatisticsVO {
    private BigDecimal salary;
    private BigDecimal purchase;
    private BigDecimal sales;
    private BigDecimal operating;
    private BigDecimal other;

}
