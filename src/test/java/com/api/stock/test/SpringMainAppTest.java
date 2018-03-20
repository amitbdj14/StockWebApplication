package com.api.stock.test;
import java.sql.Timestamp;

import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.api.stock.controller.Stock;

@RunWith(MockitoJUnitRunner.class)
public class SpringMainAppTest {

	public Stock getStock() {
		Stock stock = new Stock();
		stock.setCurrentPrice(112.09);
		stock.setId(107);
		stock.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		stock.setName("Nasdaq");
		return stock;
	}
}
