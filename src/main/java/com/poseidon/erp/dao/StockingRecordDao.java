package com.poseidon.erp.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.poseidon.erp.bean.entity.StockingRecord;
import com.poseidon.erp.bean.vo.StockingRecordVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 备货记录 Dao 接口
 *
 * @author mario on 2021-01-21
 */
public interface StockingRecordDao extends BaseMapper<StockingRecord> {

    IPage<StockingRecordVO> selectStockingRecordPage(Page<StockingRecord> page, @Param(Constants.WRAPPER) Wrapper<StockingRecord> wrapper);

    List<StockingRecordVO> selectStockingRecordList(@Param(Constants.WRAPPER) Wrapper<StockingRecord> wrapper);

    Integer selectTotalQuantity(Long stockingPlanId);
}
