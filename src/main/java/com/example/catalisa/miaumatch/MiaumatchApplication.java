package com.example.catalisa.miaumatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MiaumatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiaumatchApplication.class, args);
		//System.out.println(new BCryptPasswordEncoder().encode("1234"));
	}

}
