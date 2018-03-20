package com.api.stock.controller.test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.api.stock.controller.Stock;
import com.api.stock.controller.StockApiController;
import com.api.stock.service.StockApiService;
import com.api.stock.test.SpringMainAppTest;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StockApiControllerTest extends SpringMainAppTest {
	
	private MockMvc mvc;
	
	private static final ObjectMapper mapper = new ObjectMapper();
	
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
		List<Stock> stockData=getStockList();
		doReturn(stockData).when(stockApiService).getAllStocks();
		stockApiController.getStocksList();
		MvcResult result = mvc
				.perform(
						get("/api/stocks"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		final String responseBody = result.getResponse().getContentAsString();
		Assert.assertTrue(responseBody.contains("110"));

	}
	
	@Test
	public void testGetStock() throws Exception {
		Stock stockData=getStock();
		doReturn(stockData).when(stockApiService).getStock(any(Integer.class));
		stockApiController.getStock(107);
		MvcResult result = mvc
				.perform(
						get("/api/stocks/{id}", 107))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		final String responseBody = result.getResponse().getContentAsString();
		Assert.assertTrue(responseBody.contains("107"));
	}
	
}
