package com.example.catalisa.miaumatch;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "API para adoção de gatos de rua. ", version = "1", description = "API para cadastro e adoção de gatos de rua. "))
public class MiaumatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiaumatchApplication.class, args);
	}

}
