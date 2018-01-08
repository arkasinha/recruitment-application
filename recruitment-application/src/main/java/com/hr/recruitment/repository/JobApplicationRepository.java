package com.hr.recruitment.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hr.recruitment.model.JobApplication;
import com.hr.recruitment.model.JobApplicationKey;

@Transactional
public interface JobApplicationRepository extends JpaRepository<JobApplication, JobApplicationKey>{

	public List<JobApplication> findByCandidateEmail(String candidateEmail);

	public List<JobApplication> findByJobTitle(String jobTitle);

}
