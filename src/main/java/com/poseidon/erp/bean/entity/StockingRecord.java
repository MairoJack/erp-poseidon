package com.poseidon.erp.bean.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.poseidon.erp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 备货记录
 *
 * @author mario on 2021-01-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("erp_stocking_record")
public class StockingRecord extends BaseEntity {


    /**
     * 备货计划ID
     */
    private Long stockingPlanId;

    /**
     * 数量
     */
    private Integer quantity;

    /**
     * 完成人员
     */
    private String finishPerson;

    /**
     * 完成人员ID
     */
    private Long finishPersonId;

    /**
     * 完成时间
     */
    private LocalDateTime finishTime;

    /**
     * 备注
     */
    private String remark;


}
