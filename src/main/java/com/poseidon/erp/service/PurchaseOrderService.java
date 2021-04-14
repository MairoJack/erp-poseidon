package com.poseidon.erp.service;

import com.poseidon.erp.bean.dto.PurchaseOrderDTO;
import com.poseidon.erp.bean.entity.Purchase;
import com.poseidon.erp.bean.entity.PurchaseOrder;
import com.poseidon.erp.bean.enums.FinanceRecordType;
import com.poseidon.erp.bean.enums.StockStatus;
import com.poseidon.erp.bean.form.StockForm;
import com.poseidon.erp.common.BaseService;
import com.poseidon.erp.dao.PurchaseOrderDao;
import com.poseidon.erp.exception.BusinessException;
import com.poseidon.erp.oauth2.SecurityHolder;
import com.poseidon.erp.utils.OrderNoGenerator;
import com.poseidon.erp.utils.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 采购单  Service
 *
 * @author mario on 2020-11-18
 */
@Service
@Transactional
public class PurchaseOrderService extends BaseService<PurchaseOrderDao, PurchaseOrder, PurchaseOrderDTO> {

    @Autowired
    private PurchaseService purchaseService;
    @Autowired
    private AccessoryInventoryService accessoryInventoryService;
    @Autowired
    private AccessoryUseRecordService accessoryUseRecordService;
    @Autowired
    private FinanceRecordService financeRecordService;

    public PurchaseOrderService() {
        super(PurchaseOrder.class, ResponseCode.PURCHASE_ORDER_NOT_FOUND);
    }

    @Override
    protected void createExtend(PurchaseOrder purchaseOrder) {
        fillPurchase(purchaseOrder);
    }

    @Override
    protected void modifyExtend(PurchaseOrder purchaseOrder) {
        fillPurchase(purchaseOrder);
    }

    private void fillPurchase(PurchaseOrder purchaseOrder) {
        Purchase purchase = purchaseService.get(purchaseOrder.getPurchaseId());
        purchaseOrder
                .setOrderNo(OrderNoGenerator.purchase())
                .setCode(purchase.getCode())
                .setName(purchase.getName())
                .setMobile(purchase.getMobile())
                .setSpecs(purchase.getSpecs())
                .setImage(purchase.getImage())
                .setStockQuantity(0)
                .setSupplier(purchase.getSupplier())
                .setChannelAddress(purchase.getChannelAddress())
                .setAccessory(purchase.isAccessory())
                .setStatus(StockStatus.PENDING_STOCK)
        ;
    }

    /**
     * 确认入库
     */
    public void stock(Long id, StockForm form) {
        PurchaseOrder purchaseOrder = super.get(id);
        if (!purchaseOrder.isAccessory()) {
            throw new BusinessException(ResponseCode.PURCHASE_ORDER_IS_NOT_MATERIAL);
        }
        if (purchaseOrder.getStatus() == StockStatus.IN_STOCK) {
            throw new BusinessException(ResponseCode.PURCHASE_ORDER_MATERIAL_HAS_STOCK);
        }
        purchaseOrder
                .setStatus(StockStatus.IN_STOCK)
                .setStockTime(form.getStockTime())
                .setStockQuantity(form.getStockQuantity())
                .setOperator(SecurityHolder.getUsername());
        super.updateById(purchaseOrder);
        Integer inventory = accessoryInventoryService.stock(purchaseOrder);
        accessoryUseRecordService.create(purchaseOrder.getPurchaseId(), StockStatus.IN_STOCK, form.getStockQuantity(), inventory);
    }

    @Override
    protected void afterCreate(PurchaseOrder purchaseOrder, PurchaseOrderDTO dto) {
        financeRecordService.create(purchaseOrder);
    }

    @Override
    protected void afterModify(PurchaseOrder purchaseOrder, PurchaseOrderDTO dto) {
        financeRecordService.create(purchaseOrder);
    }

    @Override
    protected void afterDelete(PurchaseOrder purchaseOrder) {
        financeRecordService.remove(purchaseOrder.getId(), FinanceRecordType.PURCHASE);
    }
}
