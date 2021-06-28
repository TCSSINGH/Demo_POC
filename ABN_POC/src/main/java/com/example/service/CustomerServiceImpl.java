package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.dao.CustomerDao;
import com.example.dto.Address;
import com.example.dto.Contact;
import com.example.dto.Customer;
import com.example.entity.CustomerModel;
import com.example.exception.CustomerNotFoundException;

@Component
@Service
@Qualifier("custService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao custDao;

	ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		List<Customer> customers = new ArrayList<>();
		List<CustomerModel> custList = custDao.findAll();
		if (custList.isEmpty()) {
			throw new CustomerNotFoundException();
		} else {
			custList.stream().forEach(cust -> {
				Customer customer = null;
				List<Address> addresses = new ArrayList<>();
//				if (cust.getAdresses() != null) {
//					addresses = cust.getAdresses().stream().map(add -> {
//
//						return add;
//
//					}).collect(Collectors.toList());
//				}
				Contact contact = new Contact();
				contact.setContactNumber(cust.getContact().getContactNumber());
				customer = modelMapper.map(cust, Customer.class);
				customer.setContact(contact);
				customers.add(customer);

			});
		}
		return customers;
	}

	@Override
	public Customer getCustomer(int customerId) {
		// TODO Auto-generated method stub
		Optional<CustomerModel> customerModel = custDao.findById(customerId);
		Customer customer = null;
		if (customerModel.isPresent()) {
			CustomerModel custModel = customerModel.get();
			customer = modelMapper.map(custModel, Customer.class);
		}
		return customer;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		CustomerModel custModel = new CustomerModel();

		if (customer != null) {
			modelMapper.map(customer, custModel);
			custDao.save(custModel);
		} else {
			throw new CustomerNotFoundException();
		}
		return customer;
	}

	@Override
	public Customer updateCustomer(int customerId, Customer customer) {
		// TODO Auto-generated method stub
		Optional<CustomerModel> customerModel = custDao.findById(customerId);
		if (customerModel.isEmpty() || customerModel == null) {
			throw new CustomerNotFoundException();
		} else {
			CustomerModel updateCustomer = new CustomerModel();
			updateCustomer.setAge(customer.getAge());
			updateCustomer.setCustomerName(customer.getCustomerName());
			updateCustomer.setCustomerId(customerModel.get().getCustomerId());

			custDao.save(updateCustomer);
		}
		return customer;
	}

	@Override
	public void deleteCustomer(int customerId) {
		// TODO Auto-generated method stub
		Optional<CustomerModel> custModel = custDao.findById(customerId);
		if (custModel.isPresent()) {
			custDao.delete(custModel.get());
		} else {
			throw new CustomerNotFoundException();
		}

	}

}
