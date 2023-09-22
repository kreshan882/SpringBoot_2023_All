package com.cloudedply.kre.controlor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomePageControlor {

	@GetMapping("/home")
	public String homeTest() {
		System.out.println("Hi Kreshan, home call Test is success.......");
		System.out.println("call ===>  http://localhost:8081/home");
		return "<h1>Hi Kreshan, home call Test is success.......</h1>";
	}
}
