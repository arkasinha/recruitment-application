package com.hr.recruitment.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Model/Entity for a Job Offer
 * 
 * @author arkasinha
 *
 */
@Table(name = "job_offer")
@Entity
public class JobOffer implements Serializable{
		
	private static final long serialVersionUID = -9842932831L;	
	
	/**
	 *  Unique title for each offer
	 */
	@Id
	@Column(name = "job_title", unique = true)
	private String jobTitle;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "number_of_applicants")
	private Integer numberOfApplicants;
	
	@Column(name="team_email")
	private String teamEmail;
		
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Integer getNumberOfApplicants() {
		return numberOfApplicants;
	}
	public void setNumberOfApplicants(Integer numberOfApplicants) {
		this.numberOfApplicants = numberOfApplicants;
	}
	
	@Override
	public String toString() {
		return "JobOffer [jobTitle=" + jobTitle + ", startDate=" + startDate
				+ ", numberOfApplicants=" + numberOfApplicants + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((jobTitle == null) ? 0 : jobTitle.hashCode());
		result = prime
				* result
				+ ((numberOfApplicants == null) ? 0 : numberOfApplicants
						.hashCode());
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobOffer other = (JobOffer) obj;
		if (jobTitle == null) {
			if (other.jobTitle != null)
				return false;
		} else if (!jobTitle.equals(other.jobTitle))
			return false;
		if (numberOfApplicants == null) {
			if (other.numberOfApplicants != null)
				return false;
		} else if (!numberOfApplicants.equals(other.numberOfApplicants))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}
	
	/**
	 * @return the teamEmail
	 */
	public String getTeamEmail() {
		return teamEmail;
	}
	/**
	 * @param teamEmail the teamEmail to set
	 */
	public void setTeamEmail(String teamEmailList) {
		this.teamEmail = teamEmailList;
	}		
}