package com.udea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties.Tomcat.Resource;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.GetMapping;

import com.netflix.client.util.Resources;


@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class CustomerEdgeserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerEdgeserverApplication.class, args);
	}
	
//	@FeignClient("item-catalog-service")
	interface ItemClient {

	//	@GetMapping("/items")
	//	Resources<ItemClient> readItems();
	}
}
