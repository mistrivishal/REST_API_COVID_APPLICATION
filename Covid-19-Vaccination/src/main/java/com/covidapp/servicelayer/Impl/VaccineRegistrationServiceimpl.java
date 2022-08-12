package com.covidapp.servicelayer.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.covidapp.module.Member;
import com.covidapp.module.VaccinationRegistration;
import com.covidapp.servicelayer.VaccineRegistrationService;

@Service
public class VaccineRegistrationServiceImpl implements VaccineRegistrationService {

	@Override
	public List<VaccinationRegistration> allVaccineRegistration() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VaccinationRegistration getVaccineRegistration(long mobileno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> getAllMember(long mobileno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VaccinationRegistration addVaccineRegistration(VaccinationRegistration vaccineregistration) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VaccinationRegistration updateVaccineRegistration(VaccinationRegistration vaccineregistration) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteVaccineRegistration(VaccinationRegistration vaccineregistration) {
		// TODO Auto-generated method stub
		return false;
	}

}
