package com.covidapp.servicelayer;

import java.util.List;

import com.covidapp.exceptionhandler.CenterException;
import com.covidapp.module.VaccinationCenter;

public interface VaccineCenterService {
		
	public List<VaccinationCenter> allVaccineCenters()throws CenterException;
	
	public VaccinationCenter getVaccinationCenter(Integer  code)throws CenterException;
	
	public  VaccinationCenter addVaccinationCenter(VaccinationCenter center)throws CenterException;
	
	public VaccinationCenter updateVaccinationCenter(VaccinationCenter center)throws CenterException;
	
<<<<<<< HEAD
	public Boolean deleteVaccinatioinCenter(VaccinationCenter center);
=======
	public Boolean deleteVaccinatioinCenter(VaccinationCenter center)throws CenterException;
>>>>>>> d8695e35bc962c94db9b6f04c753e67b21f2de67
	
}
