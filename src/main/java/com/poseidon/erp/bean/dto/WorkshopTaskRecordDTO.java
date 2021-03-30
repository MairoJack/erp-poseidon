package com.poseidon.erp.bean.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.poseidon.erp.common.BaseDTO;
import com.poseidon.erp.common.Constants;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * 车间任务记录 dto
 *
 * @author mario on 2020-12-01
 */
@Getter
@Setter
public class WorkshopTaskRecordDTO extends BaseDTO{

    /**
     * 车间任务ID
     */
    @NotNull(message = "车间任务ID不能为空")
    private Long workshopTaskId;

    /**
     * 数量
     */
    @NotNull(message = "数量不能为空")
    private Integer quantity;

    /**
     * 完成人员ID
     */
    @NotNull(message = "完成人员不能为空")
    private Long finishPersonId;

    /**
     * 完成时间
     */
    @NotNull(message = "完成时间不能为空")
    @JsonFormat(pattern = Constants.DATETIME)
    private LocalDateTime finishTime;

    /**
     * 备注
     */
    private String remark;
}
