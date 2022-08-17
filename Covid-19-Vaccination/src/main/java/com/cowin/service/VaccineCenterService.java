package com.cowin.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cowin.exceptions.DuplicateEntryException;
import com.cowin.exceptions.VaccineCenterNotFound;
import com.cowin.model.VaccineCenter;
import com.cowin.model.VaccineCenterDTO;

@Component
public interface VaccineCenterService {
	
	public VaccineCenter saveVaccineCenter(VaccineCenter center) throws DuplicateEntryException;
	
	public VaccineCenter updateVaccineCenter(VaccineCenter center) throws VaccineCenterNotFound;
	
	public Boolean deleteVaccineCenter(VaccineCenterDTO vacCenterDTO) throws VaccineCenterNotFound;
	
	public VaccineCenter getVaccineCenterById(VaccineCenterDTO vacCenterDTO) throws VaccineCenterNotFound ;
	
	public VaccineCenter getVaccineCenterByCenterName(String vacineCenterName) throws VaccineCenterNotFound;	
	
	public List<VaccineCenter> getAllVaccineCenter() throws VaccineCenterNotFound;
}
