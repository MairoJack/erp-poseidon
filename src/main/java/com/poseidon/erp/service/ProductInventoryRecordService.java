package com.poseidon.erp.service;

import com.poseidon.erp.bean.dto.ProductInventoryRecordDTO;
import com.poseidon.erp.bean.entity.ProductInventoryRecord;
import com.poseidon.erp.bean.enums.StockStatus;
import com.poseidon.erp.common.BaseService;
import com.poseidon.erp.dao.ProductInventoryRecordDao;
import com.poseidon.erp.utils.ResponseCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 产品出入库记录  Service
 *
 * @author mario on 2021-02-01
 */
@Service
@Transactional
public class ProductInventoryRecordService extends BaseService<ProductInventoryRecordDao, ProductInventoryRecord, ProductInventoryRecordDTO> {

    public ProductInventoryRecordService() {
        super(ProductInventoryRecord.class, ResponseCode.PRODUCT_INVENTORY_RECORD_NOT_FOUND);
    }

    public void create(Long productId, StockStatus status, Integer quantity,Integer surplusQuantity) {
        ProductInventoryRecord record = new ProductInventoryRecord();
        record.setProductId(productId)
                .setQuantity(quantity)
                .setSurplusQuantity(surplusQuantity)
                .setStatus(status);
        super.save(record);
    }

}
