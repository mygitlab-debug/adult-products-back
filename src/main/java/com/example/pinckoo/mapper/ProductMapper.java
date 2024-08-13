package com.example.pinckoo.mapper;

import com.example.pinckoo.entity.Product;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

public interface ProductMapper {

    @Select("select * from product")
    List<Product> findAll();

    @Select("<script>" +
            "SELECT * FROM product " +
            "<where>" +
            "<if test='type != null and type != \"\"'> AND type = #{type} </if>" +
            "<if test='isNew != null'> AND isNew = #{isNew} </if>" +
            "<if test='isHot != null'> AND isHot = #{isHot} </if>" +
            "</where>" +
            "LIMIT #{currentPage}, #{pageSize}" +
            "</script>")
    List<Product> getList(@Param("type") String type,
                          @Param("isNew") Integer isNew,
                          @Param("isHot") Integer isHot,
                          @Param("currentPage") Integer currentPage,
                          @Param("pageSize") Integer pageSize);

    @Select("<script>" +
            "SELECT COUNT(*) FROM product " +
            "<where>" +
            "<if test='type != null and type != \"\"'> AND type = #{type} </if>" +
            "<if test='isNew != null'> AND isNew = #{isNew} </if>" +
            "<if test='isHot != null'> AND isHot = #{isHot} </if>" +
            "</where>" +
            "</script>")
    Integer getTotal(@Param("type") String type,
                     @Param("isNew") Integer isNew,
                     @Param("isHot") Integer isHot);

    @Select("SELECT * FROM product where id = #{id}")
    Optional<Product> getProductById(@Param("id")Integer id);
}

