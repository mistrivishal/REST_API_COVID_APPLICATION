package com.covidapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.covidapp.module.AdharCard;
import com.covidapp.module.IdCard;
import com.covidapp.module.PanCard;

public interface IdCardDao extends JpaRepository<IdCard, Integer>{
	
	public IdCard findByAdhar(AdharCard adhar);
	
	public IdCard findByPan(PanCard pan);
}
