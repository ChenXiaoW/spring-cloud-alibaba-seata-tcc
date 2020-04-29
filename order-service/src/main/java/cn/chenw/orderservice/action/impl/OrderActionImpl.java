package cn.chenw.orderservice.action.impl;

import cn.chenw.commonservice.model.poto.Order;
import cn.chenw.orderservice.action.OrderAction;
import cn.chenw.orderservice.dao.OrderDao;
import io.seata.rm.tcc.api.BusinessActionContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author chenw
 * @date 2020/4/29 14:13
 */
@Slf4j
@Component
public class OrderActionImpl implements OrderAction {

    @Autowired
    OrderDao orderDao;

    /**
     * 定义两阶段提交
     * name = 一阶段的try方法
     * commitMethod = 二阶段提交方法
     * rollbackMethod = 二阶段回滚方法
     *
     * @param order 参数
     * @return
     * @BusinessActionContextParameter 注解：可以将参数传递到二阶段方法
     */
    @Override
    public boolean prepare(Order order) {
        Integer integer = orderDao.insertOrder(order);
        if (integer == 0) {
            log.error("新增订单失败");
            return false;
        }
        return true;
    }

    /**
     * 二阶段提交
     *
     * @param businessActionContext tcc事务上下文
     * @return
     */
    @Override
    public boolean commit(BusinessActionContext businessActionContext) {
        log.info("---------------------二阶段提交执行---------------------");
        log.info("xid：{},一阶段请求参数：{}", businessActionContext.getXid(), businessActionContext.getActionContext("order"));
        //可以进行mq、redis等操作
        return true;
    }

    /**
     * 二阶段回滚
     *
     * @param businessActionContext tcc事务上下文
     * @return
     */
    @Override
    public boolean rollback(BusinessActionContext businessActionContext) {
        log.info("---------------------二阶段回滚执行---------------------");
        //可以进行redis等回滚操作
        return true;
    }
}
