package com.hr.recruitment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.hr.recruitment.constants.RecruitmentConstants;
import com.hr.recruitment.exception.RecruitmentException;
import com.hr.recruitment.model.JobApplication;
import com.hr.recruitment.model.JobOffer;
import com.hr.recruitment.repository.JobApplicationRepository;
import com.hr.recruitment.repository.JobOfferRepository;

/**
 * Service for offer related features
 * 
 * @author arkasinha
 *
 */
@Service
public class OfferService {
		
	@Autowired 
	JobOfferRepository jobOfferRepository;
	
	@Autowired
	JobApplicationRepository jobApplicationRepository;

	/**
	 * Creates a new offer
	 * 
	 * @param offerDetails
	 * @throws RecruitmentException 
	 */
	public void createOffer(JobOffer offerDetails) throws RecruitmentException {
		
		// Offer doesn't exist in DB
		if(jobOfferRepository.findByJobTitle(offerDetails.getJobTitle()) == null){
			
			// Create this offer
			jobOfferRepository.saveAndFlush(offerDetails);
		
		}else{
			
			// HTTP 400 with error message
			throw new RecruitmentException(RecruitmentConstants.ERROR_OFFER_ALREADY_EXISTS);
		}
	}

	/**
	 * Lists all available offers
	 * 
	 * @return offers
	 */
	public List<JobOffer> listAllOffers() {
		
		return jobOfferRepository.findAll();
	}

	/**
	 * Get details of an offer
	 * 
	 * @param jobTitle
	 * @return offer
	 * @throws RecruitmentException 
	 */
	public JobOffer getOfferDetails(String jobTitle) throws RecruitmentException {
		
		JobOffer jobOffer = null;
		
		// JobTitle shouldn't be empty
		if(!StringUtils.isEmpty(jobTitle)){
			
			// Get details from DB
			jobOffer = jobOfferRepository.findByJobTitle(jobTitle);
			
		}else{
			
			// Can't send empty job title, bad request
			throw new RecruitmentException(RecruitmentConstants.ERROR_INVALID_REQ_JOB_TITLE);
		}
				
		return jobOffer;
	}

	/**
	 * Gets all applications submitted for an offer
	 * 
	 * @param jobTitle
	 * @return applications
	 * @throws RecruitmentException 
	 */
	public List<JobApplication> getApplicationsForOffer(String jobTitle) throws RecruitmentException {
		
		List<JobApplication> applications = null;
		
		// JobTitle shouldn't be empty
		if(!StringUtils.isEmpty(jobTitle)){
			
			// Get applications from DB
			applications = jobApplicationRepository.findByJobTitle(jobTitle);
			
		}else{
			throw new RecruitmentException(RecruitmentConstants.ERROR_INVALID_REQ_JOB_TITLE);
		}
				
		return applications;
	}
	
	/**
	 * @param jobTitle
	 */
	public JobOffer incrementApplicantCount(String jobTitle){
		
		// Find the job offer
		JobOffer jobOffer = jobOfferRepository.findByJobTitle(jobTitle);
		
		// Increment the applicant count 
		jobOffer.setNumberOfApplicants(jobOffer.getNumberOfApplicants() + 1);
		
		// Save the entity
		jobOfferRepository.saveAndFlush(jobOffer);		
		
		return jobOffer;
	}
}
