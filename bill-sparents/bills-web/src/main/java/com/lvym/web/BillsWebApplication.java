package com.lvym.web;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@EnableDubbo
public class BillsWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(BillsWebApplication.class,args);
    }
}
