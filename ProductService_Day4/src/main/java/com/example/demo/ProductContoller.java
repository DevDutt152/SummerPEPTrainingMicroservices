package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductContoller {
	@GetMapping("/product")
	public String getProduct() {
		return "Laptop Price = Rupees 65000/-";
	}
}

