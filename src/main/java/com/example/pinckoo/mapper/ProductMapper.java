package com.example.pinckoo.mapper;

import com.example.pinckoo.entity.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductMapper {

    @Select("select * from product")
    List<Product> findAll();
}

