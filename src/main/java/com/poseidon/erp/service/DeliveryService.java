package com.poseidon.erp.service;

import cn.hutool.core.bean.BeanUtil;
import com.poseidon.erp.bean.dto.DeliveryDTO;
import com.poseidon.erp.bean.entity.Delivery;
import com.poseidon.erp.common.BaseService;
import com.poseidon.erp.dao.DeliveryDao;
import com.poseidon.erp.exception.BusinessException;
import com.poseidon.erp.utils.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * 货件  Service
 *
 * @author mario on 2020-12-04
 */
@Service
@Transactional
public class DeliveryService extends BaseService<DeliveryDao, Delivery, DeliveryDTO> {

    @Autowired
    private DeliveryDetailService deliveryDetailService;

    public DeliveryService() {
        super(Delivery.class, ResponseCode.DELIVERY_NOT_FOUND);
    }

    @Override
    public void create(DeliveryDTO dto) {
        Delivery delivery = new Delivery();
        BeanUtil.copyProperties(dto, delivery, false);
        delivery.setArrival(delivery.getArrivalTime() != null);
        super.save(delivery);
        deliveryDetailService.createBatch(delivery.getId(), dto.getDetails());
    }

    /**
     * 到货
     */
    public void arrival(Long id, LocalDateTime arrivalTime) {
        Delivery delivery = super.get(id);
        if (delivery.isArrival()) {
            throw new BusinessException(ResponseCode.DELIVERY_ALREADY_ARRIVAL);
        }
        delivery.setArrival(true)
                .setArrivalTime(arrivalTime);
        super.updateById(delivery);
    }
}
