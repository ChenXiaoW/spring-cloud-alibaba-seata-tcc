package cn.chenw.orderservice.dao;

import cn.chenw.commonservice.model.poto.Order;
import org.springframework.stereotype.Repository;

/**
 * @author  chenw
 * @date  2020/4/1 11:11
 *
 * 数据持久层
 */
@Repository
public interface OrderDao {
    /**
     * 创建订单
     *
     * @param order
     * @return
     */
    Integer insertOrder(Order order);
}
