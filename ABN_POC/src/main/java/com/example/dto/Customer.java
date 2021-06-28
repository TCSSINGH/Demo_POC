package com.example.dto;

import java.util.List;

public class Customer {
	public Customer(int customerId, String customerName, int age) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.age = age;
	}

	private int customerId;
	private String customerName;
	private int age;
	private List<Address> adresses;
	private Contact contact;

	public int getCustomerId() {
		return customerId;
	}

	public List<Address> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Address> adresses) {
		this.adresses = adresses;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
