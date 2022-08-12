package com.covidapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.covidapp.module.VaccinationCenter;

public interface VaccineCenterDao extends JpaRepository<VaccinationCenter, Integer>{

}
