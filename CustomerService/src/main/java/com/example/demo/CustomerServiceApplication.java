package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository, 
			RepositoryRestConfiguration configuration) {
		return args->{
			configuration.exposeIdsFor(Customer.class);
			customerRepository.save(new Customer(null, "c1","c1@gmail.com"));
			customerRepository.save(new Customer(null, "c2","c2@gmail.com"));
			
			customerRepository.save(new Customer(null, "c3","c3@gmail.com"));
			customerRepository.findAll().forEach(System.out::println);
			
		};
		
	}

}

