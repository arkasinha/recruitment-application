/**
 * 
 */
package com.hr.recruitment.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.hr.recruitment.constants.RecruitmentConstants;
import com.hr.recruitment.exception.RecruitmentException;
import com.hr.recruitment.model.ApplicationServiceRequest;
import com.hr.recruitment.model.ApplicationStatus;
import com.hr.recruitment.model.JobApplication;
import com.hr.recruitment.model.JobApplicationKey;
import com.hr.recruitment.model.JobOffer;
import com.hr.recruitment.model.builder.ApplicationServiceRequestBuilder;
import com.hr.recruitment.model.builder.JobApplicationBuilder;
import com.hr.recruitment.model.builder.JobOfferBuilder;
import com.hr.recruitment.repository.JobApplicationRepository;
import com.hr.recruitment.repository.JobOfferRepository;

/**
 * @author arkasinha
 *
 */
@RunWith(SpringRunner.class)
public class ApplicationServiceTest {
	
	@Autowired
	ApplicationService applicationService;
	
	/**
	 * Mock application repository
	 */
	@MockBean
	JobApplicationRepository applicationRepository;
	
	/**
	 * Mock offer repository
	 */
	@MockBean
	JobOfferRepository offerRepository;
	
	/**
	 * Mock notification service
	 */
	@MockBean
	NotificationService notificationService;
	
	/**
	 * To create ApplicationService bean
	 */
	@TestConfiguration
    static class ApplicationServiceTestConfiguration {
  
        @Bean
        public ApplicationService applicationService() {
            return new ApplicationService();
        }
    }

	/**
	 * Test method for {@link com.hr.recruitment.service.ApplicationService#applyToOffer(com.hr.recruitment.model.ApplicationServiceRequest)}.
	 */
	@Test
	public void testNormalApplication() {
		
		boolean isHappyPathSuccessful = true;
		
		// Build a healthy request
		ApplicationServiceRequest request  = ApplicationServiceRequestBuilder.anApplication()
																			 .forJobTitle("system admin")
																			 .withEmailAs("goodemail@gmail.com")
																			 .build();
		
		 Mockito.when(offerRepository.findByJobTitle("system admin"))
	      		.thenReturn(JobOfferBuilder.aJobOffer().withApplicantCountAs(0).build());
		
		/*
		 * Happy path
		 */
		try {
			
			applicationService.applyToOffer(request);
			
		} catch (RecruitmentException e) {
			
			// Shouldn't have happened :(
			isHappyPathSuccessful = false;
		}
		
		assertEquals(true, isHappyPathSuccessful);
		
	}
	
	/**
	 * Test method for {@link com.hr.recruitment.service.ApplicationService#applyToOffer(com.hr.recruitment.model.ApplicationServiceRequest)}.
	 */
	@Test
	public void testInvalidOfferInApplication(){
		
		String errorMessage = null;
		
		// Build a request
		ApplicationServiceRequest request  = ApplicationServiceRequestBuilder.anApplication()
																					 .forJobTitle("some title")
																					 .withEmailAs("invalid@gmail.com")
																					 .build();
		
		/*
		 *  Don't define a mock response for offerRepository, 
		 *  it'll return null as a result
		 */		
		try {
			applicationService.applyToOffer(request);
			
		} catch (RecruitmentException e) {
			errorMessage = e.getMessage();			
		}
		
		assertEquals(RecruitmentConstants.ERROR_OFFER_NOT_FOUND, errorMessage);
	}
	
	/**
	 * Test method for {@link com.hr.recruitment.service.ApplicationService#applyToOffer(com.hr.recruitment.model.ApplicationServiceRequest)}.
	 */
	@Test
	public void testDuplicateApplication(){
		
		String errorMessage = null;
		ApplicationServiceRequest request = ApplicationServiceRequestBuilder.anApplication()
																			.forJobTitle("system admin")
																			.withEmailAs("existing@gmail.com")
																			.build();
		 // offer is fine
		 Mockito.when(offerRepository.findByJobTitle("system admin"))
   				.thenReturn(new JobOffer());
		 
		 JobApplicationKey jobApplicationKey = new JobApplicationKey();
		 jobApplicationKey.setCandidateEmail("existing@gmail.com");
		 jobApplicationKey.setJobTitle("system admin");
		 
		 // Application already exists
		 Mockito.when(applicationRepository.findOne(jobApplicationKey))
		 		.thenReturn(new JobApplication());
		
		try {
			applicationService.applyToOffer(request);
			
		} catch (RecruitmentException e) {
			errorMessage = e.getMessage();			
		}
		
		assertEquals(RecruitmentConstants.ERROR_APPLICATION_ALREADY_EXISTS, errorMessage);
	}

	/**
	 * Test method for {@link com.hr.recruitment.service.ApplicationService#updateApplication(com.hr.recruitment.model.JobApplication)}.
	 */
	@Test
	public void testUpdateApplication() {
		
		boolean noExceptions = true;
		
		JobApplication oldApplication = JobApplicationBuilder.aJobApplication()
															 .withEmail("good@gmail.com")
															 .withStatusChangedTo(ApplicationStatus.APPLIED)
															 .forOffer("system admin")
															 .build();
		
		JobApplication updatedApplication = JobApplicationBuilder.aJobApplication()
														  		 .withEmail("good@gmail.com")
														  		 .forOffer("system admin")
														  		 .withStatusChangedTo(ApplicationStatus.INVITED)
														  		 .build();
		
		JobApplicationKey jobApplicationKey = new JobApplicationKey();
		jobApplicationKey.setCandidateEmail("good@gmail.com");
		jobApplicationKey.setJobTitle("system admin");
		
		Mockito.when(applicationRepository.findOne(jobApplicationKey))
			   .thenReturn(oldApplication);		
		
		try{
			applicationService.updateApplication(updatedApplication);
			
		}catch(RecruitmentException exception){
			
			noExceptions = false;
		}
		
		assertEquals(true, noExceptions);		
	}
}