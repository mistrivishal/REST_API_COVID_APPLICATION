package com.cowin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cowin.model.Vaccine;

@Repository
public interface VaccineDao extends JpaRepository<Vaccine, Integer> {
			
	public Vaccine findByVaccineName(String name);
	
	public Vaccine findByPrice(double price);
	
}
