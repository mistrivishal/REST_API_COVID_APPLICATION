package com.covidapp.servicelayer;

import java.time.LocalDateTime;
import java.util.List;

import com.covidapp.module.Vaccine;
import com.covidapp.module.VaccineInventory;

public interface VaccineInventoryService {

	public List<VaccineInventory> allVaccineInventory();
	
	public VaccineInventory getVaccineInventorybyCenter(int code);
	
	public VaccineInventory addVaccineCount(VaccineInventory vaccineinventory);
	
	public VaccineInventory updateVaccineInventory(VaccineInventory vaccineinventory);
	
	public Boolean deleteVaccineInventory(VaccineInventory vaccineinventory);
	
	public List<VaccineInventory> getVaccineInventoryByDate(LocalDateTime date);
	
	public List<VaccineInventory> getVaccineInventoryByVaccine(Vaccine vaccine);
	
	
}
