package com.example;

import com.example.model.CustomerModel;
import com.example.accessingdatajpa.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class DemoApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// save a few customers
//			repository.save(new CustomerModel("Jack", "Bauer"));
//			repository.save(new CustomerModel("Chloe", "O'Brian"));
//			repository.save(new CustomerModel("Kim", "Bauer"));
//			repository.save(new CustomerModel("David", "Palmer"));
//			repository.save(new CustomerModel("Michelle", "Dessler"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (CustomerModel customerModel : repository.findAll()) {
				log.info(customerModel.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			log.info("Customer found with findByDocTypeAndDocNumber(CPF, 185.323.128-29):");
			//List<CustomerModel> customerModel = repository.findByDocTypeAndDocNumber("CPF", "185.323.128-29");
			//log.info(customerModel.toString());
			log.info("--------------------------------");
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Machado'):");
			log.info("--------------------------------------------");
			repository.findByLastName(Optional.of("Machado")).forEach(machado -> log.info(machado.toString()));
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			//  log.info(bauer.toString());
			// }
			log.info("");
		};
	}
}
