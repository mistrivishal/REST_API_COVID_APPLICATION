package com.covidapp.servicelayer;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covidapp.module.VaccinationCenter;
import com.covidapp.repository.VaccineCenterDao;
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
	public VaccinationCenter getVaccinationCenter(int code) {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteVaccinatioinCenter(VaccinationCenter center) {
		// TODO Auto-generated method stub
		return false;
	}

}
