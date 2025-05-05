package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpWebController {
	 @GetMapping("/") 
	    public String helloWorld() { 
	        return "Alive.."; 
	    } 

}
