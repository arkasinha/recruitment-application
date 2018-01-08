package com.hr.recruitment.model.builder;

import com.hr.recruitment.model.ApplicationStatus;
import com.hr.recruitment.model.JobApplication;
import com.hr.recruitment.model.JobOffer;

public class JobApplicationBuilder {
	
	private JobApplication jobApplication;
	
	public JobApplicationBuilder(){
		jobApplication = new JobApplication();
	}
	
	/**
	 * @return
	 */
	public static JobApplicationBuilder aJobApplication(){
		
		return new JobApplicationBuilder();
	}
	
	/**
	 * @param email
	 * @return
	 */
	public JobApplicationBuilder withEmail(String email){
		
		this.jobApplication.setCandidateEmail(email);
		
		return this;
	}
	
	/**
	 * @param jobTitle
	 * @return
	 */
	public JobApplicationBuilder forOffer(String jobTitle){
				
		this.jobApplication.setJobTitle(jobTitle);
		
		return this;
	}
	
	/**
	 * @param status
	 * @return
	 */
	public JobApplicationBuilder withStatusChangedTo(ApplicationStatus status){
		
		this.jobApplication.setApplicationStatus(status);
		
		return this;
	}
	
	/**
	 * @return jobApplication
	 */
	public JobApplication build(){
		
		return jobApplication;
	}

}
