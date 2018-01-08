package com.hr.recruitment.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hr.recruitment.constants.Urls;
import com.hr.recruitment.exception.RecruitmentException;
import com.hr.recruitment.model.ApplicationServiceRequest;
import com.hr.recruitment.model.JobApplication;
import com.hr.recruitment.service.ApplicationService;

/**
 * Endpoints for application related
 * features
 * 
 * @author arkasinha
 * 
 */
@RestController
@RequestMapping(Urls.Application.APPLICATION)
public class ApplicationController {
	
	@Autowired
	ApplicationService applicationService;

	
	/**
	 * Submit an application for an offer
	 * 
	 * @param applicationRequest
	 * @throws RecruitmentException
	 */
	@RequestMapping(value=Urls.Application.APPLY_TO_OFFER, method=RequestMethod.POST)
	public void applyToOffer(@Valid @RequestBody(required=true)ApplicationServiceRequest applicationRequest)
			throws RecruitmentException{
		
		applicationService.applyToOffer(applicationRequest);
	}

	/**
	 * Get application details
	 * 
	 * @param candidateEmail
	 * @return applicationDetails
	 * @throws RecruitmentException 
	 */
	@RequestMapping(value=Urls.Application.GET_APPLICATION_DETAILS, method=RequestMethod.GET)
	public JobApplication getApplicationDetails(@RequestParam("candidateEmail")final String candidateEmail, 
			@RequestParam("jobTitle")final String jobTitle)
			throws RecruitmentException{
		
		return applicationService.getApplicationDetails(candidateEmail, jobTitle);
	}
	
	/**
	 * Update application status and details
	 * 
	 * @param updatedApplication
	 * @throws RecruitmentException 
	 */
	@RequestMapping(value=Urls.Application.UPDATE_APPLICATION, method=RequestMethod.POST)
	public void updateApplication(@RequestBody(required=true)JobApplication updatedApplication)
			throws RecruitmentException{
		
		applicationService.updateApplication(updatedApplication);
	}	
}