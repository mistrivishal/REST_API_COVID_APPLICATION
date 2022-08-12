package com.covidapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.covidapp.module.VaccineInventory;

public interface VaccineInventoryDao extends JpaRepository<VaccineInventory, Integer> {

}
