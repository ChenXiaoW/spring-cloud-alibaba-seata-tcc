package cn.chenw.orderservice.service.impl;

import cn.chenw.commonservice.model.BaseModel;
import cn.chenw.commonservice.model.dto.CreateOrderDTO;
import cn.chenw.commonservice.model.poto.Order;
import cn.chenw.commonservice.model.poto.Product;
import cn.chenw.commonservice.util.CodeConstant;

import cn.chenw.orderservice.dao.OrderDao;
import cn.chenw.orderservice.manager.ProductFeignManager;
import cn.chenw.orderservice.service.OrderService;
import com.alibaba.fastjson.JSON;

import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author chenw
 * @date 2020/4/29 13:49
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {


	@Autowired
	OrderDao orderDao;

	@Autowired
	ProductFeignManager productFeignManager;

	/**
	 * 创建订单
	 *
	 * @param createOrderDTO
	 * @return
	 */
	@Override
	@GlobalTransactional
	public BaseModel createOrder(CreateOrderDTO createOrderDTO) {
		log.info("xid：{}", RootContext.getXID());
		//查询商品信息
		BaseModel baseModel = productFeignManager.queryProductById(new Product().setPid(createOrderDTO.getPid()));
		if (CodeConstant.FAIL.equals(baseModel.getResult())) {
			return baseModel;
		}
		Product product = JSON.parseObject(JSON.toJSONString(baseModel.getData()), Product.class);
		if (product.getStock() < createOrderDTO.getCount()) {
			return new BaseModel(CodeConstant.QUERY_ERROR, CodeConstant.FAIL, "库存不足", null);
		}
		Order order = new Order();
		BeanUtils.copyProperties(createOrderDTO, order);
		//总价计算
		BigDecimal totalPrice = product.getPrice().multiply(new BigDecimal(order.getCount()));
		order.setTotalprice(totalPrice);
		order.setPname(product.getPname());
		//生成订单
		Integer integer = orderDao.insertOrder(order);
		if (integer == 0) {
			return new BaseModel(CodeConstant.UPDATE_ERROR, CodeConstant.FAIL, "创建订单失败", null);
		}
		//库存扣减
		Integer number = product.getStock() - order.getCount();
		product.setStock(number);
		//更新库存
		baseModel = productFeignManager.updateProductStock(product);
		if (CodeConstant.FAIL.equals(baseModel.getResult())) {
			return baseModel;
		}
		return new BaseModel(CodeConstant.SUCCESS_CODE, CodeConstant.SUCCESS, "创建订单成功", null);
	}
}
