package com.poseidon.erp.bean.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.poseidon.erp.bean.enums.WorkshopType;
import com.poseidon.erp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 车间任务记录
 *
 * @author mario on 2020-12-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("erp_workshop_task_record")
public class WorkshopTaskRecord extends BaseEntity {


    /**
     * 车间任务ID
     */
    private Long workshopTaskId;

    /**
     * 生产任务ID
     */
    private Long productionTaskId;

    /**
     * 数量
     */
    private Integer quantity;

    /**
     * 完成人员ID
     */
    private Long finishPersonId;
    /**
     * 完成人员
     */
    private String finishPerson;

    /**
     * 完成时间
     */
    private LocalDateTime finishTime;

    /**
     * 车间类型(炼胶,成型,印刷,包装)
     */
    private WorkshopType type;

    /**
     * 备注
     */
    private String remark;


}
