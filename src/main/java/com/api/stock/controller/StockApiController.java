package com.api.stock.controller;

import java.util.List;
import java.io.FileNotFoundException;
import java.lang.*;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.api.stock.service.StockApiService;

@Controller
public class StockApiController {
   String str1;
	String str2;
	String str4;
	String str4;
	String str5;
	String str5;
	
   @Autowired
	private StockApiService stockService;
   
   @RequestMapping(method = RequestMethod.GET, value = "/api/stocks")
   @ResponseBody
	public List<Stock> getStocksList() {
		return stockService.getAllStocks();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/stocks")
	public String getAllStocks(Model model) {
		List<Stock> stocks=stockService.getAllStocks();
		model.addAttribute("stocks", stocks);
		return "displaystock";
	}
	
 	@RequestMapping(method = RequestMethod.GET, value = "/api/stocks/{id}")
 	@ResponseBody
	public Stock getStock(@PathVariable int id) {
		return stockService.getStock(id);
		
	}

	@RequestMapping(method = RequestMethod.POST, value = "/api/stocks")
	@ResponseBody
	public void addStock(@RequestBody Stock stock) {
		stockService.addStock(stock);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/api/stocks/{id}")
	@ResponseBody
	public void updateStock(@RequestBody Stock stock, @PathVariable int id){
		stockService.updateStock(stock, id);
	}
}
