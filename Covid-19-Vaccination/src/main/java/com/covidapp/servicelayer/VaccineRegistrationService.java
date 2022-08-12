package com.covidapp.servicelayer;

import java.util.List;

import com.covidapp.module.Member;
import com.covidapp.module.VaccinationRegistration;

public interface VaccineRegistrationService {
			
	public List<VaccinationRegistration> allVaccineRegistration();
	
	public VaccinationRegistration getVaccineRegistration(long mobileno);
	
	public List<Member> getAllMember(long mobileno);
	
	public VaccinationRegistration addVaccineRegistration(VaccinationRegistration vaccineregistration);
	
	public VaccinationRegistration updateVaccineRegistration(VaccinationRegistration vaccineregistration);
	
	public Boolean deleteVaccineRegistration(VaccinationRegistration vaccineregistration);
}
