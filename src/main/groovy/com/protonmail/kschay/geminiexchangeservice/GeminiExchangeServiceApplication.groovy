package com.protonmail.kschay.geminiexchangeservice

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

@SpringBootApplication
class GeminiExchangeServiceApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		application.sources(GeminiExchangeServiceApplication)
	}

	static void main(String[] args) {
		SpringApplication.run(GeminiExchangeServiceApplication, args)
	}

}
