package com.div.spring;

import com.div.spring.dao.Offer;
import com.div.spring.dao.OfferRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringbootApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(OfferRepository repository) {
		return (args) -> {

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Offer offer : repository.findAll()) {
				log.info(offer.toString());
			}
		};
	}
}
