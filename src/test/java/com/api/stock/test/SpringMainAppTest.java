package com.api.stock.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.api.stock.controller.Stock;

@RunWith(MockitoJUnitRunner.class)
public class SpringMainAppTest {

	public List<Stock> getStockList() {
		List<Stock> stockList = new ArrayList<Stock>();
		Stock stock = new Stock();
		stock.setCurrentPrice(112.09);
		stock.setId(107);
		stock.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		stock.setName("Nasdaq");
		stockList.add(stock);
		
		Stock stock1 = new Stock();
		stock.setCurrentPrice(114.09);
		stock.setId(108);
		stock.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		stock.setName("Nasdaq-SSL");
		stockList.add(stock1);
		
		Stock stock2 = new Stock();
		stock.setCurrentPrice(119.09);
		stock.setId(109);
		stock.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		stock.setName("Nasdaq-ABC");
		stockList.add(stock2);
		
		Stock stock3 = new Stock();
		stock.setCurrentPrice(149.09);
		stock.setId(110);
		stock.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		stock.setName("Nasdaq-Aer");
		stockList.add(stock3);
		return stockList;
	}
	
	public Stock getStock() {
		Stock stock = new Stock();
		stock.setCurrentPrice(112.09);
		stock.setId(107);
		stock.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		stock.setName("Nasdaq");
		return stock;
	}
}
