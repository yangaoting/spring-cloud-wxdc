package com.imooc.product.service;

import com.imooc.product.dto.CartDTO;
import com.imooc.product.dto.ProductInfo;

import java.util.List;

public interface ProductService {

    List<ProductInfo> findUpAll();

    List<ProductInfo> findList(List<String> productIdList);

    void decreaseStock(List<CartDTO> cartDTOList);
}
