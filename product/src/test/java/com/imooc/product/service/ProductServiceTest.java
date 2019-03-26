package com.imooc.product.service;

import com.imooc.product.ProductApplicationTests;
import com.imooc.product.dto.CartDTO;
import com.imooc.product.dto.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ProductServiceTest extends ProductApplicationTests {

    @Autowired
    private ProductService productService;

    @Test
    public void findUpAll() {
        List<ProductInfo> list = productService.findUpAll();
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void findList(){
        List<ProductInfo> list = productService.findList(Arrays.asList("157875227953464068", "157875196366160022"));
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void decreaseStock(){
        CartDTO cartDTO = new CartDTO("157875196366160022",2);
        productService.decreaseStock(Arrays.asList(cartDTO));
    }
}