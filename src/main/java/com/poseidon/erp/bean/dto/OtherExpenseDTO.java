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
 * 其他收支 dto
 *
 * @author mario on 2020-12-02
 */
@Getter
@Setter
public class OtherExpenseDTO extends BaseDTO {

    /**
     * 收支项目
     */
    @NotEmpty(message = "收支项目不能为空")
    private String name;

    /**
     * 金额
     */
    @NotNull(message = "金额不能为空")
    private BigDecimal amount;

    /**
     * 项目时间
     */
    @NotNull(message = "项目时间不能为空")
    @JsonFormat(pattern = Constants.DATETIME)
    private LocalDateTime itemTime;

    /**
     * 备注
     */
    private String remark;


}
