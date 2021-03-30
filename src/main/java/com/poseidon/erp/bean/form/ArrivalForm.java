package com.poseidon.erp.bean.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.poseidon.erp.common.Constants;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * 入库 form
 *
 * @author mario on 2020-11-23
 */
@Getter
@Setter
public class ArrivalForm {

    /**
     * 到货时间
     */
    @NotNull(message = "到货时间不能为空")
    @JsonFormat(pattern = Constants.DATETIME)
    private LocalDateTime arrivalTime;

}
