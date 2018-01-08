package com.hr.recruitment.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

/**
 * Error message for any REST service failures
 * 
 * @author arkasinha
 *
 */
public class ServiceError implements Serializable {

	private static final long serialVersionUID = -392301L;

	private HttpStatus httpStatus;
	private String errorMessage;
	private List<String> errors;

	/**
	 * @param status
	 * @param message
	 * @param errors
	 */
	public ServiceError(HttpStatus status, String message, List<String> errors) {
		super();
		this.httpStatus = status;
		this.errorMessage = message;
		this.errors = errors;
	}

	/**
	 * @param status
	 * @param message
	 * @param error
	 */
	public ServiceError(HttpStatus status, String message, String error) {
		super();
		this.httpStatus = status;
		this.errorMessage = message;
		errors = Arrays.asList(error);
	}

	/**
	 * Default Constructor
	 */
	public ServiceError(){
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage
	 *            the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * @return the httpStatus
	 */
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	/**
	 * @param httpStatus
	 *            the httpStatus to set
	 */
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	/**
	 * @return the errors
	 */
	public List<String> getErrors() {
		return errors;
	}

	/**
	 * @param errors
	 *            the errors to set
	 */
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ServiceError [httpStatus=" + httpStatus + ", errorMessage="
				+ errorMessage + ", errors=" + errors + "]";
	}
}