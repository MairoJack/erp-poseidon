package com.poseidon.erp.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.poseidon.erp.bean.dto.ProductInventoryDTO;
import com.poseidon.erp.bean.entity.ProductInventory;
import com.poseidon.erp.bean.entity.StockingPlan;
import com.poseidon.erp.bean.enums.StockStatus;
import com.poseidon.erp.common.BaseService;
import com.poseidon.erp.dao.ProductInventoryDao;
import com.poseidon.erp.exception.BusinessException;
import com.poseidon.erp.utils.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 产品库存  Service
 *
 * @author mario on 2020-12-04
 */
@Service
@Transactional
public class ProductInventoryService extends BaseService<ProductInventoryDao, ProductInventory, ProductInventoryDTO> {

    @Autowired
    private ProductInventoryRecordService productInventoryRecordService;

    public ProductInventoryService() {
        super(ProductInventory.class, ResponseCode.PRODUCT_INVENTORY_NOT_FOUND);
    }

    /**
     * 入库(更新库存)
     */
    public Integer stock(StockingPlan plan, Integer stockQuantity) {
        ProductInventory productInventory = super.getOne(Wrappers.<ProductInventory>lambdaQuery().eq(ProductInventory::getProductId, plan.getProductId()));
        Integer inventory = stockQuantity;
        if (null == productInventory) {
            productInventory = new ProductInventory();
            productInventory.setProductId(plan.getProductId())
                    .setProductCode(plan.getProductCode())
                    .setProductName(plan.getProductName())
                    .setProductSpecs(plan.getProductSpecs())
                    .setProductImage(plan.getProductImage())
                    .setProductRemark(plan.getProductRemark())
                    .setInventory(plan.getStockQuantity())
                    .setHistoryInventory(plan.getStockQuantity());
        } else {
            inventory = productInventory.getInventory() + stockQuantity;
            productInventory.setInventory(inventory);
            productInventory.setHistoryInventory(productInventory.getHistoryInventory() + stockQuantity);
        }
        productInventory.setStockTime(plan.getStockTime());
        super.saveOrUpdate(productInventory);
        return inventory;
    }

    /**
     * 扣减库存
     */
    public ProductInventory deductInventory(Long productId, Integer quantity) {
        ProductInventory productInventory = super.getOne(Wrappers.<ProductInventory>lambdaQuery().eq(ProductInventory::getProductId, productId));
        if (quantity != 0) {
            String productName = productInventory.getProductName();
            Integer inventory = productInventory.getInventory();
            if (inventory < quantity) {
                throw new BusinessException(productName, ResponseCode.PRODUCT_INVENTORY_SHORTAGE);
            }
            productInventory.setInventory(inventory - quantity);
            if (!super.updateById(productInventory)) {
                throw new BusinessException(productName, ResponseCode.PRODUCT_INVENTORY_SHORTAGE);
            }
        }
        return productInventory;
    }

    /**
     * 检查配件是否入库
     */
    public void checkStock(Long productId) {
        ProductInventory productInventory = super.getOne(Wrappers.<ProductInventory>lambdaQuery().eq(ProductInventory::getProductId, productId));
        if (productInventory != null && productInventory.getInventory() > 0) {
            throw new BusinessException(ResponseCode.PRODUCT_HAS_STOCK);
        }
    }

    @Override
    protected void afterModify(ProductInventory productInventory, ProductInventoryDTO dto) {
        //盘库
        productInventoryRecordService.create(productInventory.getProductId(), StockStatus.STOCKTAKING, dto
                .getInventory(), dto.getInventory());
    }
}
