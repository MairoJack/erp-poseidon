package com.poseidon.erp.service;

import com.poseidon.erp.bean.dto.PurchaseDTO;
import com.poseidon.erp.bean.entity.Purchase;
import com.poseidon.erp.common.BaseService;
import com.poseidon.erp.dao.PurchaseDao;
import com.poseidon.erp.exception.BusinessException;
import com.poseidon.erp.utils.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 采购项  Service
 *
 * @author mario on 2020-11-18
 */
@Service
@Transactional
public class PurchaseService extends BaseService<PurchaseDao, Purchase, PurchaseDTO> {

    @Autowired
    private AccessoryInventoryService accessoryInventoryService;
    @Autowired
    private ProductAccessoryService productAccessoryService;

    public PurchaseService() {
        super(Purchase.class, ResponseCode.PURCHASE_NOT_FOUND);
    }

    @Override
    protected void checkExist(Purchase entity, PurchaseDTO dto) {
        if (exist(entity.getId(), "code", dto.getCode())) {
            throw new BusinessException(ResponseCode.PURCHASE_HAS_EXISTED);
        }
        if (exist(entity.getId(), "name", dto.getName())) {
            throw new BusinessException(ResponseCode.PURCHASE_HAS_EXISTED);
        }
    }

    @Override
    protected void modifyExtend(Purchase purchase) {
        productAccessoryService.checkAccessory(purchase.getId());
        accessoryInventoryService.checkStock(purchase.getId());
    }

    @Override
    protected void afterDelete(Purchase purchase) {
        productAccessoryService.checkAccessory(purchase.getId());
        accessoryInventoryService.checkStock(purchase.getId());
    }
}
