package com.poseidon.erp.bean.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.poseidon.erp.bean.enums.StockStatus;
import com.poseidon.erp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 原料使用记录
 *
 * @author mario on 2020-12-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("erp_mould_use_record")
public class MouldUseRecord extends BaseEntity {


    /**
     * 模具ID
     */
    private Long mouldId;

    /**
     * 执行状态(在库、出库)
     */
    private StockStatus status;

    /**
     * 执行人员
     */
    private String executePerson;

    /**
     * 执行人员ID
     */
    private Long executePersonId;

    /**
     * 执行时间
     */
    private LocalDateTime executeTime;

    /**
     * 备注
     */
    private String remark;


}
