package com.covidapp.servicelayer.Impl;

import java.time.LocalDateTime;
import java.util.List;

import com.covidapp.module.Vaccine;
import com.covidapp.module.VaccineInventory;
import com.covidapp.servicelayer.VaccineInventoryService;

public class VaccineInventoryServiceimpl implements VaccineInventoryService{

	@Override
	public List<VaccineInventory> allVaccineInventory() {
		
		return null;
		
	}

	@Override
	public VaccineInventory getVaccineInventorybyCenter(Integer code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VaccineInventory addVaccineCount(VaccineInventory vaccineinventory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VaccineInventory updateVaccineInventory(VaccineInventory vaccineinventory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteVaccineInventory(VaccineInventory vaccineinventory) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<VaccineInventory> getVaccineInventoryByDate(LocalDateTime date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VaccineInventory> getVaccineInventoryByVaccine(Vaccine vaccine) {
		// TODO Auto-generated method stub
		return null;
	}

}
