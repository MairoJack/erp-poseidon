package com.poseidon.erp.service;

import com.poseidon.erp.bean.dto.ProductSpuDTO;
import com.poseidon.erp.bean.entity.ProductSpu;
import com.poseidon.erp.common.BaseService;
import com.poseidon.erp.dao.ProductSpuDao;
import com.poseidon.erp.exception.BusinessException;
import com.poseidon.erp.utils.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 产品Spu  Service
 *
 * @author mario on 2021-03-26
 */
@Service
@Transactional
public class ProductSpuService extends BaseService<ProductSpuDao, ProductSpu, ProductSpuDTO> {

    @Autowired
    private ProductService productService;

    public ProductSpuService() {
        super(ProductSpu.class, ResponseCode.PRODUCT_SPU_NOT_FOUND);
    }

    @Override
    protected void checkExist(ProductSpu entity, ProductSpuDTO dto) {
        if (exist(entity.getId(), "name", dto.getName())) {
            throw new BusinessException(ResponseCode.PRODUCT_SPU_HAS_EXISTED);
        }
        if (exist(entity.getId(), "code", dto.getCode())) {
            throw new BusinessException(ResponseCode.PRODUCT_SPU_HAS_EXISTED);
        }
    }

    @Override
    protected void afterDelete(ProductSpu spu) {
        productService.checkProduct(spu.getId());
    }

}
