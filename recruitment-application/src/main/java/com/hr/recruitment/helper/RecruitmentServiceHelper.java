package com.hr.recruitment.helper;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import com.hr.recruitment.constants.EmailTemplates;
import com.hr.recruitment.model.JobApplication;
import com.hr.recruitment.model.JobOffer;

/**
 * Common helper class to facilitate
 * repetitive non-business tasks or
 * utilities 
 * 
 * @author arkasinha
 *
 */
@Component
public class RecruitmentServiceHelper {

	/**
	 * This method will provide an 
	 * appropriate message for a candidate
	 * based on the application status
	 * 
	 * @param jobApplication
	 * @return message
	 */
	public SimpleMailMessage getMessageForCandidate(
			JobApplication jobApplication) {
			
		String subject = null;
		String text = null;
		
		switch(jobApplication.getApplicationStatus()){
		
		case APPLIED:
			
			subject = EmailTemplates.Candidate.SUBJECT_APPLIED;
			text = EmailTemplates.Candidate.TEXT_APPLIED;
			
			break;
		case INVITED:
			
			subject = EmailTemplates.Candidate.SUBJECT_INVITED;
			text = EmailTemplates.Candidate.TEXT_INVITED;
			
			break;
		case HIRED:
			
			subject = EmailTemplates.Candidate.SUBJECT_HIRED;
			text = EmailTemplates.Candidate.TEXT_HIRED;
			
			break;
		case REJECTED:
			
			subject = EmailTemplates.Candidate.SUBJECT_REJECTED;
			text = EmailTemplates.Candidate.TEXT_REJECTED;
			
			break;
		}
		
		return getMessage(jobApplication.getCandidateEmail(), subject, text);
	}
	
	/**
	 * This method will provide an 
	 * appropriate message for the recruitment
	 * team based on applicant's application
	 * status
	 * 
	 * @param jobApplication
	 * @param jobOffer
	 * @return message
	 */
	public SimpleMailMessage getMessageForTeam(final JobApplication jobApplication, final JobOffer jobOffer) {
		
		String subject = null;
		String text = null;
		String email = jobOffer.getTeamEmail();
		
		switch(jobApplication.getApplicationStatus()){
		
		case APPLIED:
			
			subject = EmailTemplates.Team.SUBJECT_APPLIED;
			text = EmailTemplates.Team.TEXT_APPLIED+jobApplication.getCandidateEmail();
			
			break;
		case INVITED:
			
			subject = EmailTemplates.Team.SUBJECT_INVITED;
			text = EmailTemplates.Team.TEXT_INVITED+jobApplication.getCandidateEmail();
			
			break;
		case HIRED:
			
			subject = EmailTemplates.Team.SUBJECT_HIRED;
			text = EmailTemplates.Team.TEXT_HIRED+jobApplication.getCandidateEmail();
			
			break;
		case REJECTED:
			
			subject = EmailTemplates.Team.SUBJECT_REJECTED;
			text = EmailTemplates.Team.TEXT_REJECTED+jobApplication.getCandidateEmail();
			
			break;
		}
			
		return getMessage(email, subject, text);
	}
	
	/**
	 * Returns a java mail message object
	 * 
	 * @param email
	 * @param subject
	 * @param text
	 * @return message
	 */
	private SimpleMailMessage getMessage(String email, String subject, String text){
		
		SimpleMailMessage message = new SimpleMailMessage();
		
		// if there are multiple emails
		String[] emails = email.split(",");
		
		// Create the message object
        message.setTo(emails); 
        message.setSubject(subject); 
        message.setText(text);
        
        return message;
	}
}