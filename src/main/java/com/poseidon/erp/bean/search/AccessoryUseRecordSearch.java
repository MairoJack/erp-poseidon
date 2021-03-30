package com.poseidon.erp.bean.search;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.poseidon.erp.bean.entity.AccessoryUseRecord;
import com.poseidon.erp.common.BaseSearch;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;

/**
 * 原料使用记录 搜索
 *
 * @author mario on 2020-12-08
 */
@Getter
@Setter
public class AccessoryUseRecordSearch implements BaseSearch<AccessoryUseRecord> {

    @ApiParam(value = "配件ID", name = "purchaseId")
    private Long purchaseId;

    @Override
    public Wrapper<AccessoryUseRecord> query() {
        return Wrappers
                .<AccessoryUseRecord>lambdaQuery()
                .like(ObjectUtil.isNotNull(purchaseId), AccessoryUseRecord::getPurchaseId, purchaseId)
                .orderByDesc(AccessoryUseRecord::getId)
                ;
    }
}
