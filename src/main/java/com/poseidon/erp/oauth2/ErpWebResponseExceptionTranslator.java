package com.poseidon.erp.oauth2;

import com.poseidon.erp.exception.ErpOAuth2Exception;
import com.poseidon.erp.utils.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;

/**
 * 自定义认证失败响应
 *
 * @author mario on 2019-07-19.
 */
@Slf4j
public class ErpWebResponseExceptionTranslator implements WebResponseExceptionTranslator<OAuth2Exception> {
    @Override
    public ResponseEntity<OAuth2Exception> translate(Exception e) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Cache-Control", "no-store");
        headers.set("Pragma", "no-cache");
        ErpOAuth2Exception erpOAuth2Exception;
        if (e instanceof InvalidTokenException) {
            erpOAuth2Exception = new ErpOAuth2Exception(ResponseCode.REFRESH_TOKEN_EXPIRED);
        } else {
            erpOAuth2Exception = new ErpOAuth2Exception(ResponseCode.USERNAME_OR_PASSWORD_FAIL);
        }
        return new ResponseEntity<>(erpOAuth2Exception, headers, HttpStatus.OK);
    }
}
