package com.imooc.order.controller;
import com.imooc.order.dto.OrderDTO;
import com.imooc.order.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class SendMessageController {

    @Autowired
    private StreamClient streamClient;

    @GetMapping("/sendMessage")
    public void process(){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("123");
        orderDTO.setBuyerName("");
        orderDTO.setBuyerPhone("");
        orderDTO.setBuyerAddress("");
        orderDTO.setBuyerOpenid("");
        orderDTO.setOrderAmount(new BigDecimal("0"));
        orderDTO.setOrderStatus(0);
        orderDTO.setPayStatus(0);
        orderDTO.setOrderDetailList(null);


        streamClient.output().send(MessageBuilder.withPayload(orderDTO).build());
    }
}
