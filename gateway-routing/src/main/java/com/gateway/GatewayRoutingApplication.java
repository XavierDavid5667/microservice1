package com.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayRoutingApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayRoutingApplication.class, args);
	}

}
