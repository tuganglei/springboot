package com.cloud.demo.microprovider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.cloud.demo.microprovider.mapper")
@EnableDiscoveryClient
public class MicroProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroProviderApplication.class, args);
	}
}
