package com.example.pinckoo.mapper;

import com.example.pinckoo.entity.LeaveMessage;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LeaveMessageMapper {

    @Select("select * from leaveMessage")
    List<LeaveMessage> findAll();

    @Update("INSERT INTO `leave_message` (`name`, `phone`, `email`, `message`) VALUES (#{name}, #{phone}, #{email}, #{message});")
    @Transactional
    void save(LeaveMessage leaveMessage);
}
