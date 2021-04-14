package com.poseidon.erp.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.poseidon.erp.bean.dto.DeliveryDetailDTO;
import com.poseidon.erp.bean.entity.DeliveryDetail;
import com.poseidon.erp.bean.entity.ProductInventory;
import com.poseidon.erp.bean.enums.StockStatus;
import com.poseidon.erp.common.BaseService;
import com.poseidon.erp.dao.DeliveryDetailDao;
import com.poseidon.erp.utils.Assert;
import com.poseidon.erp.utils.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 货件明细  Service
 *
 * @author mario on 2020-12-04
 */
@Service
@Transactional
public class DeliveryDetailService extends BaseService<DeliveryDetailDao, DeliveryDetail, DeliveryDetailDTO> {

    @Autowired
    private ProductInventoryService productInventoryService;
    @Autowired
    private ProductInventoryRecordService productInventoryRecordService;

    public DeliveryDetailService() {
        super(DeliveryDetail.class, ResponseCode.DELIVERY_DETAIL_NOT_FOUND);
    }

    /**
     * 批量新增
     */
    public void createBatch(Long deliveryId, List<DeliveryDetailDTO> details) {
        for (DeliveryDetailDTO dto : details) {
            Long productId = dto.getProductId();
            Integer quantity = dto.getQuantity();
            //扣减库存
            ProductInventory productInventory = productInventoryService.deductInventory(productId, quantity);
            DeliveryDetail detail = new DeliveryDetail();
            detail
                    .setDeliveryId(deliveryId)
                    .setProductId(productInventory.getProductId())
                    .setProductName(productInventory.getProductName())
                    .setProductCode(productInventory.getProductCode())
                    .setProductSpecs(productInventory.getProductSpecs())
                    .setQuantity(quantity);
            super.save(detail);
            productInventoryRecordService.create(productId, StockStatus.OUT_STOCK, quantity, productInventory.getInventory());
        }
    }

    /**
     * 批量修改
     */
    public void modifyBatch(Long deliveryId, List<DeliveryDetailDTO> details) {
        for (DeliveryDetailDTO dto : details) {
            Long productId = dto.getProductId();
            DeliveryDetail detail = findDetail(deliveryId, productId);
            Integer actualQuantity = dto.getQuantity() - detail.getQuantity();
            productInventoryService.deductInventory(productId, actualQuantity);
            detail.setQuantity(dto.getQuantity());
            super.updateById(detail);
        }
    }

    public DeliveryDetail findDetail(Long deliveryId, Long productId) {
        return Assert.notFound(super.getOne(Wrappers.<DeliveryDetail>lambdaQuery().eq(DeliveryDetail::getDeliveryId, deliveryId)
                .eq(DeliveryDetail::getProductId, productId)), ResponseCode.DELIVERY_DETAIL_NOT_FOUND);
    }
}
