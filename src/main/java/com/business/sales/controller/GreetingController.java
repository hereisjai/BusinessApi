package com.business.sales.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.business.sales.entity.Customer;
import com.business.sales.entity.repository.CustomerRepository;

@RestController
public class GreetingController {

	@Autowired
	private CustomerRepository repository;

	@RequestMapping("/greet")
	public @ResponseBody String greeting() {
		return "Hello World";
	}

	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		return repository.findAll();
	}
	@PostMapping("/customer")
	public Customer addCustomer(@RequestBody Customer customer){
		return repository.save(customer);
	}
}

