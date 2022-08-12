package com.covidapp.servicelayer;

import java.util.List;

import com.covidapp.module.Vaccine;

public interface VaccineService {
		
	public List<Vaccine> allVaccine();
	
	public Vaccine getVaccinebyName(String name);
	
	public Vaccine getVaccineId(Integer vaccineid);
	
	public Vaccine addVaccine(Vaccine vaccine);
	
	public Vaccine updateVaccine(Vaccine vaccine);
	
	public Boolean deleteVaccine(Vaccine vaccine);
	
}
