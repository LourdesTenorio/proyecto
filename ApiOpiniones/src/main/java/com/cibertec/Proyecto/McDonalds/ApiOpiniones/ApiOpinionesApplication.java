package com.cibertec.Proyecto.McDonalds.ApiOpiniones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ApiOpinionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiOpinionesApplication.class, args);
	}

}
