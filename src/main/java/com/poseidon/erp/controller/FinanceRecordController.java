package com.poseidon.erp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.poseidon.erp.bean.entity.FinanceRecord;
import com.poseidon.erp.bean.search.FinanceRecordSearch;
import com.poseidon.erp.bean.search.StatisticsSearch;
import com.poseidon.erp.bean.vo.FinanceChatVO;
import com.poseidon.erp.bean.vo.FinanceStatisticsVO;
import com.poseidon.erp.service.FinanceRecordService;
import com.poseidon.erp.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * 财务记录控制器
 *
 * @author mario on 2020-12-11
 */
@Api(value = "财务记录管理", tags = "财务记录管理")
@RestController
@RequestMapping("finance_records")
public class FinanceRecordController {

    private final FinanceRecordService service;

    public FinanceRecordController(FinanceRecordService service) {
        this.service = service;
    }

    @ApiOperation(value = "分页")
    @GetMapping()
    public R<IPage<FinanceRecord>> page(Page<FinanceRecord> page, FinanceRecordSearch search) {
        return R.ok(service.page(page, search));
    }

    @ApiOperation(value = "统计数据")
    @GetMapping("statistics/data")
    public R<FinanceStatisticsVO> statisticsData(StatisticsSearch search) {
        return R.ok(service.statistics(search));
    }

    @ApiOperation(value = "统计图表")
    @GetMapping("statistics/chat")
    public R<FinanceChatVO> statisticsChat(StatisticsSearch search) {
        return R.ok(service.statisticsChat(search));
    }

    @ApiOperation(value = "统计总金额")
    @GetMapping("statistics/amount")
    public R<BigDecimal> statisticsAmount(FinanceRecordSearch search) {
        return R.ok(service.statisticsAmount(search));
    }
}
