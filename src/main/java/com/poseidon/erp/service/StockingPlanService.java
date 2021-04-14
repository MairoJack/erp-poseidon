package com.poseidon.erp.service;

import com.poseidon.erp.bean.dto.StockingPlanDTO;
import com.poseidon.erp.bean.entity.Product;
import com.poseidon.erp.bean.entity.StockingPlan;
import com.poseidon.erp.bean.enums.StockStatus;
import com.poseidon.erp.bean.enums.TaskStatus;
import com.poseidon.erp.bean.form.StockForm;
import com.poseidon.erp.bean.search.StockingPlanSearch;
import com.poseidon.erp.common.BaseService;
import com.poseidon.erp.dao.StockingPlanDao;
import com.poseidon.erp.exception.BusinessException;
import com.poseidon.erp.utils.OrderNoGenerator;
import com.poseidon.erp.utils.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 备货计划  Service
 *
 * @author mario on 2021-01-20
 */
@Service
@Transactional
public class StockingPlanService extends BaseService<StockingPlanDao, StockingPlan, StockingPlanDTO> {

    @Autowired
    private ProductService productService;
    @Autowired
    private StockingRecordService stockingRecordService;
    @Autowired
    private ProductInventoryService productInventoryService;
    @Autowired
    private AccessoryInventoryService accessoryInventoryService;
    @Autowired
    private ProductInventoryRecordService productInventoryRecordService;

    public StockingPlanService() {
        super(StockingPlan.class, ResponseCode.STOCKING_PLAN_NOT_FOUND);
    }

    @Override
    protected void createExtend(StockingPlan stockingPlan) {
        stockingPlan.setStockStatus(StockStatus.PENDING_STOCK);
        fillProduct(stockingPlan);
    }

    @Override
    protected void modifyExtend(StockingPlan stockingPlan) {
        if (stockingPlan.getStatus() != TaskStatus.PENDING_PRODUCE) {
            throw new BusinessException(ResponseCode.STOCKING_PLAN_IS_NOT_PENDING);
        }
        fillProduct(stockingPlan);
    }

    @Override
    protected void afterDelete(StockingPlan stockingPlan) {
        if (stockingPlan.getStatus() != TaskStatus.PENDING_PRODUCE) {
            throw new BusinessException(ResponseCode.STOCKING_PLAN_IS_NOT_PENDING);
        }
    }


    /**
     * 完成
     */
    public void finish(Long id) {
        StockingPlan plan = super.get(id);
        if (plan.getStatus() != TaskStatus.IN_PRODUCTION) {
            throw new BusinessException(ResponseCode.STOCKING_PLAN_NOT_IN_PRODUCTION);
        }
        Integer totalQuantity = stockingRecordService.findTotalQuantity(plan.getId());

        LocalDateTime now = LocalDateTime.now();
        plan.setFinishQuantity(totalQuantity);
        plan.setStatus(TaskStatus.FINISHED);
        plan.setFinishTime(now);
        super.updateById(plan);
    }

    /**
     * 入库
     */
    public void stock(Long id, StockForm form) {
        StockingPlan stockingPlan = super.get(id);
        Integer stockQuantity = form.getStockQuantity();
        stockingPlan.setStockStatus(StockStatus.IN_STOCK)
                .setStockQuantity(stockQuantity)
                .setStockTime(form.getStockTime())
                .setModifyTime(LocalDateTime.now());
        super.updateById(stockingPlan);
        //入仓库
        Integer inventory = productInventoryService.stock(stockingPlan, stockQuantity);
        //添加入库记录
        productInventoryRecordService.create(stockingPlan.getProductId(), StockStatus.IN_STOCK, stockQuantity, inventory);
        //配件出库
        accessoryInventoryService.outStock(stockingPlan.getProductId(), stockQuantity);
    }

    public BigDecimal statisticsStockQuantity(StockingPlanSearch search) {
        return baseMapper.statisticsStockQuantity(search.query());
    }

    /**
     * 填充产品
     */
    private void fillProduct(StockingPlan stockingPlan) {
        Product product = productService.get(stockingPlan.getProductId());
        stockingPlan
                .setCode(OrderNoGenerator.stockingCode())
                .setProductCode(product.getCode())
                .setProductName(product.getName())
                .setProductSpecs(product.getSpecs())
                .setProductImage(product.getImage())
                .setProductRemark(product.getRemark())
                .setStatus(TaskStatus.PENDING_PRODUCE);
    }

}
