package com.example.pinckoo.controller;

import com.example.pinckoo.config.ApiResponse;
import com.example.pinckoo.entity.LeaveMessage;
import com.example.pinckoo.mapper.LeaveMessageMapper;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/leaveMessage")
public class LeaveMessageController {

    @Resource
    LeaveMessageMapper leaveMessageMapper;

    /**
     * 新增留言
     */
    @PostMapping
    public ApiResponse addMessage(@RequestBody LeaveMessage leaveMessage) {
        leaveMessageMapper.save(leaveMessage);
        return new ApiResponse<>(200, "Success", null);
    };

}
