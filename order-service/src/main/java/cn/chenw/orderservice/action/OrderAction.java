package cn.chenw.orderservice.action;

import cn.chenw.commonservice.model.poto.Order;
import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

/**
 * @author chenw
 * @date 2020/4/29 13:53
 */
@LocalTCC
public interface OrderAction {
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
    @TwoPhaseBusinessAction(name = "CreateOrderActionOne", commitMethod = "commit", rollbackMethod = "rollback")
    boolean prepare(@BusinessActionContextParameter(paramName = "order") Order order);

    /**
     * 二阶段提交
     *
     * @param businessActionContext tcc事务上下文
     * @return
     */
    boolean commit(BusinessActionContext businessActionContext);

    /**
     * 二阶段回滚
     *
     * @param businessActionContext tcc事务上下文
     * @return
     */
    boolean rollback(BusinessActionContext businessActionContext);
}
