package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringRestApiTestProjectApplicationTests {
	@Autowired
	private WebApplicationContext webApplicationContext;

	
	private MockMvc mockMvc;
	/*
	 * Spring MockMVC to perform integration testing of Spring webmvc controllers. 
	 * MockMVC class is part of Spring MVC test framework which 
	 * helps in testing the controllers explicitly starting a Servlet container.
	 * 
	 */

	
	@BeforeEach
	public void contextLoads() {
		
		mockMvc=MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		
	}
	
	@Test
	public void testBLITEmployee() throws Exception {
	
		mockMvc.perform(get("/employee")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$.name").value("Sashin"))
				.andExpect(jsonPath("$.designation").value("Manager"))
				.andExpect(jsonPath("$.empId").value("2002"))
				.andExpect(jsonPath("$.salary").value(7000));

	}
	
	
	
	
	
	
	
	
	

}

