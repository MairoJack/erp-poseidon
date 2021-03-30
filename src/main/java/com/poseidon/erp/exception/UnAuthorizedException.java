package com.poseidon.erp.exception;

import com.poseidon.erp.utils.ResponseCode;

/**
 * @author mario on 2020/5/12
 */
public class UnAuthorizedException extends RuntimeException {

    private ResponseCode responseCode;

    public UnAuthorizedException(ResponseCode responseCode) {
        super(responseCode.getMsg());
        this.responseCode = responseCode;
    }
}
