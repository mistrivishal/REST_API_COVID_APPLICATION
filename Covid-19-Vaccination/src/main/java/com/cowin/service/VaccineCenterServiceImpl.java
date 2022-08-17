package com.cowin.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cowin.exceptions.DuplicateEntryException;
import com.cowin.exceptions.VaccineCenterNotFound;
import com.cowin.model.VaccineCenter;
import com.cowin.model.VaccineCenterDTO;
import com.cowin.repository.VaccineCenterDao;

@Service
public class VaccineCenterServiceImpl implements VaccineCenterService {

	@Autowired
	private VaccineCenterDao vaccinecenterdao;
	
	@Override
	@Transactional
	public VaccineCenter saveVaccineCenter(VaccineCenter center) throws DuplicateEntryException{
		
		Optional<VaccineCenter> ex_center = vaccinecenterdao.findById(center.getCenter_id());
		
		if(ex_center.isPresent()) throw new DuplicateEntryException("Duplicate Entry -  center is aready present with this ID: " + center.getCenter_id()) ;
		
		return vaccinecenterdao.saveAndFlush(center);
	}
	
	@Override
	public VaccineCenter updateVaccineCenter(VaccineCenter center) throws VaccineCenterNotFound {
		Optional<VaccineCenter> opt = vaccinecenterdao.findById(center.getCenter_id());
		if (opt.isEmpty()) {
			throw new VaccineCenterNotFound("Center Not Available to Update");
		}
		
		VaccineCenter e_center = opt.get();
		e_center.setVaccine(center.getVaccine());
		
		return vaccinecenterdao.save(e_center);
	}

	@Override
	public Boolean deleteVaccineCenter(VaccineCenterDTO vacCenterDTO) throws VaccineCenterNotFound {
//		System.out.println(vacCenterDTO.getCenter_id()+"-------------");
		Optional<VaccineCenter> opt = vaccinecenterdao.findById(vacCenterDTO.getCenter_id());

		if (opt.isEmpty()) {
			throw new VaccineCenterNotFound("Center Not Available to Delete -  please provide valid center ID");
		}
//		if(! opt.get().getVacCenterName().equalsIgnoreCase(vacCenterDTO.getVacCenterName()))
//			throw new VaccineCenterNotFound("Center Not Available to Delete -  please provide valid center name");
//		else
//			System.out.println(opt.get()+"-------------");
		vaccinecenterdao.delete(opt.get());
		
		return true;
	}

	@Override
	public VaccineCenter getVaccineCenterById(VaccineCenterDTO vacCenterDTO) throws VaccineCenterNotFound {

		Optional<VaccineCenter> opt = vaccinecenterdao.findById(vacCenterDTO.getCenter_id());

		return opt.orElseThrow(() -> new VaccineCenterNotFound("Center Not Found with the center id: " + vacCenterDTO.getCenter_id()));
	}

	@Override
	public VaccineCenter getVaccineCenterByCenterName(String vacineCenterName) throws VaccineCenterNotFound {

		VaccineCenter vac = vaccinecenterdao.findByVacCenterName(vacineCenterName);
		if (vac == null) {
			throw new VaccineCenterNotFound("No Center Avaliable with this Name " + vacineCenterName);
		}
		return vac;
	}

	@Override
	public List<VaccineCenter> getAllVaccineCenter() throws VaccineCenterNotFound {
		List<VaccineCenter> list = vaccinecenterdao.findAll();
		if (list.isEmpty()) {
			throw new VaccineCenterNotFound("No Center records are found");
		}
		return list;
	}


}
