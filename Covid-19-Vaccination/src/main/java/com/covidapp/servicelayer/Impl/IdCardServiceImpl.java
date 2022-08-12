package com.covidapp.servicelayer.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covidapp.exceptionhandler.DuplicateIdException;
import com.covidapp.exceptionhandler.IdCardNotFoundException;
import com.covidapp.module.AdharCard;
import com.covidapp.module.IdCard;
import com.covidapp.module.PanCard;
import com.covidapp.repository.IdCardDao;
import com.covidapp.servicelayer.IdCardService;

@Service
public class IdCardServiceImpl implements IdCardService {

	@Autowired
	private IdCardDao idDao;

	@Override
	public IdCard getPanCardByNumber(String panNo) {

		IdCard idCard = idDao.findByPan(new PanCard(panNo));

		if (idCard != null)
			return idCard;

		else
			throw new IdCardNotFoundException("Invalid Pancard Number.");

	}

	@Override
	public IdCard getAdharCardByNumber(Long adharNo) {

		IdCard idCard = idDao.findByAdhar(new AdharCard(adharNo));

		if (idCard != null)
			return idCard;

		else
			throw new IdCardNotFoundException("Invalid Aadhaar Number.");

	}

	@Override
	public IdCard addIdCard(IdCard idCard) {

		List<IdCard> idCards = idDao.findAll();

		for (IdCard id : idCards) {
			if (id.getAdhar().getAdharNo() == idCard.getAdhar().getAdharNo()) {
				throw new DuplicateIdException("Idcard Already Exists with adharNo: ");
			}
		}

		return idDao.save(idCard);

	}

}
