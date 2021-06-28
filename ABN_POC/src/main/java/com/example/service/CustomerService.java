package com.example.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.dto.Customer;
@Component
public interface CustomerService {

	public List<Customer> getCustomers();

	public Customer getCustomer(int customerId);

	public Customer addCustomer(Customer customer);

	public Customer updateCustomer(int customerId, Customer customer);

	public void deleteCustomer(int customerId);

}
