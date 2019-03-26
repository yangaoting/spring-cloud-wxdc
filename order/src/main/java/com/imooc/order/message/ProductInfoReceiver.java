package com.imooc.order.message;


import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProductInfoReceiver {

    private static final String PRODUCT_STOCK_TEMPLATE = "product_stock_%s";

    @Autowired
    private StringRedisTemplate redisTemplate;

    @RabbitListener(queuesToDeclare = @Queue("productInfo"))
    public void process(String message){
        //roductInfo productInfo = (ProductInfo) JSONObject.toBean(JSONObject.fromObject(message), ProductInfo.class);
        JSONArray jsonArray = JSONArray.fromObject(message);
        log.info(message);

        for (Object o : jsonArray) {
            JSONObject jsonObject = JSONObject.fromObject(o);

            redisTemplate.opsForValue().set(
                    String.format(PRODUCT_STOCK_TEMPLATE,jsonObject.getString("productId")),
                    String.valueOf(jsonObject.getInt("productStock")));
        }

    }
}
