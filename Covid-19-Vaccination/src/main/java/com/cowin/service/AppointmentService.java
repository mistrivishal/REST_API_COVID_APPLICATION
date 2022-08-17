package com.cowin.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cowin.model.AppoinmetDTO;

@Component
public interface AppointmentService {
	
	public AppoinmetDTO addAppointMentDetails(AppoinmetDTO appDto);
	
	public String deleteAppointMent(AppoinmetDTO appDto);
	
	public List<AppoinmetDTO> getAllAppointmentsOfMember(AppoinmetDTO appDto);
	
}
