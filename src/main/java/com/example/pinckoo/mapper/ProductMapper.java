package com.example.pinckoo.mapper;

import com.example.pinckoo.entity.Product;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

public interface ProductMapper {

    @Select("select * from product")
    List<Product> findAll();

    @Select("select * from product limit #{currentPage},#{pageSize}")
    List<Product> getList(@Param("currentPage") Integer currentPage,@Param("pageSize") Integer pageSize);

    @Select("select count(*) from product")
    Integer getTotal();

    @Select("select * from product where type = #{type}")
    List<Product> findByType(@Param("type") String type);

    @Select("select * from product where type = #{type} limit #{currentPage}, #{pageSize}")
    List<Product> getListByType(@Param("type") String type, @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    @Select("select count(*) from product where type = #{type}")
    Integer getTotalByType(@Param("type") String type);

    @Select("SELECT * FROM product where id = #{id}")
    Optional<Product> getProductById(@Param("id")Integer id);
}

