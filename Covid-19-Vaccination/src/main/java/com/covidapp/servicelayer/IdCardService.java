package com.covidapp.servicelayer;

import com.covidapp.module.IdCard;

public interface IdCardService {
	
	public IdCard getPanCardByNumber(String panNo);
	
	public IdCard getAdharCardByNumber(Long adharNo);
	
	public IdCard addIdCard(IdCard idCard);
	
}
