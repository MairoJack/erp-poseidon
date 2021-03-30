package com.poseidon.erp.bean.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.poseidon.erp.bean.enums.StockStatus;
import com.poseidon.erp.bean.enums.TaskStatus;
import com.poseidon.erp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 备货计划
 *
 * @author mario on 2021-01-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("erp_stocking_plan")
public class StockingPlan extends BaseEntity {


    /**
     * 备货编号
     */
    private String code;

    /**
     * 产品ID
     */
    private Long productId;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品编号
     */
    private String productCode;

    /**
     * 产品规格
     */
    private String productSpecs;

    /**
     * 产品图片
     */
    private String productImage;

    /**
     * 备注
     */
    private String productRemark;

    /**
     * 备货数量
     */
    private Integer quantity;

    /**
     * 交付日期
     */
    private LocalDate deliveryDate;

    /**
     * 更新日期
     */
    private LocalDateTime modifyTime;

    /**
     * 备货备注
     */
    private String remark;

    /**
     * 状态:待生产，生产中，已完成
     */
    private TaskStatus status;

    /**
     * 完成时间
     */
    private LocalDateTime finishTime;

    /**
     * 完成数量
     */
    private Integer finishQuantity;

    /**
     * 入库时间
     */
    private LocalDateTime stockTime;

    /**
     * 入库数量
     */
    private Integer stockQuantity;

    /**
     * 入库状态
     */
    private StockStatus stockStatus;

}
