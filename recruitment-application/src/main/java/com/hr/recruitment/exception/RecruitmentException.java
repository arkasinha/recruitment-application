package com.hr.recruitment.exception;

/**
 * Custom exception for recruitment-application
 * 
 * @author arkasinha
 *
 */
public class RecruitmentException extends Exception {

	private static final long serialVersionUID = -32309293931L;
	
	/**
	 * @param errorMessage
	 * @param cause
	 */
	public RecruitmentException(String errorMessage, Throwable cause) {
		super(errorMessage, cause);
	}
	
	/**
	 * @param errorMesage
	 */
	public RecruitmentException(String errorMesage) {
		super(errorMesage);
	}
	
	/**
	 * @param cause
	 */
	public RecruitmentException(Throwable cause) {
		super(cause);
	}
}