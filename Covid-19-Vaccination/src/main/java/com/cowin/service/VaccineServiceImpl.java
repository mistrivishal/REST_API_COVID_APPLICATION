package com.cowin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cowin.exceptions.VaccineNotFound;
import com.cowin.model.Vaccine;
import com.cowin.repository.VaccineDao;

@Service
public class VaccineServiceImpl implements VaccineService {

	@Autowired
	private VaccineDao vaccinedao;

	@Override
	public Vaccine getVaccineById(Integer id) {
		Optional<Vaccine> opt = vaccinedao.findById(id);
		if (opt.isEmpty()) {
			throw new VaccineNotFound("Vaccine not found");
		}
		return opt.get();

	}

	@Override
	public List<Vaccine> getAllVaccine() {
		List<Vaccine> list = vaccinedao.findAll();
		if (list == null) {
			throw new VaccineNotFound("No Vaccine Found");
		}
		return list;
	}

	@Override
	public Vaccine getVaccineByPrice(double price) {
		Vaccine vaccine = vaccinedao.findByPrice(price);
		if (vaccine == null) {
			throw new VaccineNotFound("No Vaccine Found");
		}
		return vaccine;

	}

	@Override
	public Vaccine getVaccineByName(String name) {
		Vaccine vaccine = vaccinedao.findByVaccineName(name);
		if (vaccine == null) {
			throw new VaccineNotFound("No Vaccine Found");
		}
		return vaccine;
	}

	@Override
	public Vaccine saveVaccine(Vaccine vaccine) {

		return vaccinedao.save(vaccine);
	}

	@Override
	public Vaccine updateVaccine(Vaccine vaccine) {
		Optional<Vaccine> opt = vaccinedao.findById(vaccine.getVaccineId());
		if (opt.isEmpty()) {
			throw new VaccineNotFound("No Vaccine Found To Update");
		}
		return vaccinedao.save(vaccine);
	}
//
	@Override
	public Boolean deleteVaccine(Vaccine vaccine) {
		Optional<Vaccine> opt = vaccinedao.findById(vaccine.getVaccineId());
		if (opt.isEmpty()) {
			throw new VaccineNotFound("No Vaccine Found To Delete");
		}
		return true;
	}

}
