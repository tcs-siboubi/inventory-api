package com.example.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class InventoryApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryApiApplication.class, args);
	}

}
