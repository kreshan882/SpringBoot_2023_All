package com.kre.springfull.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/*
 * Inside @RestController Auto available @Controller / Component
	@RestController ---> @Controller ---> @Component+@Documented
 */
@RestController
public class HelloController {

	@Value("${some.configk}")
	private String fromConfFile_k;
	
	//http://127.0.0.1:8082/
	//@RequestMapping(value = "/", method = RequestMethod.GET)	
	@GetMapping(value = "/")  //single line can defin, no need above line [@GetMapping->@RequestMapping(method = RequestMethod.GET) ]
	public String helloWorld() {
		return "welcome mesage:"+fromConfFile_k;
	}
}
