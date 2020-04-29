package cn.chenw.productservice.controller;

import cn.chenw.commonservice.model.BaseModel;
import cn.chenw.commonservice.model.poto.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author  chenw
 * @date  2020/4/29 13:27
 */
@RestController
@RequestMapping("/api/product")
public class ProductController {



    /**
     * 查询商品信息
     *
     * @param product (pid-商品ID)
     * @return
     */
    @PostMapping("/queryProductById")
    BaseModel queryProductById(@RequestBody Product product){
        return null;
    }

    /**
     * 更新商品库存
     *
     * @param product (pid-商品ID，stock-库存)
     * @return
     */
    @PostMapping("/updateProductStock")
    BaseModel updateProductStock(@RequestBody Product product){
        return null;
    }
}
