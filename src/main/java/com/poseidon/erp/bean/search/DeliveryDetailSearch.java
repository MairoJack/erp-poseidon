package com.poseidon.erp.bean.search;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.poseidon.erp.bean.entity.DeliveryDetail;
import com.poseidon.erp.common.BaseSearch;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;

/**
 * 货件明细 搜索
 *
 * @author mario on 2020-12-04
 */
@Getter
@Setter
public class DeliveryDetailSearch implements BaseSearch<DeliveryDetail> {

    @ApiParam(value = "货件ID", name = "deliveryId")
    private Long deliveryId;

    @Override
    public Wrapper<DeliveryDetail> query() {
        return Wrappers
                .<DeliveryDetail>lambdaQuery()
                .eq(ObjectUtil.isNotNull(deliveryId), DeliveryDetail::getDeliveryId, deliveryId)
                ;
    }
}
