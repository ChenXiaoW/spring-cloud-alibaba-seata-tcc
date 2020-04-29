package cn.chenw.productservice.action.impl;

import cn.chenw.commonservice.model.poto.Product;
import cn.chenw.productservice.dao.ProductDao;
import cn.chenw.productservice.action.ProductAction;
import io.seata.rm.tcc.api.BusinessActionContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author  chenw
 * @date  2020/4/29 15:33
 */
@Slf4j
@Component
public class ProductActionImpl implements ProductAction {

    @Autowired
    ProductDao productDao;

    /**
     * 定义两阶段提交
     * name = 一阶段try方法 ，预提交
     * commitMethod = 二阶段提交
     * rollbackMethod = 二阶段回滚
     *
     * @param product
     * @return
     */
    @Override
    public boolean prepare(Product product) {
        int result = productDao.updateProductStock(product);
        if(result == 0){
            log.error("更新库存失败");
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
        log.info("xid：{}，参数：{}",businessActionContext.getXid(),businessActionContext.getActionContext("product"));
        //执行二阶段提交前的其他操作，例如mq、redis操作
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
        log.info("xid：{}，参数：{}",businessActionContext.getXid(),businessActionContext.getActionContext("product"));
        //执行二阶段回滚前的其他操作,例如redis预扣除库存加回去
        return true;
    }
}
