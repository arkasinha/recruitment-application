package com.hr.recruitment.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hr.recruitment.model.JobOffer;

@Transactional
public interface JobOfferRepository extends JpaRepository<JobOffer, Long>{
	
	public JobOffer findByJobTitle(String jobTitle);

}
