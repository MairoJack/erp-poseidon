package com.poseidon.erp.oauth2;


import com.poseidon.erp.utils.ResponseCode;
import com.poseidon.erp.utils.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义Token认证失败
 *
 * @author mario on 2019-07-24.
 */
@Component
public class ResourceAuthExceptionEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException {
        ResponseHandler handler = new ResponseHandler(response);
        handler.setStatus(HttpStatus.OK);
        if (e instanceof InsufficientAuthenticationException) {
            handler.setCode(ResponseCode.ACCESS_TOKEN_EXPIRED);
        } else {
            handler.setCode(ResponseCode.UNAUTHORIZED);
        }
        handler.out();
    }
}
