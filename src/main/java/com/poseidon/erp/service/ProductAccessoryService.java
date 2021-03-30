package com.poseidon.erp.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.collect.Lists;
import com.poseidon.erp.bean.dto.ProductAccessoryDTO;
import com.poseidon.erp.bean.entity.ProductAccessory;
import com.poseidon.erp.bean.entity.Purchase;
import com.poseidon.erp.bean.vo.ProductAccessoryVO;
import com.poseidon.erp.common.BaseService;
import com.poseidon.erp.dao.ProductAccessoryDao;
import com.poseidon.erp.exception.BusinessException;
import com.poseidon.erp.utils.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 产品  Service
 *
 * @author mario on 2021-01-18
 */
@Service
@Transactional
public class ProductAccessoryService extends BaseService<ProductAccessoryDao, ProductAccessory, ProductAccessoryDTO> {

    @Autowired
    private PurchaseService purchaseService;

    public ProductAccessoryService() {
        super(ProductAccessory.class, ResponseCode.PRODUCT_ACCESSORY_NOT_FOUND);
    }

    /**
     * 批量新增
     */
    public void createBatch(Long productId, List<ProductAccessoryDTO> details) {
        List<ProductAccessory> list = Lists.newArrayList();
        for (ProductAccessoryDTO dto : details) {
            Purchase purchase = purchaseService.get(dto.getPurchaseId());
            ProductAccessory detail = new ProductAccessory();
            detail
                    .setProductId(productId)
                    .setPurchaseId(purchase.getId())
                    .setPurchaseName(purchase.getName())
                    .setPurchaseCode(purchase.getCode())
                    .setPurchaseSpecs(purchase.getSpecs())
                    .setPurchaseImage(purchase.getImage())
                    .setQuantity(dto.getQuantity());
            list.add(detail);
        }
        super.saveBatch(list);
    }

    /**
     * 根据产品ID查询配件列表
     */
    public List<ProductAccessory> listByProduct(Long productId) {
        return super.list(Wrappers.<ProductAccessory>lambdaQuery().eq(ProductAccessory::getProductId, productId));
    }

    /**
     * 根据产品ID删除配件列表
     */
    public void deleteByProduct(Long productId) {
        super.remove(Wrappers.<ProductAccessory>lambdaQuery().eq(ProductAccessory::getProductId, productId));
    }

    public List<ProductAccessoryVO> listWithInventory(Long productId) {
        return baseMapper.listWithInventory(productId);
    }

    public void checkAccessory(Long purchaseId) {
        if (exist("purchase_id", purchaseId)) {
            throw new BusinessException(ResponseCode.PURCHASE_ACCESSORY_HAS_EXISTED);
        }
    }
}
