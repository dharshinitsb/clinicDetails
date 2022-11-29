package com.cognizant.xxClinicDetails.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.xxClinicDetails.controller.AuthClient;
import com.cognizant.xxClinicDetails.model.AuthResponse;
import com.cognizant.xxClinicDetails.model.ClinicDetails;
import com.cognizant.xxClinicDetails.repository.ClinicDetailsRepository;

@Service
public class ClinicDetailsServiceImpl implements ClinicDetailsService{
	
	@Autowired
	private ClinicDetailsRepository clinicDetailsRepository;
	
	@Autowired
	private AuthClient authClient;
	
	@Transactional
	public List<ClinicDetails> findAllClinicDetails()
	{
		return clinicDetailsRepository.findAll();
	}
	
	@Transactional
	public void addClinicDetails(ClinicDetails clinicDetails)
	{
		clinicDetailsRepository.save(clinicDetails);
	}
	
	@Transactional
	public void editClinicDetails(ClinicDetails clinicDetails)
	{
		clinicDetailsRepository.save(clinicDetails);
	}
	
	@Transactional
	public void removeClinicDetails(ClinicDetails clinicDetails)
	{
		clinicDetailsRepository.deleteById(clinicDetails.getId());
	}
	
	public boolean isSessionValid(String token)
	{
		try
		{
			@SuppressWarnings("unused")
			AuthResponse authResponse = authClient.getValidity(token);
		}
		catch (Exception e)
		{
			return false;
		}
		return true;
	}
	
	public void addData()
	{
		ClinicDetails clinic1 = new ClinicDetails(1, "CLINIC ONE", "ADDRESS ONE", "CITY ONE", "STATE ONE", "COUNTRY ONE", "9999999999", "EMAILONE@EMAIL.COM");
		ClinicDetails clinic2 = new ClinicDetails(2, "CLINIC TWO", "ADDRESS TWO", "CITY TWO", "STATE TWO", "COUNTRY TWO", "1111111111", "EMAILTWO@EMAIL.COM");
		
		clinicDetailsRepository.save(clinic1);
		clinicDetailsRepository.save(clinic2);
	}

}
