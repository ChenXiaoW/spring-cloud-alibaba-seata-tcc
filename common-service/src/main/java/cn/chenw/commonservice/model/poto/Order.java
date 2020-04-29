package cn.chenw.commonservice.model.poto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * @author  chenw
 * @date  2020/4/1 10:41
 *
 * 订单
 */
@Data
@Accessors(chain = true)
public class Order {
    //订单ID
    private Integer oid;
    //商品ID
    private Integer pid;
    //商品名称
    private String pname;
    //数量
    private Integer count;
    //总价
    private BigDecimal totalprice;
}
