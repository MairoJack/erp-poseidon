package com.poseidon.erp.utils;

import com.alibaba.fastjson.JSON;
import lombok.Setter;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author mario on 2019-09-20.
 */
@Setter
public class ResponseHandler {

    private HttpServletResponse response;

    private ResponseCode code;
    private HttpStatus status;

    public ResponseHandler(HttpServletResponse response) {
        this.response = response;
        this.response.setCharacterEncoding("UTF-8");
        this.response.setContentType(MediaType.APPLICATION_JSON_VALUE);
    }

    @SneakyThrows
    public void out() {
        response.setStatus(status.value());
        R result = new R(code);
        PrintWriter printWriter = response.getWriter();
        printWriter.append(JSON.toJSONString(result));
    }
}
