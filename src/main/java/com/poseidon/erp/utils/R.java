package com.poseidon.erp.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author mario on 2020/9/21.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@Accessors(chain = true)
public class R<T> {

    private int code;
    private String msg;
    private T data;

    public R(ResponseCode responseCode) {
        this.code = responseCode.getCode();
        this.msg = responseCode.getMsg();
    }

    public static <T> R<T> ok() {
        return result(ResponseCode.SUCCESS, null);
    }

    public static <T> R<T> ok(T data) {
        return result(ResponseCode.SUCCESS, data);
    }

    public static <T> R<T> fail(String msg) {
        return failResult(ResponseCode.FAIL, msg);
    }

    public static <T> R<T> error(ResponseCode responseCode) {
        return result(responseCode, null);
    }

    public static <T> R<T> result(ResponseCode rc, T data) {
        return new R<T>()
                .setCode(rc.getCode())
                .setMsg(rc.getMsg())
                .setData(data);
    }

    public static <T> R<T> failResult(ResponseCode rc, String msg) {
        return new R<T>()
                .setCode(rc.getCode())
                .setMsg(msg);
    }
}
