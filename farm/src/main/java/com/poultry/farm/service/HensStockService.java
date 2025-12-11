package com.poultry.farm.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poultry.farm.dto.HensStockRequestdto;
import com.poultry.farm.entity.HenStock;
import com.poultry.farm.repo.HensStockRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HensStockService {
	
	@Autowired
	private HensStockRepo hensStockRepo;

	public HenStock addStock(HensStockRequestdto hensStockRequestdto) {
		
		HenStock henStock = new HenStock();
		
		henStock.setTotalHens(hensStockRequestdto.getHens());
		henStock.setHensLeft(hensStockRequestdto.getHens());
		henStock.setBreed(hensStockRequestdto.getBreed());
		henStock.setDate(LocalDate.now());
		henStock.setBatchCode(hensStockRequestdto.getBatchCode());
		
		log.info("Stock updated Succesfully");
		return hensStockRepo.save(henStock);
	}

	public List<HenStock> getStock() {
		return hensStockRepo.findAll();
	}
	
	public void reduceHensLeft(Long stockId, int hensGiven) {
	    HenStock stock = hensStockRepo.findById(stockId)
	        .orElseThrow(() -> new RuntimeException("Stock not found"));

	    if(stock.getHensLeft() < hensGiven) {
	        throw new RuntimeException("Not enough hens in stock");
	    }

	    stock.setHensLeft(stock.getHensLeft() - hensGiven);

	    hensStockRepo.save(stock);
	}

	public HenStock updateStock(Long id, Integer hens, String breed, String batchCode) {

	    HenStock henStock = hensStockRepo.findById(id)
	            .orElseThrow(() -> new RuntimeException("Stock Not Found with id: " + id));

	    if (hens != null) {
	        henStock.setTotalHens(hens);
	    }

	    log.info(breed);
	    if (breed != null && !breed.isEmpty()) {
	        henStock.setBreed(breed);
	    }

	    if (batchCode != null && !batchCode.isEmpty()) {
	        henStock.setBatchCode(batchCode);
	    }

	    return hensStockRepo.save(henStock);
	}



}
