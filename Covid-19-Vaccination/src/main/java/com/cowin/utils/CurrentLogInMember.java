package com.cowin.utils;

import com.cowin.model.CurrentMemberSession;
import com.cowin.model.Member;

public interface CurrentLogInMember {
	
	public CurrentMemberSession getCurrentMemberSession(String key);

	public Integer getCurrentMemberSessionId(String key);

	public Member getCurrentMemberBySessionKey(String key);
	
	public Member getCurrentMemberByMobileNo(String mobileNo);
}
