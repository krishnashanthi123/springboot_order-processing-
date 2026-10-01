package com.example.order_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication /*
						 * (exclude = { //DataSourceAutoConfiguration.class })
						 */
public class OrderserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderserviceApplication.class, args);

        System.out.println("=================================");
        System.out.println("ORDER SERVICE STARTED SUCCESSFULLY");
        System.out.println("=================================");
    }
}