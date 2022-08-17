package com.cowin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cowin.model.CurrentMemberSession;

@Repository
public interface SessionRepo extends JpaRepository<CurrentMemberSession, Integer>{
	
	public Optional<CurrentMemberSession> findByMemberId(Integer memId);
	
	public Optional<CurrentMemberSession> findBySessionKey(String key);
	
	public Optional<CurrentMemberSession> findByMobileNo(String mobileNo);
	
}
