package com.hr.recruitment.constants;

/**
 * Email templates for sending messages
 * to candidate and recruitment team
 * 
 * @author arkasinha
 *
 */
public final class EmailTemplates {

	
	/**
	 * Email templates for the
	 * candidate
	 *
	 */
	public static class Candidate {
		
		public static final String SUBJECT_APPLIED = "Application Received";
		public static final String TEXT_APPLIED = "Application Received, Thanks!";
		
		public static final String SUBJECT_INVITED = "Invited for interview";
		public static final String TEXT_INVITED = "Can you please visit us at our Workplace?";
		
		public static final String SUBJECT_HIRED = "Job offer successful";
		public static final String TEXT_HIRED = "Congrats, You are Hired!"; 
		
		public static final String SUBJECT_REJECTED = "Job offer unsuccessful";
		public static final String TEXT_REJECTED = "Sorry, thanks for applying"; 
	}
	
	/**
	 * Email templates for the recruitment
	 * team
	 *
	 */
	public static class Team {
		
		public static final String SUBJECT_APPLIED = "Application Received";
		public static final String TEXT_APPLIED = "New application received from id: ";
		
		public static final String SUBJECT_INVITED = "Invited for interview";
		public static final String TEXT_INVITED = "Candidate visiting - id: ";
		
		public static final String SUBJECT_HIRED = "Job offer successful";
		public static final String TEXT_HIRED = "Candidate is hired - id: "; 
		
		public static final String SUBJECT_REJECTED = "Job offer unsuccessful";
		public static final String TEXT_REJECTED = "Candidate is rejected, id: "; 
	}
	
}
