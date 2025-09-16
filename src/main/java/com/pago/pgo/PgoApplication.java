package com.pago.pgo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PgoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PgoApplication.class, args);
	}

}
