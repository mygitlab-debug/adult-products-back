package com.example.pinckoo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.pinckoo.mapper")
public class PinckooApplication {

	public static void main(String[] args) {
		SpringApplication.run(PinckooApplication.class, args);
	}

}
