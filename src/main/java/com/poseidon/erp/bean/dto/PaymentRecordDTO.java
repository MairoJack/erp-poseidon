package com.poseidon.erp.bean.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.poseidon.erp.common.BaseDTO;
import com.poseidon.erp.common.Constants;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 返款记录 dto
 *
 * @author mario on 2020-12-10
 */
@Getter
@Setter
public class PaymentRecordDTO extends BaseDTO {

    /**
     * 客户订单号
     */
    @NotEmpty(message = "客户订单号不能为空")
    private String customerOrderNo;
    /**
     * 返款明细
     */
    @NotNull(message = "返款明细不能为空")
    private List<PaymentRecordDetailDTO> details;

    /**
     * 清单名称
     */
    @NotEmpty(message = " 清单名称不能为空")
    private String name;

    /**
     * 返款时间
     */
    @NotNull(message = "返款时间不能为空")
    @JsonFormat(pattern = Constants.DATETIME)
    private LocalDateTime paymentTime;

    /**
     * 备注
     */
    private String remark;
}
