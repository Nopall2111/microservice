package com.noall.eureka_uts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaUtsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaUtsApplication.class, args);
	}

}
