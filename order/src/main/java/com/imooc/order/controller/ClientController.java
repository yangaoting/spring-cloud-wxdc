package com.imooc.order.controller;

import com.google.gson.Gson;
import com.imooc.order.client.ProductClient;
import com.imooc.order.dto.CartDTO;
import com.imooc.order.dto.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class ClientController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate1;

    @Autowired
    private ProductClient productClient;

    @GetMapping("/getProductMsg")
    public String getProductMsg(){
        //1.第一种方式
        RestTemplate restTemplate = new RestTemplate();

        String response = restTemplate.getForObject("http://localhost:8081/msg", String.class);

        //2.第二种方式
        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
        String url = String.format("http://%s:%s/msg", serviceInstance.getHost(), serviceInstance.getPort());
        response = restTemplate.getForObject(url, String.class);

        //3.第三种方式
        response = restTemplate1.getForObject("http://PRODUCT/msg", String.class);

        //Feign使用
        response = productClient.productmsg();

        log.debug(response);
        return response;
    }

    @GetMapping("/getProductList")
    public String getProductList(){
        List<ProductInfo> list = productClient.listForOrder(Arrays.asList("157875227953464068", "157875196366160022"));
        return new Gson().toJson(list);
    }

    @GetMapping("/productDecreaseStock")
    public String decreaseStock(){
        productClient.decreaseStock(Arrays.asList(new CartDTO("164103465734242707",3)));
        return "ok";
    }
}
