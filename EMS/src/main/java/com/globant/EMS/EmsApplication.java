package com.globant.EMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@SpringBootApplication
@EnableOAuth2Sso
@EnableEncryptableProperties
public class EmsApplication {//implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EmsApplication.class, args);
	}

}
