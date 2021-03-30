package com.poseidon.erp.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.poseidon.erp.oauth2.OAuth2ExceptionJacksonSerializer;
import com.poseidon.erp.utils.ResponseCode;
import lombok.Getter;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * 自定义OAuth2Exception
 *
 * @author mario on 2019-07-19.
 */
@JsonSerialize(using = OAuth2ExceptionJacksonSerializer.class)
public class ErpOAuth2Exception extends OAuth2Exception {

    private static final long serialVersionUID = 914102147564589748L;

    @Getter
    private int code;


    public ErpOAuth2Exception(int code, String msg) {
        super(msg);
        this.code = code;
    }

    public ErpOAuth2Exception(ResponseCode code) {
        super(code.getMsg());
        this.code = code.getCode();
    }
}
