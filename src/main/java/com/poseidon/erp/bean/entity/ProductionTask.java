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
 * 生产任务
 *
 * @author mario on 2020-11-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("erp_production_task")
public class ProductionTask extends BaseEntity {


    /**
     * 批次号
     */
    private String batchNo;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 客户ID
     */
    private Long customerId;

    /**
     * 客户姓名
     */
    private String customerName;

    /**
     * 产品ID
     */
    private Long productId;

    /**
     * 产品编号
     */
    private String productCode;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品图片
     */
    private String productImage;

    /**
     * 产品规格
     */
    private String productSpecs;


    /**
     * 产品备注
     */
    private String productRemark;

    /**
     * 数量
     */
    private Integer quantity;

    /**
     * 原料ID
     */
    private Long materialId;

    /**
     * 原料名称
     */
    private String materialName;

    /**
     * 原料要求
     */
    private String materialRequire;

    /**
     * 色卡ID
     */
    private Long colorCardId;

    /**
     * 色卡名称
     */
    private String colorCardName;

    /**
     * 模具ID
     */
    private Long mouldId;

    /**
     * 模具名称
     */
    private String mouldName;

    /**
     * 压机ID
     */
    private Long pressingMachineId;

    /**
     * 压机名称
     */
    private String pressingMachineName;

    /**
     * 成型要求
     */
    private String shapingRequire;

    /**
     * 印刷要求
     */
    private String printRequire;

    /**
     * 包装要求
     */
    private String packageRequire;

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
     * 备注
     */
    private String remark;

    /**
     * 状态:待生产，生产中，已完成
     */
    private TaskStatus status;

    /**
     * 入库状态
     */
    private StockStatus stockStatus;

    /**
     * 更新时间
     */
    private LocalDateTime modifyTime;

    /**
     * 交付日期
     */
    private LocalDate deliveryDate;

}
