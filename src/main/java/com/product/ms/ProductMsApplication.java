package com.product.ms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductMsApplication {

	private static final Logger logger = LoggerFactory.getLogger(ProductMsApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(ProductMsApplication.class, args);
		logger.info("Welcome to Product Microservice!");
	}

}
