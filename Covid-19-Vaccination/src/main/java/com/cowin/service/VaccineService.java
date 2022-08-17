package com.cowin.service;

import java.util.List;

import com.cowin.model.Vaccine;

public interface VaccineService {
	
	public Vaccine getVaccineById(Integer id);
	
	public List<Vaccine> getAllVaccine();
	
	public Vaccine getVaccineByPrice(double price);

	public Vaccine getVaccineByName(String name);
	
	public Vaccine saveVaccine(Vaccine vaccine);
	
	public Vaccine updateVaccine(Vaccine vaccine);
	
	public Boolean deleteVaccine(Vaccine vaccine);
		
		
}
