package com.hr.recruitment.constants;


/**
 * Constants literals of recruitment-applications
 * 
 * @author arkasinha
 *
 */
public final class RecruitmentConstants {
	
	/*
	 * Custom Error Messages
	 * TODO move error constants to a dedicated error file 
	 */
	
	/**
	 * When user is trying to create the same offer again
	 */
	public static final String ERROR_OFFER_ALREADY_EXISTS = "Offer with the same title already exists";
	
	/**
	 * Any runtime error
	 */
	public static final String ERROR_SERVER = "Internal Server Error";
	
	/**
	 * We are applying for an Offer which doesn't exist
	 */
	public static final String ERROR_OFFER_NOT_FOUND = "Offer not found in DB";
	
	/**
	 * Trying to lookup an applicant's application details, but it is not there in database
	 */
	public static final String ERROR_APPLICATION_NOT_FOUND = "Given application is not found in DB";
	
	/**
	 * Trying to make an illogical application status change, like from HIRED to INVITED
	 */
	public static final String ERROR_INVALID_APP_STATUS_UPDATE = "Invalid application status change.Application status can't be moved backwords, please contact administrator";
	
	/**
	 * If empty email address is provided to lookup application details
	 */
	public static final String ERROR_INVALID_REQUEST_EMAIL = "Empty email address not allowed";
	
	/**
	 * If empty job title is provided to lookup offer details
	 */
	public static final String ERROR_INVALID_REQ_JOB_TITLE = "Empty job title not allowed";
	
	/**
	 * When a User is trying to submit an application for an offer more than once
	 */
	public static final String ERROR_APPLICATION_ALREADY_EXISTS = "You have already applied for this offer";
	
}