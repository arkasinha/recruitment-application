package com.hr.recruitment.model.builder;

import com.hr.recruitment.model.JobOffer;

/**
 * @author arkasinha
 *
 */
public class JobOfferBuilder {

	private JobOffer jobOffer;
	
	/**
	 * 
	 */
	public JobOfferBuilder(){
		jobOffer = new JobOffer();
	}
	
	/**
	 * @return
	 */
	public static JobOfferBuilder aJobOffer(){
		return new JobOfferBuilder();
	}
	
	/**
	 * @param title
	 * @return
	 */
	public JobOfferBuilder withTitleAs(String title){
		
		this.jobOffer.setJobTitle(title);
		return this;
	}
	
	/**
	 * @param count
	 * @return
	 */
	public JobOfferBuilder withApplicantCountAs(Integer count){
		
		this.jobOffer.setNumberOfApplicants(count);
		return this;
	}

	/**
	 * @param teamEmail
	 * @return
	 */
	public JobOfferBuilder withTeamEmailAs(String teamEmail) {
		
		this.jobOffer.setTeamEmail(teamEmail);
		
		return this;
	}
	
	/**
	 * @return
	 */
	public JobOffer build(){
		
		return this.jobOffer;
	}
}
