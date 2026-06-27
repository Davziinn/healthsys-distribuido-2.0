package com.HealthSys.Servico_Prontuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class ServicoProntuarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicoProntuarioApplication.class, args);
	}

}
