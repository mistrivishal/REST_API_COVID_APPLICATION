package com.cowin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cowin.model.VaccineCenter;


@Repository
public interface VaccineCenterDao extends JpaRepository<VaccineCenter, Integer> {
	
	public VaccineCenter findByVacCenterName(String vacCenterName);
	
}
