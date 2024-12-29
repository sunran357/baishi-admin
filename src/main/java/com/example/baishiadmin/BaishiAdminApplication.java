package com.example.baishiadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.baishiadmin.mapper")
public class BaishiAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaishiAdminApplication.class, args);
    }

}
