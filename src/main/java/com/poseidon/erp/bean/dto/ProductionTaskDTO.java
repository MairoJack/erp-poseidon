package com.poseidon.erp.bean.dto;

import com.poseidon.erp.common.BaseDTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 生产任务 dto
 *
 * @author mario on 2020-11-27
 */
@Getter
@Setter
public class ProductionTaskDTO extends BaseDTO{

    /**
     * 订单号
     */
    @NotEmpty(message = "订单号不能为空")
    private String orderNo;

    /**
     * 生产批次号
     */
    @NotEmpty(message = "生产批次号不能为空")
    private String batchNo;

    /**
     * 产品ID
     */
    @NotNull(message = "产品ID不能为空")
    private Long productId;

    /**
     * 数量
     */
    @NotNull(message = "数量不能为空")
    private Integer quantity;

    /**
     * 原料ID
     */
    @NotNull(message = "原料ID不能为空")
    private Long materialId;

    /**
     * 原料要求
     */
    @NotEmpty(message = "原料要求不能为空")
    private String materialRequire;

    /**
     * 色卡ID
     */
    @NotNull(message = "色卡ID不能为空")
    private Long colorCardId;

    /**
     * 模具ID
     */
    @NotNull(message = "模具ID不能为空")
    private Long mouldId;

    /**
     * 压机ID
     */
    @NotNull(message = "压机ID不能为空")
    private Long pressingMachineId;

    /**
     * 成型要求
     */
    @NotEmpty(message = "成型要求不能为空")
    private String shapingRequire;

    /**
     * 印刷要求
     */
    @NotEmpty(message = "印刷要求不能为空")
    private String printRequire;

    /**
     * 包装要求
     */
    @NotEmpty(message = "包装要求不能为空")
    private String packageRequire;

    /**
     * 备注
     */
    private String remark;

}
