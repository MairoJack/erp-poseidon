package com.poseidon.erp.bean.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.poseidon.erp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 压机
 *
 * @author mario on 2020-11-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("erp_pressing_machine")
public class PressingMachine extends BaseEntity {

    /**
     * 压机型号
     */
    private String name;

    /**
     * 压机编号
     */
    private String code;

    /**
     * 制造商
     */
    private String manufacturer;

    /**
     * 压机价格
     */
    private BigDecimal price;

    /**
     * 入厂日期
     */
    private LocalDate entryDate;

    /**
     * 备注
     */
    private String remark;


}
