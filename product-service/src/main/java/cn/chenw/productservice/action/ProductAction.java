package cn.chenw.productservice.action;

import cn.chenw.commonservice.model.poto.Product;
import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

/**
 * @author  chenw
 * @date  2020/4/29 15:09
 */
public interface ProductAction {
    /**
     * 定义两阶段提交
     * name = 一阶段try方法 ，预提交
     * commitMethod = 二阶段提交
     * rollbackMethod = 二阶段回滚
     *
     * @param product
     * @return
     */
    @TwoPhaseBusinessAction(name = "updateProduct",commitMethod = "commit",rollbackMethod = "rollback")
    boolean prepare(@BusinessActionContextParameter(paramName = "product")Product product);

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
     * @param businessActionContext  tcc事务上下文
     * @return
     */
    boolean rollback(BusinessActionContext businessActionContext);
}
