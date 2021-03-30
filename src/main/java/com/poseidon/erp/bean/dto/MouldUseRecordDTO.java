package com.poseidon.erp.bean.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.poseidon.erp.bean.enums.StockStatus;
import com.poseidon.erp.common.BaseDTO;
import com.poseidon.erp.common.Constants;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * 原料使用记录 dto
 *
 * @author mario on 2020-12-09
 */
@Getter
@Setter
public class MouldUseRecordDTO extends BaseDTO{

    /**
     * 模具ID
     */
    @NotNull(message = "模具ID不能为空")
    private Long mouldId;

    /**
     * 执行状态(在库、出库)
     */
    @NotNull(message = "执行状态(在库、出库)不能为空")
    private StockStatus status;

    /**
     * 执行人员ID
     */
    @NotNull(message = "执行人员ID不能为空")
    private Long executePersonId;

    /**
     * 执行时间
     */
    @NotNull(message = "执行时间不能为空")
    @JsonFormat(pattern = Constants.DATETIME)
    private LocalDateTime executeTime;

    /**
     * 备注
     */
    private String remark;
}
