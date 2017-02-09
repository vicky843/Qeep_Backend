package com.qeepchat.dao;

import java.util.List;

import com.qeepchat.model.Job;
import com.qeepchat.model.JobApplication;

public interface JobDAO {
	
	public boolean save(Job job);
	public boolean save(JobApplication jobApplication);
	//public boolean delete(Job job);
	public List<Job> list();
   public List<JobApplication> listJobApplication();
	public Job getJobDetails(int JobID);
	
public boolean postJob(Job job);
public boolean update(Job job);
public List<Job> getAllVacantJobs();
public List<Job> getAllJobs();

public boolean applyForJob(JobApplication jobApplication);
public boolean updateJobApplication(JobApplication jobApplication);
public JobApplication get(int id, int JobID);
public JobApplication getMyAppliedJobs(int id);
public JobApplication getJobApplication(int id);

	

}

