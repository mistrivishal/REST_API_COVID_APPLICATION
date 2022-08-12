package com.covidapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.covidapp.module.VaccinationRegistration;

public interface VaccineRegistrationDao extends JpaRepository<VaccinationRegistration, Long> {

}
