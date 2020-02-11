package edu.roadrunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class FilmeConsultaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmeConsultaApplication.class, args);
	}

}
