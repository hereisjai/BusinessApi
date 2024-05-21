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
import org.springframework.web.bind.annotation.CrossOrigin;

import com.business.sales.entity.Customers;
import com.business.sales.entity.repository.CustomerRepository;

@RestController
@CrossOrigin(origins ="*")
public class CustomerController {

	@Autowired
	private CustomerRepository repository;

	@RequestMapping("/greet")
	public @ResponseBody String greeting() {
		return "Hello World People";
	}

	@GetMapping("/customers")
	public List<Customers> getCustomers(){
		return repository.findAll();
	}

    @GetMapping("/customerInfo/{id}")
	public Optional<Customers> getCustomerbyId(@PathVariable(value = "id") Long id){
		return repository.findById(id);
	}

	@PostMapping("/customer")
	public Customers addCustomer(@RequestBody Customers customer){
		return repository.save(customer);
	}
	
	
	@PutMapping("/customer/{id}")
    public ResponseEntity<Customers> updateCustomer(@PathVariable(value = "id") Long id, @RequestBody Customers customerDetails) {
        Optional<Customers> customerOptional = repository.findById(id);
        if (!customerOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Customers customer = customerOptional.get();
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
        final Customers updatedCustomer = repository.save(customer);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable(value = "id") Long id) {
        Optional<Customers> customerOptional = repository.findById(id);
        if (!customerOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
            Customers customer = customerOptional.get();
        repository.delete(customer);
        return ResponseEntity.ok().build();
    }
}

