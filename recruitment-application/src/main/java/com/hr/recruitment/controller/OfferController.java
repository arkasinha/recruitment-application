package com.hr.recruitment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hr.recruitment.constants.Urls;
import com.hr.recruitment.exception.RecruitmentException;
import com.hr.recruitment.model.JobApplication;
import com.hr.recruitment.model.JobOffer;
import com.hr.recruitment.service.OfferService;


/**
 * Endpoints for offer related features
 * 
 * @author arkasinha
 *
 */
@RestController
@RequestMapping(Urls.Offer.OFFER)
public class OfferController {
	
	@Autowired
	OfferService offerService;
	
	/**
	 * Creates a new job offer
	 * 
	 * @param offerDetails
	 * @throws RecruitmentException 
	 */
	@RequestMapping(value=Urls.Offer.CREATE_OFFER, method=RequestMethod.POST)
	public void createOffer(@Valid @RequestBody(required=true) final JobOffer offerDetails) throws RecruitmentException{
		
		offerService.createOffer(offerDetails);
	}
	
	/**
	 * Lists down all open job offers
	 * 
	 * @return offers
	 */
	@RequestMapping(value=Urls.Offer.LIST_ALL_OFFERS, method=RequestMethod.GET)
	public List<JobOffer> listAllOffers(){
		
		return offerService.listAllOffers();
	}
	
	/**
	 * Get details of an offer
	 * 
	 * @param jobTitle
	 * @return offerDetails
	 * @throws RecruitmentException 
	 */
	@RequestMapping(value=Urls.Offer.GET_OFFER_DETAILS, method=RequestMethod.GET)
	public JobOffer getOfferDetails(@RequestParam(required=true)final String jobTitle) throws RecruitmentException{
		
		return offerService.getOfferDetails(jobTitle);
	}
	
	/**
	 * Get all applications submitted for an offer
	 * 
	 * @param jobTitle
	 * @return applications
	 * @throws RecruitmentException 
	 */
	@RequestMapping(value=Urls.Offer.GET_APPLICATIONS_FOR_OFFER, method=RequestMethod.GET)
	public List<JobApplication> getApplicationsForOffer(@RequestParam(required=true)final String jobTitle) throws RecruitmentException{
		
		return offerService.getApplicationsForOffer(jobTitle);
	}
}