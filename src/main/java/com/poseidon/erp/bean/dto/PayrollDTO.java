package com.poseidon.erp.bean.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.poseidon.erp.common.BaseDTO;
import com.poseidon.erp.common.Constants;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 工资单 dto
 *
 * @author mario on 2020-12-01
 */
@Getter
@Setter
public class PayrollDTO extends BaseDTO {

    /**
     * 姓名
     */
    @NotNull(message = "员工ID不能为空")
    private Long userId;

    /**
     * 所属年月
     */
    @NotNull(message = "所属年月不能为空")
    @JsonFormat(pattern = Constants.DATE)
    private LocalDate date;

    /**
     * 基本工资
     */
    @NotNull(message = "基本工资不能为空")
    private BigDecimal basicSalary;

    /**
     * 加班工资
     */
    @NotNull(message = "加班工资不能为空")
    private BigDecimal overtimeSalary;

    /**
     * 补贴
     */
    @NotNull(message = "补贴不能为空")
    private BigDecimal subsidy;

    /**
     * 考勤
     */
    @NotNull(message = "考勤不能为空")
    private BigDecimal attendance;

    /**
     * 其他
     */
    @NotNull(message = "其他不能为空")
    private BigDecimal other;

    /**
     * 备注
     */
    private String remark;
}
