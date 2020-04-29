package cn.chenw.productservice.service.impl;

import cn.chenw.commonservice.model.BaseModel;
import cn.chenw.commonservice.model.poto.Product;
import cn.chenw.commonservice.util.CodeConstant;
import cn.chenw.productservice.action.ProductAction;
import cn.chenw.productservice.dao.ProductDao;
import cn.chenw.productservice.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author  chenw
 * @date  2020/4/29 15:56
 */
@Slf4j
@Service
public class ProductServiceImpl implements ProductService {
    
    @Autowired
    ProductDao productDao;
    
    @Autowired
    ProductAction productAction;

    /**
     * 根据商品ID查询商品信息
     *
     * @param product
     * @return
     */
    @Override
    public BaseModel queryProductById(Product product) {
        Product result = productDao.queryProductById(product);
        if (null == result) {
            return new BaseModel(CodeConstant.QUERY_ERROR, CodeConstant.FAIL, "查询结果为空，该数据不存在", null);
        }
        return new BaseModel(CodeConstant.SUCCESS_CODE, CodeConstant.SUCCESS, "查询成功", result);
    }


    /**
     * 更新商品库存
     *
     * @param product
     * @return
     */
    @Override
    public BaseModel updateProductStock(Product product) {
        boolean isResult = productAction.prepare(product);
        if (!isResult) {
            return new BaseModel(CodeConstant.QUERY_ERROR, CodeConstant.FAIL, "更新失败", null);
        }
        return new BaseModel(CodeConstant.SUCCESS_CODE, CodeConstant.SUCCESS, "查询成功", null);
    }
}
