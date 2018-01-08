package com.hr.recruitment.model.builder;

import com.hr.recruitment.model.ApplicationServiceRequest;

/**
 * @author arkasinha
 *
 */
public class ApplicationServiceRequestBuilder {
	
	/**
	 * Application service request
	 */
	private ApplicationServiceRequest applicationServiceRequest;
	
	/**
	 * Default Constructor
	 */
	public ApplicationServiceRequestBuilder(){
		this.applicationServiceRequest = new ApplicationServiceRequest();
	}
	
	/**
	 * @return builder
	 */
	public static ApplicationServiceRequestBuilder anApplication(){
		
		return new ApplicationServiceRequestBuilder();
	}
	
	/**
	 * @param email
	 * @return builder
	 */
	public ApplicationServiceRequestBuilder withEmailAs(String email){
		
		this.applicationServiceRequest.setCandidateEmail(email);
		return this;
	}
	
	/**
	 * @param jobTitle
	 * @return builder
	 */
	public ApplicationServiceRequestBuilder forJobTitle(String jobTitle){
		
		this.applicationServiceRequest.setJobTitle(jobTitle);
		return this;
	}
	
	/**
	 * @return applicationServiceRequest
	 */
	public ApplicationServiceRequest build(){
		
		return applicationServiceRequest;
	}
}