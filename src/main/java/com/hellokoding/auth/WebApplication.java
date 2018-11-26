package com.hellokoding.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

import com.hellokoding.auth.service.ProductService;




@SpringBootApplication
public class WebApplication   extends SpringBootServletInitializer{
	
	@Autowired
	public ProductService productService;
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(SpringApplicationBuilder.class);
	    }
    public static void main(String[] args) throws Exception {
        SpringApplication.run(WebApplication.class, args);
       
    }
    
    
}
