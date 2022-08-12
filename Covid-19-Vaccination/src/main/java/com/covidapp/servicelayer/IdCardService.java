package com.covidapp.servicelayer;

import com.covidapp.exceptionhandler.*;
import com.covidapp.module.IdCard;

public interface IdCardService {
	
	public IdCard getPanCardByNumber(String panNo) throws IdCardNotFoundException;
	
	public IdCard getAdharCardByNumber(Long adharNo) throws IdCardNotFoundException;
	
	public IdCard addIdCard(IdCard idCard) throws DuplicateIdException;
	
}
