package cn.chenw.commonservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author  chenw
 * @date  2020/4/1 10:48
 * 响应模型
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class BaseModel {
    //响应码
    private Integer code;
    //响应结果
    private String result;
    //响应信息
    private String message;
    //响应数据
    private Object data;
}
