package com.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.Customer;
import com.example.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getCustomers() {
		return ResponseEntity.ok().body(customerService.getCustomers());
	}

	@GetMapping("/customers/{customerId}")
	public ResponseEntity<Customer> getCustomer(@PathVariable int customerId) {
		return ResponseEntity.ok().body(customerService.getCustomer(customerId));
	}

	@PostMapping("/customers")
	public ResponseEntity<Customer> addCustomer(@Validated @RequestBody Customer customer) {
		return ResponseEntity.ok().body(customerService.addCustomer(customer));
	}

	@PutMapping("/customers/{customerId}")
	public ResponseEntity<Customer> updateCustomer(@Validated @PathVariable int customerId,
			@RequestBody Customer customer) {
		return ResponseEntity.ok().body(customerService.updateCustomer(customerId, customer));
	}

	@DeleteMapping("/customers/{customerId}")
	public HttpStatus deleteCustomer(@PathVariable int customerId) {
		return HttpStatus.OK;
	}
}
