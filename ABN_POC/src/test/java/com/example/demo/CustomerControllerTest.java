package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.awt.PageAttributes.MediaType;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.dto.Customer;
import com.example.service.CustomerService;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {

	@MockBean
	private CustomerService customerService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testGetCustomer() throws Exception {

		String url = "/customers/23";
		Customer customer = new Customer(30, "Vaibhav", 23);
		Mockito.when(customerService.getCustomer(ArgumentMatchers.anyInt())).thenReturn(customer);
		RequestBuilder builder = MockMvcRequestBuilders.get(url)
				.accept(org.springframework.http.MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(builder).andReturn();
		assertThat(result.getResponse()).isEqualTo(customer);

		// mockMvc.perform(MockMvcRequestBuilders.get(url)).andExpect(MockMvcResultMatchers.status().isOk());
	}

}
