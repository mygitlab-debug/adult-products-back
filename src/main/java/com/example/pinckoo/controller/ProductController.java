package com.example.pinckoo.controller;

import com.example.pinckoo.config.ApiResponse;
import com.example.pinckoo.entity.Product;
import com.example.pinckoo.mapper.ProductMapper;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    ProductMapper productMapper;

    @GetMapping
    public ApiResponse<List<Product>> GetProduct() {
        List<Product> responseData = productMapper.findAll(); // 示例数据
        return new ApiResponse<>(200, "Success", responseData);
    }

    @GetMapping("/product/page")
    public ApiResponse<List<Product>> GetProductPage() {
        List<Product> responseData = productMapper.findAll(); // 示例数据
        return new ApiResponse<>(200, "Success", responseData);
    }
}
