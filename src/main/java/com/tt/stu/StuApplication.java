package com.tt.stu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.tt.stu.dao")
public class StuApplication {

	public static void main(String[] args) {
		SpringApplication.run(StuApplication.class, args);
	}

}

