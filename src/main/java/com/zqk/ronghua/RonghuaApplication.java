package com.zqk.ronghua;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.zqk.ronghua.mapper")
public class RonghuaApplication {

    public static void main(String[] args) {
        SpringApplication.run(RonghuaApplication.class, args);
    }

}
