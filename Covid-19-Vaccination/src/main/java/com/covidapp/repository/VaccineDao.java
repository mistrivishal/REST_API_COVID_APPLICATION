package com.covidapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.covidapp.module.Vaccine;

public interface VaccineDao extends JpaRepository<Vaccine, Integer>{

}
