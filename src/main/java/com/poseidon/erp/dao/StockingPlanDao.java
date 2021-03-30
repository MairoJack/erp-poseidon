package com.poseidon.erp.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.poseidon.erp.bean.entity.StockingPlan;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * 备货计划 Dao 接口
 *
 * @author mario on 2021-01-20
 */
public interface StockingPlanDao extends BaseMapper<StockingPlan> {

    BigDecimal statisticsStockQuantity(@Param(Constants.WRAPPER) Wrapper<StockingPlan> wrapper);

}
