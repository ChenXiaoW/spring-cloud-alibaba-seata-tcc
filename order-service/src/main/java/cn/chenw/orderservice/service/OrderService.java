package cn.chenw.orderservice.service;

import cn.chenw.commonservice.model.BaseModel;
import cn.chenw.commonservice.model.dto.CreateOrderDTO;

/**
 * @author  chenw
 * @date  2020/4/29 13:48
 */
public interface OrderService {
    /**
     * 创建订单
     *
     * @param createOrderDTO
     * @return
     */
    BaseModel createOrder(CreateOrderDTO createOrderDTO);
}
