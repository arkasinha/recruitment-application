package com.hr.recruitment.constants;

/**
 * Endpoint URLs and paths for this
 * application 
 * 
 * @author arkasinha
 *
 */
public final class Urls {
	
	/**
	 * Default Const
	 */
	private Urls(){
		
	}
	
	/**
	 * Endpoints of all JobOffer based services
	 * 
	 * @author arkasinha
	 */
	public static final class Offer {
		
		public static final String OFFER = "/recruitment/offer";
		public static final String CREATE_OFFER = "/createOffer";
		public static final String LIST_ALL_OFFERS = "/listAllOffers";
		public static final String GET_OFFER_DETAILS = "/getOfferDetails";
		public static final String GET_APPLICATIONS_FOR_OFFER = "/getApplicationsForOffer";	
	}
	
	/**
	 * Endpoints of all JobApplication based services
	 * 
	 * @author arkasinha
	 */
	public static final class Application {
		
		public static final String APPLICATION = "/recruitment/application";
		public static final String APPLY_TO_OFFER = "/applyToOffer";
		public static final String GET_APPLICATION_DETAILS = "/getApplicationDetails";
		public static final String GET_CANDIDATE_APPLICATIONS = "/getCandidateApplications";
		public static final String UPDATE_APPLICATION = "/updateApplication";				
	}
}