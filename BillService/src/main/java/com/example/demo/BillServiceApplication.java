package com.example.demo;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.example.demo.beans.CustomerBean;
import com.example.demo.model.Bill;
import com.example.demo.proxies.CustomerServiceProxy;
import com.example.demo.repository.BillRepository;

import lombok.AllArgsConstructor;

@SpringBootApplication
@EnableDiscoveryClient
@AllArgsConstructor
@EnableFeignClients
public class BillServiceApplication implements CommandLineRunner {

	CustomerServiceProxy customerProxy;
	BillRepository billRepository;

	public static void main(String[] args) {
		SpringApplication.run(BillServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Question 1
		CustomerBean customer = customerProxy.findCustomerById(1L);
		System.out.println(customer.getName() + ": " + customer.getEmail());
		// Question 2
		Bill bill = new Bill();
		bill.setBillingdate(new Date());
		bill.setCustomerID(customer.getId());
		// Question 3
		bill.setCustomer(customer);
		billRepository.save(bill);
		// Question 4
		ProductBean p1 = 
	}

}
