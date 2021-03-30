package com.poseidon.erp.service;

import com.poseidon.erp.bean.dto.ProductDTO;
import com.poseidon.erp.bean.entity.Product;
import com.poseidon.erp.bean.vo.ProductVO;
import com.poseidon.erp.common.BaseService;
import com.poseidon.erp.dao.ProductDao;
import com.poseidon.erp.exception.BusinessException;
import com.poseidon.erp.utils.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 产品  Service
 *
 * @author mario on 2020-11-05
 */
@Service
@Transactional
public class    ProductService extends BaseService<ProductDao, Product, ProductDTO> {

    @Autowired
    private ProductAccessoryService productAccessoryService;
    @Autowired
    private ProductInventoryService productInventoryService;
    @Autowired
    private ProductSpuService productSpuService;

    public ProductService() {
        super(Product.class, ResponseCode.PRODUCT_NOT_FOUND);
    }

    @Override
    protected void checkExist(Product entity, ProductDTO dto) {
        if (exist(entity.getId(), "name", dto.getName())) {
            throw new BusinessException(ResponseCode.PRODUCT_HAS_EXISTED);
        }
        if (exist(entity.getId(), "code", dto.getCode())) {
            throw new BusinessException(ResponseCode.PRODUCT_HAS_EXISTED);
        }
    }

    @Override
    protected void createExtend(Product product) {
        productSpuService.get(product.getSpuId());
    }

    @Override
    protected void afterModify(Product product, ProductDTO dto) {
        productInventoryService.checkStock(product.getId());
        productAccessoryService.deleteByProduct(product.getId());
        productAccessoryService.createBatch(product.getId(), dto.getDetails());
    }

    @Override
    protected void afterDelete(Product product) {
        productInventoryService.checkStock(product.getId());
        productAccessoryService.deleteByProduct(product.getId());
    }

    public ProductVO detail(Long id) {
        return new ProductVO(get(id), productAccessoryService.listByProduct(id));
    }

    /**
     * 检查某个SPU是否存在产品
     */
    public void checkProduct(Long spuId) {
        if (super.exist("spu_id", spuId)) {
            throw new BusinessException(ResponseCode.PRODUCT_HAS_EXISTED_NOT_DELETE);
        }
    }
}
