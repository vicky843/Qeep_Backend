package com.qeepchat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qeepchat.dao.JobDAOImpl;
import com.qeepchat.model.Job;
import com.qeepchat.model.JobApplication;

@Service
@Transactional
public class JobService {
	@Autowired (required=true)
	JobDAOImpl jobDAO;
	
	
	public boolean save(Job job) {
		return jobDAO.save(job);
	}
	
	public boolean save(JobApplication jobApplication) {
		return jobDAO.save(jobApplication);
	}
	
	public List<Job> list() {
		return jobDAO.list();
	}
	
	public List<JobApplication> listJobApplication() {
		return jobDAO.listJobApplication();
	}
	
	public Job getJobDetails(int JobId) {
		return jobDAO.getJobDetails(JobId);
	}
	
	public boolean postJob(Job job) {
		return jobDAO.postJob(job);
	}
	
	public boolean update(Job job) {
		return jobDAO.update(job);
	}
	
	public List<Job> getAllVacantJobs() {
		return jobDAO.getAllVacantJobs();
	}
	
	public List<Job> getAllJobs() {
		return jobDAO.getAllJobs();
	}
	
	public boolean applyForJob(JobApplication jobApplication) {
		return jobDAO.applyForJob(jobApplication);
	}
	
	public boolean updateJobApplication(JobApplication jobApplication) {
		return jobDAO.updateJobApplication(jobApplication);
	}
	
	public JobApplication get(int id, int jobId) {
		return jobDAO.get(id, jobId);
	}
	
	public JobApplication getMyAppliedJobs(int id) {
		return jobDAO.getMyAppliedJobs(id);
	}
	
	public JobApplication getJobApplication(int id) {
		return jobDAO.getJobApplication(id);
	}
	
	
}
