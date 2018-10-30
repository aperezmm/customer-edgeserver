package com.udea;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.udea.CustomerEdgeserverApplication.ItemClient;

@RestController
public class GoodItemApiAdapterRestController {
	
	private final ItemClient itemClient;
	
	public GoodItemApiAdapterRestController(ItemClient itemClient) {
		this.itemClient = itemClient;
	}
	
	public Collection<Item> fallback() {
	    return new ArrayList<>();
	}
	
	@HystrixCommand(fallbackMethod = "fallback")
	@GetMapping("/top-brands")
	/*	public Collection<Item> goodItems() {
		return itemClient.readItems()
				.getContent()
				.stream()
				.filter(this::isGreat)
				.collect(Collectors.toList());
	} */
	
	private boolean isGreat(Item item) {
		return item.getName() != null &&  
				!item.getName().equals("Verduras") &&
				!item.getName().equals("Frutas") &&
				!item.getName().equals("Mekato");
	}

}
