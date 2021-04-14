package com.poseidon.erp.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.poseidon.erp.bean.entity.FinanceRecord;
import com.poseidon.erp.bean.vo.FinanceChatItemVO;
import com.poseidon.erp.bean.vo.FinanceStatisticsVO;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * 财务记录 Dao 接口
 *
 * @author mario on 2020-12-11
 */
public interface FinanceRecordDao extends BaseMapper<FinanceRecord> {

    FinanceStatisticsVO selectStatistics(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    List<FinanceChatItemVO> selectStatisticsChat(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    BigDecimal statisticsAmount(@Param(Constants.WRAPPER) Wrapper<FinanceRecord> wrapper);
}
