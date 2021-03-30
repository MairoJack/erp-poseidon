package com.poseidon.erp.bean.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.poseidon.erp.common.BaseDTO;
import com.poseidon.erp.common.Constants;
import com.poseidon.erp.common.Create;
import com.poseidon.erp.common.Update;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 货件 dto
 *
 * @author mario on 2020-12-04
 */
@Getter
@Setter
public class DeliveryDTO extends BaseDTO {

    /**
     * 货件明细
     */
    @NotNull(message = "货件明细不能为空", groups = {Create.class})
    private List<DeliveryDetailDTO> details;

    /**
     * 货件名称
     */
    @NotEmpty(message = "货件名称不能为空", groups = {Create.class, Update.class})
    private String name;

    /**
     * 发货货代
     */
    @NotEmpty(message = "发货货代不能为空", groups = {Create.class, Update.class})
    private String deliveryForwarder;

    /**
     * Amazon货件
     */
    @NotEmpty(message = "Amazon货件不能为空", groups = {Create.class, Update.class})
    private String amazon;

    /**
     * 发货方式
     */
    @NotEmpty(message = "发货方式不能为空", groups = {Create.class, Update.class})
    private String deliveryMethod;

    /**
     * 快递单号
     */
    private String trackingNumber;

    /**
     * 物流费用
     */
    @NotNull(message = "物流费用不能为空", groups = {Create.class, Update.class})
    private BigDecimal freight;

    /**
     * 发货时间
     */
    @NotNull(message = "发货时间不能为空", groups = {Create.class, Update.class})
    @JsonFormat(pattern = Constants.DATETIME)
    private LocalDateTime deliveryTime;

    /**
     * 到货时间
     */
    @JsonFormat(pattern = Constants.DATETIME)
    private LocalDateTime arrivalTime;

    /**
     * 备注
     */
    private String remark;
}
