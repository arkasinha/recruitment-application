package com.hr.recruitment.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author arkasinha
 *
 */
@Table(name="job_application", 
uniqueConstraints=@UniqueConstraint(columnNames={"candidate_email", "job_title"}))
@Entity
@IdClass(JobApplicationKey.class)
public class JobApplication implements Serializable{
	
	private static final long serialVersionUID = -8409289021L;
	
	@Id
	@Column(name="candidate_email")
	private String candidateEmail;
    
	@Id
	@Column(name = "job_title")
	private String jobTitle;
	
	@Column(name = "resume_text")
	private String resumeText;
	
	/**
	 * Applied, invited, hired, rejected
	 */
	@Column(name = "application_status")
	@Enumerated(EnumType.STRING)
	private ApplicationStatus applicationStatus;
	
	
	/**
	 * @param candidateEmail
	 * @param resumeText
	 * @param jobOffer
	 */
	public JobApplication(String candidateEmail, String resumeText,
			String jobTitle) {
		
		this.candidateEmail = candidateEmail;
		this.resumeText = resumeText;
		this.jobTitle = jobTitle;
		this.applicationStatus = ApplicationStatus.APPLIED;
	}
	
	public JobApplication(){
		
	}
	
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
	/**
	 * @return the applicationStatus
	 */
	public ApplicationStatus getApplicationStatus() {
		return applicationStatus;
	}
	/**
	 * @param applicationStatus the applicationStatus to set
	 */
	public void setApplicationStatus(ApplicationStatus applicationStatus) {
		this.applicationStatus = applicationStatus;
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


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "JobApplication [candidateEmail=" + candidateEmail
				+ ", jobTitle=" + jobTitle + ", resumeText=" + resumeText
				+ ", applicationStatus=" + applicationStatus + "]";
	}
}