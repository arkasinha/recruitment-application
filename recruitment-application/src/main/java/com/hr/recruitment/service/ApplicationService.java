package com.hr.recruitment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.hr.recruitment.constants.RecruitmentConstants;
import com.hr.recruitment.exception.RecruitmentException;
import com.hr.recruitment.model.ApplicationServiceRequest;
import com.hr.recruitment.model.JobApplication;
import com.hr.recruitment.model.JobApplicationKey;
import com.hr.recruitment.model.JobOffer;
import com.hr.recruitment.repository.JobApplicationRepository;
import com.hr.recruitment.repository.JobOfferRepository;

/**
 * Application related services
 * 
 * @author arkasinha
 *
 */
@Service
public class ApplicationService {
	
	@Autowired
	private JobApplicationRepository jobApplicationRepository;
	
	@Autowired
	private JobOfferRepository jobOfferRepository;

	@Autowired
	private OfferService offerService;
	
	@Autowired
	private NotificationService notificationService;

	/**
	 * Submit an application for an offer
	 * 
	 * @param applicationRequest
	 * @throws RecruitmentException 
	 */
	public void applyToOffer(ApplicationServiceRequest applicationRequest) throws RecruitmentException {		
				
		// Find the offer for which application is made
		JobOffer jobOffer = jobOfferRepository.findByJobTitle(applicationRequest.getJobTitle());
				
		// If no such offer is found in database
		if(jobOffer == null){
					
			// error message with HTTP 400
			throw new RecruitmentException(RecruitmentConstants.ERROR_OFFER_NOT_FOUND);
		
		// Application already exists	
		}else if(getApplicationDetails(applicationRequest.getCandidateEmail(), 
				applicationRequest.getJobTitle()) != null){
			
			// error message with HTTP 400
			throw new RecruitmentException(RecruitmentConstants.ERROR_APPLICATION_ALREADY_EXISTS);
			
		}else{
			
			// All good, Submit this application
			submitApplication(applicationRequest);
		}
	}
	
	/**
	 * @param jobOffer
	 * @param applicationRequest
	 */
	private void submitApplication(ApplicationServiceRequest applicationRequest){
		
		// Let's create the job application object
		JobApplication jobApplication = new JobApplication(applicationRequest.getCandidateEmail(),
														   applicationRequest.getResumeText(), 
														   applicationRequest.getJobTitle());
		
		// Save application in DB
		jobApplicationRepository.saveAndFlush(jobApplication);
		
		// Increase the count of applicants in Offer DB
		JobOffer jobOffer = offerService.incrementApplicantCount(applicationRequest.getJobTitle());
		
		// Notify recruitment team and applicant
		notificationService.notifyUsers(jobApplication, jobOffer);
	}
	

	/**
	 * Get application details
	 * 
	 * @param candidateEmail
	 * @param jobTitle
	 * @return applicationDetails
	 * @throws RecruitmentException
	 * 
	 */
	public JobApplication getApplicationDetails(String candidateEmail, String jobTitle) throws RecruitmentException {
		
		JobApplication jobApplication = null;
		
		// Candidate email or Job Title shouldn't be empty
		if(!StringUtils.isEmpty(candidateEmail) && !StringUtils.isEmpty(jobTitle) ){
			
			// Create primary key
			JobApplicationKey applicationKey = new JobApplicationKey();
			applicationKey.setCandidateEmail(candidateEmail);
			applicationKey.setJobTitle(jobTitle);
			
			// Get application details
			jobApplication = jobApplicationRepository.findOne(applicationKey);
		}else{
			
			// Invalid request, can't send empty email address
			throw new RecruitmentException(RecruitmentConstants.ERROR_INVALID_REQUEST_EMAIL);
		}
		
		return jobApplication;
	}
	
	/**
	 * Get all applications belonging to a 
	 * candidate
	 * 
	 * @param candidateEmail
	 * @return applicationDetails
	 * @throws RecruitmentException
	 * 
	 */
	public List<JobApplication> getCandidateApplications(String candidateEmail) throws RecruitmentException {
		
		List<JobApplication> applications = null;
		
		// Candidate email shouldn't be empty
		if(!StringUtils.isEmpty(candidateEmail)){
			
			// Get application details
			applications = jobApplicationRepository.findByCandidateEmail(candidateEmail);
		}else{
			
			// Invalid request, can't send empty email address
			throw new RecruitmentException(RecruitmentConstants.ERROR_INVALID_REQUEST_EMAIL);
		}
		
		return applications;
	}

	/**
	 * Update application status and details
	 * 
	 * @param updateRequest
	 * @throws RecruitmentException 
	 */
	public void updateApplication(JobApplication updatedApplication) throws RecruitmentException {
		
		// Get old application details for comparision 
		JobApplication oldApplication = getApplicationDetails(updatedApplication.getCandidateEmail(), 
															  updatedApplication.getJobTitle());
		
		// Application not found
		if(oldApplication == null){
			
			// HTTP 400 Application not found
			throw new RecruitmentException(RecruitmentConstants.ERROR_APPLICATION_NOT_FOUND);
			
		// The application status should move forward and not backward
		// TODO consult product owner on this rule
		}else if(updatedApplication.getApplicationStatus().getValue() <= oldApplication.getApplicationStatus().getValue()){
			
			// HTTP 400 Application Status moved backwards
			throw new RecruitmentException(RecruitmentConstants.ERROR_INVALID_APP_STATUS_UPDATE); 
			
		}else{
			
			// Get offer details
			JobOffer jobOffer = jobOfferRepository.findByJobTitle(updatedApplication.getJobTitle());
			
			// Notify Users
			notificationService.notifyUsers(updatedApplication, jobOffer);
			
			// Save the updated application in DB
			jobApplicationRepository.saveAndFlush(updatedApplication);
		}		
	}		
}