package com.api.stock.controller.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.api.stock.controller.StockApiController;
import com.api.stock.service.StockApiService;
import com.api.stock.test.SpringMainAppTest;

public class StockApiControllerTest extends SpringMainAppTest {
	
	private MockMvc mvc;
	
	@Mock
	private StockApiService stockApiService;

	@InjectMocks
	private StockApiController stockApiController;
	
	@BeforeClass
	public static void setUp() {
		MockitoAnnotations.initMocks(StockApiController.class);
	}

	@Before
	public void init() {
		mvc = MockMvcBuilders.standaloneSetup(stockApiController)
				.dispatchOptions(true).build();
	}

	
	@Test
	public void testGetStocksList() throws Exception {
		stockApiController.getStocksList();
		MvcResult result = mvc
				.perform(
						get("/api/stocks"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		final String responseBody = result.getResponse().getContentAsString();
		Assert.assertTrue(responseBody.contains("test"));

	}
}
