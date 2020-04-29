package cn.chenw.orderservice.service.impl;

import cn.chenw.commonservice.model.BaseModel;
import cn.chenw.commonservice.model.dto.CreateOrderDTO;
import cn.chenw.orderservice.action.OrderAction;
import cn.chenw.orderservice.manager.ProductFeignManager;
import cn.chenw.orderservice.service.OrderService;
import io.seata.rm.tcc.api.LocalTCC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author  chenw
 * @date  2020/4/29 13:49
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderAction orderAction;

    @Autowired
    ProductFeignManager productFeignManager;

    /**
     * 创建订单
     *
     * @param createOrderDTO
     * @return
     */
    @Override
    public BaseModel createOrder(CreateOrderDTO createOrderDTO) {



        //orderAction.prepare()
        return null;
    }
}
