package com.poultry.farm.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poultry.farm.entity.HenStock;

@Repository
public interface HensStockRepo extends JpaRepository<HenStock, Long>{

}
