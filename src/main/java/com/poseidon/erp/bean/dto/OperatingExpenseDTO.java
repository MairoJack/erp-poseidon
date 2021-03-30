package com.poseidon.erp.bean.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.poseidon.erp.common.BaseDTO;
import com.poseidon.erp.common.Constants;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 运营支出 dto
 *
 * @author mario on 2021-01-18
 */
@Getter
@Setter
public class OperatingExpenseDTO extends BaseDTO{

    /**
     * 运营项目
     */
    @NotEmpty(message = "运营项目不能为空")
    private String name;

    /**
     * 金额
     */
    @NotNull(message = "金额不能为空")
    private BigDecimal amount;

    /**
     * 备注
     */
    private String remark;

    /**
     * 项目时间
     */
    @NotNull(message = "项目时间不能为空")
    @JsonFormat(pattern = Constants.DATETIME)
    private LocalDateTime itemTime;
}
