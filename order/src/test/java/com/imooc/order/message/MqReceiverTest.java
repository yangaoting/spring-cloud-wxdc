package com.imooc.order.message;

import com.imooc.order.OrderApplicationTests;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.junit.Assert.*;

@Component
public class MqReceiverTest extends OrderApplicationTests {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void process() {
        amqpTemplate.convertAndSend("myQueue",System.currentTimeMillis());
    }
    @Test
    public void processOrder() {
        amqpTemplate.convertAndSend("myOrder","computer",System.currentTimeMillis());
    }
}