package com.poseidon.erp.bean.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.poseidon.erp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 其他收支
 *
 * @author mario on 2020-12-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("erp_other_expense")
public class OtherExpense extends BaseEntity {


    /**
     * 收支项目
     */
    private String name;

    /**
     * 金额
     */
    private BigDecimal amount;

    /**
     * 项目时间
     */
    private LocalDateTime itemTime;
    /**
     * 备注
     */
    private String remark;


}
