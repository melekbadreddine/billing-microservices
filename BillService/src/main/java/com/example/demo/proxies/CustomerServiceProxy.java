package com.example.demo.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.beans.CustomerBean;

@FeignClient(name = "CUSTOMERSERVICE")
public interface CustomerServiceProxy {
	@GetMapping("/customers/{id}")
	public CustomerBean findCustomerById(@PathVariable(name = "id") long l);
}