package com.hexaware.salesapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/sales")
	public String sales() {
		return "sales";
	}
	@GetMapping("/marketing")
	public String marketing() {
		return "marketing";
	}
	@GetMapping("/tvsales")
	public String tvsales() {
		return "tvsales";
	}
	@GetMapping("/laptopsales")
	public String laptopsales() {
		return "laptopsales";
	}
}
