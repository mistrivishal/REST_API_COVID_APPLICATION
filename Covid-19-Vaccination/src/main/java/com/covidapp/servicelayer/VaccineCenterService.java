package com.covidapp.servicelayer;

import java.util.List;

import com.covidapp.exceptionhandler.CenterException;
import com.covidapp.module.VaccinationCenter;

public interface VaccineCenterService {
		
	public List<VaccinationCenter> allVaccineCenters()throws CenterException;
	
	public VaccinationCenter getVaccinationCenter(Integer  code)throws CenterException;
	
	public  VaccinationCenter addVaccinationCenter(VaccinationCenter center)throws CenterException;
	
	public VaccinationCenter updateVaccinationCenter(VaccinationCenter center)throws CenterException;
	
	public Boolean deleteVaccinatioinCenter(VaccinationCenter center)throws CenterException;
	
}
