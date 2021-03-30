package com.poseidon.erp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.poseidon.erp.bean.entity.ProductAccessory;
import com.poseidon.erp.bean.vo.ProductAccessoryVO;

import java.util.List;

/**
 * 产品 Dao 接口
 *
 * @author mario on 2021-01-18
 */
public interface ProductAccessoryDao extends BaseMapper<ProductAccessory> {

    List<ProductAccessoryVO> listWithInventory(Long productId);

}
