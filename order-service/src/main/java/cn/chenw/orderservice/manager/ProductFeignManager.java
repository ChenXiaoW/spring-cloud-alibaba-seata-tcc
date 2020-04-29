package cn.chenw.orderservice.manager;

import cn.chenw.commonservice.model.BaseModel;
import cn.chenw.commonservice.model.poto.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author  chenw
 * @date  2020/4/1 14:39
 *
 * 远程调用产品服务
 */
@Component
@FeignClient(value = "${Product.serviceName}",contextId = "product")
public interface ProductFeignManager {
    /**
     * 查询商品信息
     *
     * @param product
     * @return
     */
    @PostMapping("${Product.queryProductById}")
    BaseModel queryProductById(@RequestBody Product product);

    /**
     * 更新库存
     *
     * @param product
     * @return
     */
    @PostMapping("${Product.updateProductStock}")
    BaseModel updateProductStock(@RequestBody Product product);
}
