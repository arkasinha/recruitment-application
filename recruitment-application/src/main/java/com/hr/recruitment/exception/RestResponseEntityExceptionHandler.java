package com.hr.recruitment.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hr.recruitment.constants.RecruitmentConstants;
import com.hr.recruitment.model.ServiceError;

/**
 * Custom handler for errors and faults
 * 
 * @author arkasinha
 *
 */
@ControllerAdvice(basePackages={"com.hr"})
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * Handles recruitment exception like
	 * invalid application, invalid update etc.
	 * 
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(value = {RecruitmentException.class})
	public ResponseEntity<Object> handleRecruitmentException(RecruitmentException ex, WebRequest request){
		
		// Create a service error object
		ServiceError serviceError = new ServiceError(HttpStatus.BAD_REQUEST, ex.getMessage(), ex.toString());
		
		return new ResponseEntity<Object>(serviceError, new HttpHeaders(), serviceError.getHttpStatus());
	}	
}	