package cn.chenw.productservice.dao;

import cn.chenw.commonservice.model.poto.Product;
import org.springframework.stereotype.Repository;

/**
 * @author  chenw
 * @date  2020/4/1 13:54
 *
 * 数据持久层
 */
@Repository
public interface ProductDao {
    /**
     * 根据商品ID查询商品信息
     *
     * @param product
     * @return
     */
    Product queryProductById(Product product);

    /**
     *
     * 更新商品库存
     *
     * @param product
     * @return
     */
    int updateProductStock(Product product);
}
