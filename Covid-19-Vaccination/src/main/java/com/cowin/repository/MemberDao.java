package com.cowin.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cowin.model.Member;
import com.cowin.utils.AdharCard;

@Repository
public interface MemberDao extends JpaRepository<Member, Integer>{
	
	public List<Member> findByMobileno(String string);
	
	public Optional<Member> findByAdharcard(AdharCard adharcard);

}
