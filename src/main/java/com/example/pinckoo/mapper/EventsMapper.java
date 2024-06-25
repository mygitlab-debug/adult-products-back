package com.example.pinckoo.mapper;

import com.example.pinckoo.entity.Events;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EventsMapper {

    @Select("select * from events")
    List<Events> findAll();
}
