package cn.chenw.orderservice.controller;

import cn.chenw.commonservice.model.BaseModel;

import cn.chenw.commonservice.model.dto.CreateOrderDTO;
import cn.chenw.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author  chenw
 * @date  2020/4/29 13:48
 */
@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    /**
     * 创建订单
     *
     * @param createOrderDTO (pid-商品ID,count-数量)
     * @return
     */
    @PostMapping("/insertOrder")
    BaseModel insertOrder(@RequestBody CreateOrderDTO createOrderDTO){
        return orderService.createOrder(createOrderDTO);
    }

}
