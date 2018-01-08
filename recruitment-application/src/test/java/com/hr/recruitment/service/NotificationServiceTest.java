/**
 * 
 */
package com.hr.recruitment.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hr.recruitment.model.ApplicationStatus;
import com.hr.recruitment.model.JobApplication;
import com.hr.recruitment.model.JobOffer;
import com.hr.recruitment.model.builder.JobApplicationBuilder;
import com.hr.recruitment.model.builder.JobOfferBuilder;

/**
 * @author arkasinha
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class NotificationServiceTest {
	
	@Autowired
	NotificationService notificationService;

	@Test
	public void testNotifyUser(){
		
		// A job offer
		JobOffer offer = JobOfferBuilder.aJobOffer()
										.withTitleAs("system admin")
										.withTeamEmailAs("asinha18@gmail.com, arkasinha@deloitte.com")
										.build();
		
		// Application to offer
		JobApplication application = JobApplicationBuilder.aJobApplication()
														  .withEmail("asinha18@gmail.com")
														  .forOffer("system admin")
														  .withStatusChangedTo(ApplicationStatus.INVITED)
														  .build();
		
		notificationService.notifyUsers(application, offer);
	}
}