package net.focik.gasconnection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableEurekaClient
//@EnableCircuitBreaker
@ComponentScan(basePackages = {"net.focik.addresses", "net.focik.gasconnection"})
public class GasconnectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(GasconnectionApplication.class, args);
	}

}
