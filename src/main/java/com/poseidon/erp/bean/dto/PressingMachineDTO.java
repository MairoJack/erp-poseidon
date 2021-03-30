package com.poseidon.erp.bean.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.poseidon.erp.common.BaseDTO;
import com.poseidon.erp.common.Constants;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 压机 dto
 *
 * @author mario on 2020-11-17
 */
@Getter
@Setter
public class PressingMachineDTO extends BaseDTO{

    /**
     * 压机名称
     */
    @NotEmpty(message = "压机名称不能为空")
    private String name;

    /**
     * 压机编号
     */
    @NotEmpty(message = "压机编号不能为空")
    private String code;

    /**
     * 制造商
     */
    @NotEmpty(message = "制造商不能为空")
    private String manufacturer;

    /**
     * 压机价格
     */
    @NotNull(message = "压机价格不能为空")
    private BigDecimal price;

    /**
     * 入厂日期
     */
    @NotNull(message = "入厂日期不能为空")
    @JsonFormat(pattern = Constants.DATE)
    private LocalDate entryDate;

    /**
     * 备注
     */
    private String remark;
}
