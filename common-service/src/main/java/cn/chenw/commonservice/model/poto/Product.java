package cn.chenw.commonservice.model.poto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * @author  chenw
 * @date  2020/4/1 10:38
 *
 * 商品
 */
@Data
@Accessors(chain = true)
public class Product {
    //ID
    private Integer pid;
    //商品名称
    private String pname;
    //商品价格
    private BigDecimal price;
    //商品库存
    private Integer stock;
}
