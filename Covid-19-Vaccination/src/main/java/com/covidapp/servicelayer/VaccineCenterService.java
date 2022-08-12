package com.covidapp.servicelayer;

import java.util.List;

import com.covidapp.module.VaccinationCenter;

public interface VaccineCenterService {
		
	public List<VaccinationCenter> allVaccineCenters();
	
	public VaccinationCenter getVaccinationCenter(int  code);
	
	public  VaccinationCenter addVaccinationCenter(VaccinationCenter center);
	
	public VaccinationCenter updateVaccinationCenter(VaccinationCenter center);
	
	public Boolean deleteVaccinatioinCenter(VaccinationCenter center);
	
}
