package com.covidapp.servicelayer.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covidapp.exceptionhandler.CenterException;
import com.covidapp.module.Member;
import com.covidapp.module.VaccinationRegistration;
import com.covidapp.repository.VaccineRegistrationDao;
import com.covidapp.servicelayer.VaccineRegistrationService;

@Service
public class VaccineRegistrationServiceImpl implements VaccineRegistrationService {

	@Autowired
	VaccineRegistrationDao VacReg;
	
	@Override
	public List<VaccinationRegistration> allVaccineRegistration() {
		List<VaccinationRegistration> list = VacReg.findAll();
		if(list!=null) {
			return list;
		}
		else {
			throw new CenterException("No Registration found");
		}
	}

	@Override
	public VaccinationRegistration getVaccineRegistration(Long mobileno) {
		Optional<VaccinationRegistration> vacregis = VacReg.findById(mobileno);
		
		if(vacregis.isPresent()) {
			return vacregis.get();
		}
		else {
			throw new CenterException("No Registration found");
		}
	}

	@Override
	public List<Member> getAllMember(Long mobileno) {
		Optional<VaccinationRegistration> vacregis = VacReg.findById(mobileno);
		if(vacregis.isEmpty()) {
			throw new CenterException("No Registration Found");
		}
		List <Member> list = vacregis.get().getMembers();
		return list;
	}

	@Override
	public VaccinationRegistration addVaccineRegistration(VaccinationRegistration vaccineregistration) {
		VaccinationRegistration addvacreg = VacReg.save(vaccineregistration);
		return addvacreg;
	}

	@Override
	public VaccinationRegistration updateVaccineRegistration(VaccinationRegistration vaccineregistration) {
		Optional<VaccinationRegistration> updatevacreg = VacReg.findById(vaccineregistration.getMobileno());
		if(updatevacreg.isPresent()) {
		throw new CenterException("No Registration Found");	
		}
		return VacReg.save(vaccineregistration);
	}

	@Override
	public Boolean deleteVaccineRegistration(VaccinationRegistration vaccineregistration) {
		Optional<VaccinationRegistration> deletevacreg = VacReg.findById(vaccineregistration.getMobileno());
		if(deletevacreg.isEmpty()) {
			throw new CenterException("No Registration Found");	
			}
		else {
		VacReg.delete(deletevacreg.get());
		return true;
		}
	}


}
