package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.dao.CustomerDao;
import com.example.dto.Customer;
import com.example.entity.CustomerModel;
import com.example.service.CustomerService;
import com.example.service.CustomerServiceImpl;

@SpringBootTest
public class CustomerServiceImplTest {

	@Autowired
	private CustomerService custService;

	@MockBean
	private CustomerDao custDao;

	@Test
	@DisplayName("Test to find Customer by customerId")
	public void testFindByCustomerId() {
		CustomerModel custModel = new CustomerModel();
		Customer customer = new Customer(23, "Vibhuti", 30);
		custModel.setAge(30);
		custModel.setCustomerName("Vibhuti");
		custModel.setCustomerId(23);
		Mockito.when(custDao.findById(ArgumentMatchers.anyInt())).thenReturn(Optional.of(custModel));
		assertThat(custService.getCustomer(23)).isEqualTo(customer);
	}
}
