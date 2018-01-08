package com.hr.recruitment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.hr.recruitment.helper.RecruitmentServiceHelper;
import com.hr.recruitment.model.JobApplication;
import com.hr.recruitment.model.JobOffer;

/**
 * A service to notify users
 * 
 * @author arkasinha
 *
 */
@Service
public class NotificationService {
	
	@Autowired
	JavaMailSender emailSender;
	
	@Autowired
	RecruitmentServiceHelper recruitmentServiceHelper;
	
	/**
	 * Calls notification service for application
	 * status change
	 * 
	 * @param updatedApplication
	 */
	public void notifyUsers(JobApplication updatedApplication, JobOffer jobOffer){
		
		/*
		 * TODO Define different actions for different
		 * application status change
		 */
		switch(updatedApplication.getApplicationStatus()){
		
		case APPLIED:
		case INVITED: 
		case REJECTED: 
		case HIRED:
			
			// Notify Candidate
			notifyCandidate(updatedApplication);
			
			// Notify Recruitment members for this offer
			notifyRecruitmentTeam(updatedApplication, jobOffer);
			
			break;		
		}		
	}

	/**
	 * @param updatedApplication
	 */
	public void notifyCandidate(JobApplication updatedApplication) {
		
		/*
		 * send email with appropriate 
		 * template as per application status
		 */
		SimpleMailMessage message = recruitmentServiceHelper
									.getMessageForCandidate(updatedApplication);
			
		emailSender.send(message);
	}

	/**
	 * @param updatedApplication
	 */
	public void notifyRecruitmentTeam(JobApplication updatedApplication, JobOffer jobOffer) {
		
		/*
		 * send email to recruitment team
		 */		
		SimpleMailMessage message = recruitmentServiceHelper
									.getMessageForTeam(updatedApplication, jobOffer);
		
	    emailSender.send(message);
	}
}