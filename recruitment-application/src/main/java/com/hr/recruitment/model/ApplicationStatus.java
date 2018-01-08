package com.hr.recruitment.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Different application status for a 
 * job offer and for an applicant
 * 
 * @author arkasinha
 */
public enum ApplicationStatus {
	
	APPLIED(1),
	
	INVITED(2),
	
	REJECTED(3),
	
	HIRED(4);
	
	private Integer value;
	
	/**
	 * value can be applied, invited, 
	 * rejected or hired
	 * 
	 * @param value
	 */
	ApplicationStatus(Integer value){
		
		this.setValue(value);
	}

	/**
	 * @return the value
	 */
	public Integer getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Integer value) {
		this.value = value;		
	}
	
	@JsonValue
	public String toValue(){
		
		return this.name();
	}
	
	/**
	 * Find the Enum version of the 
	 * String provided here
	 * 
	 * @param value
	 * @return matchingStatus
	 */
	@JsonCreator
	public static ApplicationStatus fromValue(String value){
		
		ApplicationStatus matchingStatus = null;	
		
		// iterate on the array of values
		for(ApplicationStatus status : values()){
			
			// if enum's name matches to value
			if(status.name().equalsIgnoreCase(value)){
				
				// this is the enum value we need
				matchingStatus = status;
				
				break;
			}
		}
		
		return matchingStatus;
	}
}