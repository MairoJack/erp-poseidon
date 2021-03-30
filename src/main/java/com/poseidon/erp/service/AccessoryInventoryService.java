package com.poseidon.erp.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.poseidon.erp.bean.dto.AccessoryInventoryDTO;
import com.poseidon.erp.bean.entity.AccessoryInventory;
import com.poseidon.erp.bean.entity.ProductAccessory;
import com.poseidon.erp.bean.entity.PurchaseOrder;
import com.poseidon.erp.bean.enums.StockStatus;
import com.poseidon.erp.common.BaseService;
import com.poseidon.erp.dao.AccessoryInventoryDao;
import com.poseidon.erp.exception.BusinessException;
import com.poseidon.erp.utils.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 原料库存  Service
 *
 * @author mario on 2020-12-08
 */
@Service
@Transactional
public class AccessoryInventoryService extends BaseService<AccessoryInventoryDao, AccessoryInventory, AccessoryInventoryDTO> {

    @Autowired
    private ProductAccessoryService productAccessoryService;

    @Autowired
    private AccessoryUseRecordService accessoryUseRecordService;

    public AccessoryInventoryService() {
        super(AccessoryInventory.class, ResponseCode.ACCESSORY_INVENTORY_NOT_FOUND);
    }

    /**
     * 入库
     */
    public void stock(PurchaseOrder purchaseOrder) {
        Integer stockQuantity = purchaseOrder.getStockQuantity();
        AccessoryInventory accessoryInventory = super.getOne(Wrappers.<AccessoryInventory>lambdaQuery().eq(AccessoryInventory::getPurchaseId, purchaseOrder.getPurchaseId()));
        if (null == accessoryInventory) {
            accessoryInventory = new AccessoryInventory();
            accessoryInventory
                    .setPurchaseId(purchaseOrder.getPurchaseId())
                    .setPurchaseName(purchaseOrder.getName())
                    .setPurchaseCode(purchaseOrder.getCode())
                    .setPurchaseImage(purchaseOrder.getImage())
                    .setPurchaseSupplier(purchaseOrder.getSupplier())
                    .setUseQuantity(0)
                    .setInventory(stockQuantity)
                    .setHistoryInventory(stockQuantity);
        } else {
            accessoryInventory.setInventory(accessoryInventory.getInventory() + stockQuantity);
            accessoryInventory.setHistoryInventory(accessoryInventory.getHistoryInventory() + stockQuantity);
        }
        accessoryInventory.setStockTime(purchaseOrder.getStockTime());
        super.saveOrUpdate(accessoryInventory);
    }

    /**
     * 出库
     */
    public void outStock(Long productId, int quantity) {
        for (ProductAccessory productAccessory : productAccessoryService.listByProduct(productId)) {
            AccessoryInventory accessoryInventory = super.getOne(Wrappers.<AccessoryInventory>lambdaQuery().eq(AccessoryInventory::getPurchaseId, productAccessory.getPurchaseId()));
            if (accessoryInventory != null) {
                int total = quantity * productAccessory.getQuantity();
                accessoryInventory.setInventory(accessoryInventory.getInventory() - total);
                if (!super.updateById(accessoryInventory)) {
                    throw new BusinessException(ResponseCode.REPEAT_SUBMIT);
                }
                accessoryUseRecordService.create(productAccessory.getPurchaseId(), StockStatus.OUT_STOCK, total);
            }
        }
    }

    /**
     * 检查配件是否入库
     */
    public void checkStock(Long purchaseId) {
        AccessoryInventory accessoryInventory = super.getOne(Wrappers.<AccessoryInventory>lambdaQuery().eq(AccessoryInventory::getPurchaseId, purchaseId));
        if (accessoryInventory != null && accessoryInventory.getInventory() > 0) {
            throw new BusinessException(ResponseCode.PURCHASE_ACCESSORY_HAS_STOCK);
        }
    }
}
