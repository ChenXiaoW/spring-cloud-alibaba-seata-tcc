# srping-cloud-alibaba-seata-tcc
# seata-tcc模式

- common-service ：公共服务
- order-service ：订单服务，创建订单，采用at模式
- product-service ：商品服务，商品查询，库存扣减，采用tcc模式

更新时间：2020/04/29
