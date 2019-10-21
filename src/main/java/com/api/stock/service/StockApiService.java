package com.api.stock.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.api.stock.controller.Stock;

@Service
public class StockApiService {
String str1;
	String str2;
	String str4;

	String str5;
	private static List<Stock> listStocks=new ArrayList<>();
			
	static{
		listStocks.add(new Stock(101, "NASDAQ-AAPL", 178.02, new Timestamp(System.currentTimeMillis())));
		listStocks.add(new Stock(102, "NASDAQ-NVDA", 250.48, new Timestamp(System.currentTimeMillis())));
		listStocks.add(new Stock(103, "NYSE-ABBV", 113.71, new Timestamp(System.currentTimeMillis())));
		listStocks.add(new Stock(104, "NYSE-GOOG", 1134.42, new Timestamp(System.currentTimeMillis())));
		listStocks.add(new Stock(105, "NYSE-VZ", 48.56, new Timestamp(System.currentTimeMillis())));
	}
	public List<Stock> getAllStocks(){
		return listStocks;
	}
	static{
	}
	
	private StockApiService(){
	}
	
	synchronized public void getTest{
	}
	
	public Stock getStock(int id){
		return listStocks.stream().filter(t->(t.getId()==id)).findFirst().get();
	}

	public void addStock(Stock stock) {
		listStocks.add(stock);
	}

	public void updateStock(Stock stock, int id) {
		for(int i=0; i<listStocks.size();i++){
			Stock s=listStocks.get(i);
			if(s.getId()==id){
				listStocks.set(i, stock);
				return;
			}
		}
	}
	
}
