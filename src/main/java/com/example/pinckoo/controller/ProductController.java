package com.example.pinckoo.controller;

import com.example.pinckoo.config.ApiResponse;
import com.example.pinckoo.entity.Product;
import com.example.pinckoo.mapper.ProductMapper;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    @GetMapping("/page")
    public ApiResponse<Map<String, Object>> GetProductPage(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) Boolean isNew,  // 新增的查询参数
            @RequestParam(required = false) Boolean isHot,  // 新增的查询参数
            @RequestParam Integer currentPage,
            @RequestParam Integer pageSize) {

        currentPage = (currentPage-1)*pageSize;

        List<Product> responseData;
        Integer total;
        Integer neww = (isNew != null) ? (isNew ? 1 : 0) : null;
        Integer hott = (isHot != null) ? (isHot ? 1 : 0) : null;
        responseData = productMapper.getList(type,neww, hott,currentPage,pageSize); // 示例数据
        total = productMapper.getTotal(type,neww, hott);


        //封装数据
        Map<String, Object> res = new HashMap<>();
        res.put("data",responseData);
        res.put("total",total);
        return new ApiResponse<>(200, "Success", res);
    }

    @GetMapping("/detail")
    public ApiResponse<Product> GetProductById(@RequestParam Integer id) {
        Optional<Product> productOptional = productMapper.getProductById(id);
        if (productOptional.isPresent()) {
            Product Product = productOptional.get();
            return new ApiResponse<>(200, "Success", Product);
        } else {
            return new ApiResponse<>(404, "Product Not Found", null);
        }
    }
}
