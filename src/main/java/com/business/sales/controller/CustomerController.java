package com.business.sales.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.business.sales.entity.Customer;
import com.business.sales.entity.repository.CustomerRepository;

@RestController
public class CustomerController {

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
	
	
	@PutMapping("/customer/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") Long id, @RequestBody Customer customerDetails) {
        Optional<Customer> customerOptional = repository.findById(id);
        if (!customerOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Customer customer = customerOptional.get();
        customer.setName(customerDetails.getName());
        customer.setEmail(customerDetails.getEmail());
        customer.setDoorNo(customerDetails.getDoorNo());
        customer.setCity(customerDetails.getCity());
        customer.setStreet(customerDetails.getStreet());
        customer.setVillage(customerDetails.getVillage());
        customer.setPhone(customerDetails.getPhone());
        customer.setTotalQty(customerDetails.getTotalQty());
        customer.setLatitude(customerDetails.getLatitude());
        customer.setLongitude(customerDetails.getLongitude());
        final Customer updatedCustomer = repository.save(customer);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable(value = "id") Long id) {
        Optional<Customer> customerOptional = repository.findById(id);
        if (!customerOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Customer customer = customerOptional.get();
        repository.delete(customer);
        return ResponseEntity.ok().build();
    }
}

