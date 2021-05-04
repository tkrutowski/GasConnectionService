package net.focik.gasconnection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GasconnectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(GasconnectionApplication.class, args);
	}

}
