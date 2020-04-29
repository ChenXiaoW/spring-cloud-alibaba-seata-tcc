package cn.chenw.commonservice.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author  chenw
 * @date  2020/4/1 14:03
 *
 * 创建订单请求参数
 */
@Data
@Accessors(chain = true)
public class CreateOrderDTO {

    //商品ID
    private Integer pid;

    //数量
    private Integer count;
}
