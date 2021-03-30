package com.poseidon.erp.utils;

import lombok.Getter;
import lombok.Setter;

/**
 * @author mario on 2020/9/21.
 */
public enum ResponseCode {

    SUCCESS(2000, "成功"),
    FAIL(2001, "失败"),
    UNAUTHORIZED(2002, "认证失败"),
    PERMISSION_DENIED(2003, "权限不足"),
    ACCESS_TOKEN_EXPIRED(2004, "access_token过期"),
    REFRESH_TOKEN_EXPIRED(2005, "refresh_token过期"),
    MEDIA_UPLOAD_FAIL(2007, "上传失败"),
    MEDIA_DELETE_FAIL(2008, "删除失败"),
    MEDIA_NOT_FOUND(2009, "媒体不存在"),
    MEDIA_UPLOAD_LIMIT(2010, "上传限制1~5"),
    REPEAT_SUBMIT(2011, "重复提交"),
    USERNAME_OR_PASSWORD_FAIL(2012, "您的账号不存在或密码不正确"),

    //----10001~~10099 ------ 信息管理中心 start
    USER_NOT_FOUND(10001, "员工不存在"),
    USER_NAME_HAS_EXISTED(10002, "员工账号已存在"),
    USER_IDENTITY_HAS_EXISTED(10003, "员工身份证号已存在"),
    USER_MOBILE_HAS_EXISTED(10004, "员工手机号已存在"),
    ROLE_NOT_FOUND(10005, "角色不存在"),
    ROLE_HAS_EXISTED(10006, "角色已存在"),
    PERMISSION_NOT_FOUND(10007, "权限不存在"),
    PERMISSION_HAS_EXISTED(10008, "权限已存在"),
    CUSTOMER_NOT_FOUND(10009, "客户不存在"),
    CUSTOMER_HAS_EXISTED(10010, "客户已存在"),
    MOULD_NOT_FOUND(10013, "模具不存在"),
    MOULD_HAS_EXISTED(10014, "模具已存在"),
    PRESSING_MACHINE_NOT_FOUND(10015, "压机不存在"),
    PRESSING_MACHINE_HAS_EXISTED(10016, "压机已存在"),
    COLOR_CARD_NOT_FOUND(10017, "色卡不存在"),
    COLOR_CARD_HAS_EXISTED(10018, "采购单已存在"),
    //----10001~~10999 ------ 信息管理中心 end

    //----10101~~10199 ------ 产品部门 start
    PURCHASE_NOT_FOUND(10101, "采购项不存在"),
    PURCHASE_HAS_EXISTED(10102, "采购项已存在"),
    PURCHASE_ORDER_NOT_FOUND(10103, "采购单不存在"),
    PURCHASE_ORDER_HAS_EXISTED(10104, "采购单已存在"),
    PURCHASE_ORDER_MATERIAL_UN_STOCK(10105, "原料未入库"),
    PURCHASE_ORDER_MATERIAL_HAS_STOCK(10106, "原料已入库"),
    PURCHASE_ORDER_IS_NOT_MATERIAL(10107, "非原料无法入库"),
    PURCHASE_IS_NOT_MATERIAL(10108, "非原料"),
    PRODUCT_NOT_FOUND(10101, "产品子体不存在"),
    PRODUCT_HAS_EXISTED(10102, "产品子体已存在"),
    PRODUCT_HAS_EXISTED_NOT_DELETE(10103, "存在产品子体"),
    PRODUCT_ACCESSORY_NOT_FOUND(10104, "产品配件不存在"),
    STOCKING_PLAN_NOT_FOUND(10105, "配货计划不存在"),
    STOCKING_PLAN_NOT_IN_PRODUCTION(10406, "非生产中备货计划"),
    STOCKING_PLAN_IS_NOT_PENDING(10107, "非待生产备货计划"),
    STOCKING_PLAN_FINISHED(10108, "备货计划已完成"),
    PURCHASE_ACCESSORY_HAS_STOCK(10109, "该配件库存未清理"),
    PURCHASE_ACCESSORY_HAS_EXISTED(10110, "该配件为产品⼀部分"),
    PRODUCT_HAS_STOCK(10111, "该产品库存未清理"),
    PRODUCT_SPU_NOT_FOUND(10112, "产品不存在"),
    PRODUCT_SPU_HAS_EXISTED(10113, "产品已存在"),

