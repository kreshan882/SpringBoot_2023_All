package com.kre.sprjwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController {


    @RequestMapping({ "/hello" })
    public String firstPage() {
    	System.out.println("helooooooo");
        return "Hello World";
    }
    
    @GetMapping({ "/wlist" })
    public String wlist() {
    	System.out.println("white list page................");
        return "white list page................";
    }
}