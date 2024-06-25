package com.example.pinckoo.entity;

import lombok.Data;

@Data
public class LeaveMessage {
    private Integer id;
    private String name;
    private String phone;
    private String email;
    private String message;
}
