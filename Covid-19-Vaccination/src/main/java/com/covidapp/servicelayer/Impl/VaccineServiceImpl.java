package com.covidapp.servicelayer.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.covidapp.exceptionhandler.CenterException;
import com.covidapp.exceptionhandler.VaccineNotFoundException;
import com.covidapp.module.Vaccine;
import com.covidapp.repository.VaccineDao;
import com.covidapp.servicelayer.VaccineService;

public class VaccineServiceImpl implements VaccineService {

	@Autowired
	private VaccineDao vacDao;

	@Override
	public List<Vaccine> allVaccine() {
		List<Vaccine> list = vacDao.findAll();

		return list;
	}

	@Override
	public Vaccine getVaccinebyName(String name) {
		Vaccine vac = vacDao.findByVaccineName(name);
		if (vac == null) {
			throw new CenterException("Vaccine not found");
		}

		return vac;
	}

	@Override
	public Vaccine getVaccineId(Integer vaccineid) {
		
		Optional<Vaccine> vac=vacDao.findById(vaccineid);
		
		if(vac.isPresent()) {
			return vac.get();
		}
		else {
			throw new VaccineNotFoundException("Vaccine not found");
		}
	}

	@Override
	public Vaccine addVaccine(Vaccine vaccine) {
		
		return 	vacDao.save(vaccine);
	}

	@Override
	public Vaccine updateVaccine(Vaccine vaccine) {
		Optional<Vaccine> opt = vacDao.findById(vaccine.getVaccineId());
		if(opt.isPresent()) {
			return vacDao.save(vaccine);
			
		}
		else {
			throw new VaccineNotFoundException("Vaccine not found");
		}
	}

	@Override
	public Boolean deleteVaccine(Vaccine vaccine) {
		Optional<Vaccine> opt = vacDao.findById(vaccine.getVaccineId());
		if(opt.isPresent()) {
			vacDao.delete(vaccine);
			return true;
		}
		return false;
	}

}
