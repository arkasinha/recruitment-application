package com.hr.recruitment.model;

import java.io.Serializable;

/**
 * Request object for submitting applications
 * 
 * @author arkasinha
 *
 */
public class ApplicationServiceRequest implements Serializable{

	private static final long serialVersionUID = -472383271L;
	
	private String candidateEmail;
	private String jobTitle;
	private String resumeText;
	
	/**
	 * @return the candidateEmail
	 */
	public String getCandidateEmail() {
		return candidateEmail;
	}
	/**
	 * @param candidateEmail the candidateEmail to set
	 */
	public void setCandidateEmail(String candidateEmail) {
		this.candidateEmail = candidateEmail;
	}
	/**
	 * @return the jobTitle
	 */
	public String getJobTitle() {
		return jobTitle;
	}
	/**
	 * @param jobTitle the jobTitle to set
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	/**
	 * @return the resumeText
	 */
	public String getResumeText() {
		return resumeText;
	}
	/**
	 * @param resumeText the resumeText to set
	 */
	public void setResumeText(String resumeText) {
		this.resumeText = resumeText;
	}			
}
