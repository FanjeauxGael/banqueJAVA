package fr.limayrac.banque.controller;

import fr.limayrac.banque.Service.ClientService;
import fr.limayrac.banque.Service.CompteService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@ComponentScan({"fr.limayrac.banque"})
@EntityScan("fr.limayrac.banque.model")
@EnableJpaRepositories("fr.limayrac.banque.repository")
@Controller
public class BanqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(BanqueApplication.class, args);
	}

}
