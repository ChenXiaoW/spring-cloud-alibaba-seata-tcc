package cn.chenw.productservice.service;

import cn.chenw.commonservice.model.BaseModel;
import cn.chenw.commonservice.model.poto.Product;

/**
 * @author  chenw
 * @date  2020/4/29 15:51
 */
public interface ProductService {

    /**
     * 根据商品ID查询商品信息
     *
     * @param product
     * @return
     */
    BaseModel queryProductById(Product product);

    /**
     *
     * 更新商品库存
     *
     * @param product
     * @return
     */
    BaseModel updateProductStock(Product product);
}
