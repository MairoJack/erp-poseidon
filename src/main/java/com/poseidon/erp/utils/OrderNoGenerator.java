package com.poseidon.erp.utils;

import com.poseidon.erp.common.Constants;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author mario on 2020/11/23.
 */
public class OrderNoGenerator {

    public static final String PURCHASE_ORDER_PREFIX = "CG";
    public static final String STOCKING_CODE_PREFIX = "BH";

    private static String next(String prefix) {
        return prefix + LocalDateTime.now().format(DateTimeFormatter.ofPattern(Constants.YYMMDDHHMMSS));
    }

    public static String purchase() {
        return next(PURCHASE_ORDER_PREFIX);
    }

    public static String stockingCode() {
        return next(STOCKING_CODE_PREFIX);
    }

    public static void main(String[] args) {
        System.out.println(purchase());
    }
}
