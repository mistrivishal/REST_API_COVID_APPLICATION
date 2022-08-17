package com.cowin.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Component
public class CurrentMemberSession {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer curMid;
	
	@Column(unique = true)
	private Integer memberId;
	
	private String mobileNo;
	
	private String sessionKey;
	
	private LocalDateTime localDateTime;
	
	public CurrentMemberSession(){
		
	}
	
	public CurrentMemberSession(Integer memberId, String mobileNo, String sessionKey, LocalDateTime localDateTime) {
		super();
		this.memberId = memberId;
		this.mobileNo = mobileNo;
		this.sessionKey = sessionKey;
		this.localDateTime = localDateTime;
	}

	
}
