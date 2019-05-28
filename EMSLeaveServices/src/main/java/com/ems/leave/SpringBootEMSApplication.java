package com.ems.leave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 
 * @author yogesh.patil
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootEMSApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEMSApplication.class, args);
	}
}