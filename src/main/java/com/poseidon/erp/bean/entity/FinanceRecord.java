package com.poseidon.erp.bean.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.poseidon.erp.bean.enums.FinanceRecordType;
import com.poseidon.erp.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * 财务记录
 *
 * @author mario on 2020-12-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("erp_finance_record")
public class FinanceRecord extends BaseEntity {

    /**
     * 关联ID
     */
    private Long relationId;

    /**
     * 项目名称
     */
    private String name;

    /**
     * 类型(采购、原料、工资、销售额、其他)
     */
    private FinanceRecordType type;

    /**
     * 金额
     */
    private BigDecimal amount;

    /**
     * 备注
     */
    private String remark;


}
