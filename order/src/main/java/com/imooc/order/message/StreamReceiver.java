package com.imooc.order.message;

import com.imooc.order.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableBinding(StreamClient.class)
public class StreamReceiver {

    @StreamListener(StreamClient.INPUT)
    @SendTo(StreamClient.OUTPUT)
    public OrderDTO processINPUT(OrderDTO message){
        log.info("StreamReceiver processINPUT:{}",message);
        return message;
    }

    @StreamListener(StreamClient.OUTPUT)
    public void processOUTPUT(OrderDTO message){
        log.info("StreamReceiver processOUTPUT:{}",message);
    }
}
