package com.covidapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.covidapp.module.Member;

public interface memberDao extends JpaRepository<Member, Integer>{
	

}
