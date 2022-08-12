package com.covidapp.servicelayer.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.covidapp.exceptionhandler.CenterException;
import com.covidapp.module.Vaccine;
import com.covidapp.repository.VaccineDao;
import com.covidapp.servicelayer.VaccineService;

public class VaccineServiceImpl implements VaccineService {

	@Autowired
	VaccineDao VacDao;

	@Override
	public List<Vaccine> allVaccine() {
		List<Vaccine> list = VacDao.findAll();

		return list;
	}

	@Override
	public Vaccine getVaccinebyName(String name) {
		Vaccine vac = VacDao.findByVaccineName(name);
		if (vac == null) {
			throw new CenterException("Vaccine not found");
		}

		return vac;
	}

	@Override
	public Vaccine getVaccineId(Integer vaccineid) {
		
		return VacDao.findById(vaccineid).orElseThrow(new VaccineNotFoundException("Vaccine not Found"));
		
	}

	@Override
	public Vaccine addVaccine(Vaccine vaccine) {
		
		return 	VacDao.save(vaccine);
	}

	@Override
	public Vaccine updateVaccine(Vaccine vaccine) {
		Optional<Vaccine> opt = VacDao.findById(vaccine.getVaccineId());
		if(opt.isPresent()) {
			VacDao.save(vaccine);
		}
		else {
			throw new VaccineNotFoundException("Vaccine not found");
		}
	}

	@Override
	public Boolean deleteVaccine(Vaccine vaccine) {
		Optional<Vaccine> opt = VacDao.findById(vaccine.getVaccineId());
		if(opt.isPresent()) {
			VacDao.delete(vaccine);
			return true;
		}
		return false;
	}

}
