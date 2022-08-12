package com.covidapp.servicelayer;

import java.util.List;

import com.covidapp.module.VaccinationCenter;

public interface VaccineCenterService {
		
	public List<VaccinationCenter> allVaccineCenters();
	
	public VaccinationCenter getVaccinationCenter(int  code);
	
	public  VaccinationCenter addVaccinationCenter(int code);
	
	public VaccinationCenter updateVaccinationCenter(VaccinationCenter center);
	
	public boolean deleteVaccinatioinCenter(VaccinationCenter center);
	
}