    //----10101~~10199 ------ 产品部门 end

    //----10201~~10299 ------ 仓储部门 start
    PRODUCT_INVENTORY_NOT_FOUND(10201, "%s库存不存在"),
    PRODUCT_INVENTORY_SHORTAGE(10202, "%s库存不足"),
    DELIVERY_NOT_FOUND(10203, "货件不存在"),
    DELIVERY_DETAIL_NOT_FOUND(10204, "货件明细不存在"),
    ACCESSORY_INVENTORY_NOT_FOUND(10205, "配件库存不存在"),
    ACCESSORY_USE_RECORD_NOT_FOUND(10206, "配寄件使用记录不存在"),
    ACCESSORY_INVENTORY_SHORTAGE(10207, "配件库存不足"),
    MOULD_USE_RECORD_NOT_FOUND(10208, "模具使用记录不存在"),
    DELIVERY_ALREADY_ARRIVAL(10209, "已确认到货"),
    PRODUCT_INVENTORY_RECORD_NOT_FOUND(10210, "产品库存记录不存在"),
    //----10201~~10299 ------ 仓储部门 end

    //----10301~~10399 ------ 市场部门 start
    CUSTOMER_ORDER_NOT_FOUND(10301, "客户订单不存在"),
    CUSTOMER_ORDER_HAS_EXISTED(10302, "客户订单已存在"),
    CUSTOMER_ORDER_DETAIL_NOT_FOUND(10303, "客户订单明细不存在"),
    PRODUCTION_TASK_NOT_FOUND(10304, "生产订单不存在"),
    PRODUCTION_TASK_HAS_EXISTED(10305, "生产批次号已存在"),
    PAYMENT_RECORD_NOT_FOUND(10306, "返款记录不存在"),
    PAYMENT_RECORD_DETAIL_NOT_FOUND(10307, "返款记录明细不存在"),
    CUSTOMER_ORDER_ALREADY_FINISHED(10308, "客户订单已完结"),
    PRODUCTION_TASK_IS_NOT_PENDING(10309, "非待生产订单无法删除"),
    //----10301~~10399 ------ 市场部门 end

    //----10401~~10499 ------ 备货任务 start
    WORKSHOP_TASK_NOT_FOUND(10401, "车间任务不存在"),
    WORKSHOP_TASK_RECORD_NOT_FOUND(10402, "车间任务记录不存在"),
    WORKSHOP_TASK_FINISHED(10403, "任务记录已完成"),
    WORKSHOP_TASK_NOT_IN_PRODUCTION(10404, "非生产中任务"),
    STOCKING_RECORD_NOT_FOUND(10401, "备货记录不存在"),
    //----10401~~10499 ------ 备货任务 end

    //----10501~~10599 ------ 财务部门 start
    PAYROLL_FOUND(10501, "工资单不存在"),
    PAYROLL_HAS_EXISTED(10502, "工资单已存在"),
    OTHER_EXPENSE_FOUND(10503, "收支项不存在"),
    FINANCE_RECORD_NOT_FOUND(10504, "财务记录不存在"),
    OPERATING_EXPENSE_NOT_FOUND(10505, "运营支出不存在"),
    CROSS_BORDER_INCOME_NOT_FOUND(10506, "跨境返款不存在"),
    //----10501~~10599 ------ 财务部门 end

    UN_KNOW(-1, "未知错误");

    @Getter
    private final int code;
    @Getter
    @Setter
    private String msg;

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
