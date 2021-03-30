package com.poseidon.erp.utils;


import com.poseidon.erp.exception.BusinessException;

/**
 * @author mario on 2020/9/21.
 */
public class Assert<T> {

    public static <T> T notFound(T t, ResponseCode responseCode) {
        if (t == null) {
            throw new BusinessException(responseCode);
        }
        return t;
    }

    public static void exist(Boolean isExist, ResponseCode responseCode) {
        if (isExist) {
            throw new BusinessException(responseCode);
        }
    }
}
