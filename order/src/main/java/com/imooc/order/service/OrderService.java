package com.imooc.order.service;

import com.imooc.order.dto.OrderDTO;

public interface OrderService {

   OrderDTO create(OrderDTO orderDTO);

   OrderDTO finish(String orderId);
}
