package com.poseidon.erp.component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.poseidon.erp.oauth2.SecurityHolder;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author mario on 2020/5/18
 */
@Component
public class MybatisMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "operator", String.class, SecurityHolder.getRealname());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.fillStrategy(metaObject, "operator", SecurityHolder.getRealname());
    }

    @Override
    public MetaObjectHandler fillStrategy(MetaObject metaObject, String fieldName, Object fieldVal) {
        setFieldValByName(fieldName, fieldVal, metaObject);
        return this;
    }
}
