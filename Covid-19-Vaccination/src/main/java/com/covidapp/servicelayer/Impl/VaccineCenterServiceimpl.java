package com.covidapp.servicelayer.Impl;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covidapp.module.VaccinationCenter;
import com.covidapp.repository.VaccineCenterDao;
import com.covidapp.servicelayer.VaccineCenterService;
@Service
public class VaccineCenterServiceimpl implements VaccineCenterService{
	@Autowired
	VaccineCenterDao Vcdao;
	
	
	@Override
	public List<VaccinationCenter> allVaccineCenters() {
		List<VaccinationCenter>list = Vcdao.findAll();
		if(list!=null) {
		return list;
		}
		else {
			throw new CenterException("Center not found");
		}
	}

	@Override
	public VaccinationCenter getVaccinationCenter(Integer code) {
		Optional<VaccinationCenter> opt = Vcdao.findById(code);
		if(opt.isPresent()) {
				return opt.get();
		}
		else {
			throw new CenterException("Center not found");
		}
	}

	@Override
	public VaccinationCenter addVaccinationCenter(VaccinationCenter center) {
		VaccinationCenter vc = Vcdao.save(center);
		return null;
	}

	@Override
	public VaccinationCenter updateVaccinationCenter(VaccinationCenter center) {
		VaccinationCenter vaccinationcenter = Vcdao.getById(center.getCenterCcode());
		
		if(vaccinationcenter==null) {
			throw new CenterException("Center Not Found");
		}
		else {
		
		VaccinationCenter updatedvaccinecenter = Vcdao.save(center);
		return updatedvaccinecenter;
		}
		
	}

	@Override
	public Boolean deleteVaccinatioinCenter(VaccinationCenter center) {
		Boolean b= false;
		VaccinationCenter vaccinationcenter = Vcdao.getById(center.getCenterCcode());
		
		if(vaccinationcenter==null) {
			throw new CenterException("Center Not Found");
		}
		else {
		 Vcdao.delete(vaccinationcenter);
		return true;
		}
	}

}
