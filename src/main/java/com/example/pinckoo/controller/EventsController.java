package com.example.pinckoo.controller;

import com.example.pinckoo.config.ApiResponse;
import com.example.pinckoo.entity.Events;
import com.example.pinckoo.mapper.EventsMapper;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventsController {

    @Resource
    EventsMapper eventsMapper;

    @GetMapping
    public ApiResponse<List<Events>> GetEvents() {
        List<Events> responseData = eventsMapper.findAll(); // 示例数据
        return new ApiResponse<>(200, "Success", responseData);
    }
}
