package com.poseidon.erp.bean.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.poseidon.erp.bean.enums.TaskStatus;
import com.poseidon.erp.bean.enums.WorkshopType;
import com.poseidon.erp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 模具
 *
 * @author mario on 2020-11-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("erp_workshop_task")
public class WorkshopTask extends BaseEntity {


    /**
     * 生产任务ID
     */
    private Long productionTaskId;

    /**
     * 生产任务状态(待生产,生产中,已完成)
     */
    private TaskStatus status;

    /**
     * 更新时间
     */
    private LocalDateTime modifyTime;

    /**
     * 车间类型(炼胶,成型,印刷,包装)
     */
    private WorkshopType type;

    /**
     * 完成数量
     */
    private Integer finishQuantity;

}
