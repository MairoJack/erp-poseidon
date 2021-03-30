package com.poseidon.erp.exception;

import com.poseidon.erp.utils.ResponseCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author mario on 2020/9/21.
 */
@Getter
@Setter
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1063502025721533807L;
    private ResponseCode responseCode;

    public BusinessException(ResponseCode responseCode) {
        super(responseCode.getMsg());
        responseCode.setMsg(String.format(responseCode.getMsg(), ""));
        this.responseCode = responseCode;
    }

    public BusinessException(String prefix, ResponseCode responseCode) {
        super(responseCode.getMsg());
        responseCode.setMsg(String.format(responseCode.getMsg(), prefix + " "));
        this.responseCode = responseCode;
    }
}
