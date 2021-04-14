package com.poseidon.erp.service;

import com.poseidon.erp.bean.dto.AccessoryUseRecordDTO;
import com.poseidon.erp.bean.entity.AccessoryUseRecord;
import com.poseidon.erp.bean.enums.StockStatus;
import com.poseidon.erp.common.BaseService;
import com.poseidon.erp.dao.AccessoryUseRecordDao;
import com.poseidon.erp.utils.ResponseCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 原料使用记录  Service
 *
 * @author mario on 2020-12-08
 */
@Service
@Transactional
public class AccessoryUseRecordService extends BaseService<AccessoryUseRecordDao, AccessoryUseRecord, AccessoryUseRecordDTO> {

    public AccessoryUseRecordService() {
        super(AccessoryUseRecord.class, ResponseCode.ACCESSORY_USE_RECORD_NOT_FOUND);
    }

    public void create(Long purchaseId, StockStatus stockStatus, Integer quantity, Integer surplusQuantity) {
        AccessoryUseRecord record = new AccessoryUseRecord();
        record.setPurchaseId(purchaseId)
                .setStatus(stockStatus)
                .setQuantity(quantity)
                .setSurplusQuantity(surplusQuantity);
        super.save(record);
    }
}
