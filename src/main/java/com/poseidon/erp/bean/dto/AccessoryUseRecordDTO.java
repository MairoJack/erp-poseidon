package com.poseidon.erp.bean.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.poseidon.erp.common.BaseDTO;
import com.poseidon.erp.common.Constants;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * 配件使用记录 dto
 *
 * @author mario on 2020-12-08
 */
@Getter
@Setter
public class AccessoryUseRecordDTO extends BaseDTO {

    /**
     * 库存ID
     */
    @NotNull(message = "库存ID不能为空")
    private Long inventoryId;

    /**
     * 提取量
     */
    @NotNull(message = "提取量不能为空")
    private Integer quantity;

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
