package com.poultry.farm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poultry.farm.dto.HensStockRequestdto;
import com.poultry.farm.entity.Batch;
import com.poultry.farm.service.HensStockService;

@RestController
@RequestMapping("/api/hens")
public class HensStockController {
	
	@Autowired
	private HensStockService hensStockService;
	
	@PostMapping("/addStock")
	public Batch addStock(@RequestBody HensStockRequestdto hensStockRequestdto) {
		
		return hensStockService.addStock(hensStockRequestdto);
	}
	
	
	@GetMapping("/getStock")
	public List<Batch> getStock() {
		
		return hensStockService.getStock();
	}
	
	@PutMapping("/updateStock")
	public Batch updateStock(
	        @RequestParam Long id,
	        @RequestParam(required = false) Integer hens,
	        @RequestParam(required = false) String breed,
	        @RequestParam(required = false) String batchCode
						) {
	    return hensStockService.updateStock(id, hens, breed, batchCode);
	}
}
