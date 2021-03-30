package com.poseidon.erp.common;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author mario on 2020/9/21.
 */
@Getter
@Setter
@Accessors(chain = true)
public class BaseEntity {

    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 操作人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String operator;

    @JsonIgnore
    @Version
    private Long version;
}
