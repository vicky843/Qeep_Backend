package com.qeepchat.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.qeepchat.model.Job;
import com.qeepchat.model.JobApplication;
import com.qeepchat.service.JobService;

@RestController
public class JobController {
	
private static final Logger logger = LoggerFactory.getLogger(JobController.class);
	
	@Autowired(required=true)
	JobService jobService;
	
	@Autowired(required=true)
	Job job;
	
	@Autowired(required=true)
	JobApplication jobApplication;
	
	@RequestMapping(value = "/getAllJobs/" , method = RequestMethod.GET)
	public ResponseEntity<List<Job>> getjobs()
	{
		List<Job> jobs = jobService.list();
		if(jobs == null)
		{
			job = new Job();
			 job.setErrorCode("404");
       	  job.setErrorMessage("No blogs are available");
       	  return new ResponseEntity<List<Job>>(HttpStatus.NO_CONTENT);
		}
		 else
         {
       	  return new ResponseEntity<List<Job>>(jobs, HttpStatus.OK);
         }
	}
	
	@RequestMapping(value = "/getAllJobsApplication/" , method = RequestMethod.GET)
	public ResponseEntity<List<JobApplication>> getjobsapplied()
	{
		List<JobApplication> jobapplied = jobService.listJobApplication();
		if(jobapplied == null)
		{
			job = new Job();
			 job.setErrorCode("404");
       	  job.setErrorMessage("No jobapplied are available");
       	  return new ResponseEntity<List<JobApplication>>(HttpStatus.NO_CONTENT);
		}
		 else
         {
       	  return new ResponseEntity<List<JobApplication>>(jobapplied, HttpStatus.OK);
         }
	}
	
	/*@RequestMapping(value="/getMyAppliedJobs/" , method = RequestMethod.GET)
	public ResponseEntity<List<Job>> getMyAppliedJobs(HttpSession httpSession) {
		logger.debug("Starting of the method getMyAppliedJobs");
		String loggedInUserID =  (String) httpSession.getAttribute("loggedInUserID");
		
		List<Job> job = jobDAO.getAllJobsApplication();
		List<Job> jobapplication = (List<Job>) jobDAO.getAllJobsApplication();
		return new ResponseEntity<List<Job>>(job , HttpStatus.OK);
	}*/
	
	@RequestMapping(value = "/applyForJob/{jobId}", method = RequestMethod.POST)
	public ResponseEntity<Job> applyforJob(@PathVariable("jobId") int jobId, HttpSession httpSession)
	{
		logger.debug("Starting of the method getMyAppliedJobs");
		int loggedInUserId =(Integer)httpSession.getAttribute("loggedInUserId");
		
		/*jobApplication = jobDAO.getJobApplication(jobID);*/
		jobApplication.setId(loggedInUserId);
	    jobApplication.setJobAppId(jobId);
		jobApplication.setStatus('N');
		jobApplication.setDateTime(null);
		if (jobService.save(jobApplication))
		{
			job.setErrorCode("404");
			job.setErrorMessage("Not able to apply for the job");
			
		}
		 return new ResponseEntity<Job> (job , HttpStatus.OK);
	}
	
	

	
	
	
	@RequestMapping(value="/getJobDetails/{JobId}", method = RequestMethod.GET)
	public ResponseEntity<Job> getJobDetails(@PathVariable("JobId") int JobId) {
		logger.debug("Starting of the method getJobDetails");
		Job job= jobService.getJobDetails(JobId);
		return new ResponseEntity<Job>(job, HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value="/getAllJobDetails/{jobId}", method  = RequestMethod.PUT)
	public ResponseEntity<Job> getAllJobDetails(@RequestParam("jobId")int jobId, HttpSession httpSession){
		logger.debug("Starting of the method getAllJobDetails");
		int loggedInUserId =(Integer)httpSession.getAttribute("loggedInUserId");
		
		jobApplication = jobService.getJobApplication(jobId);
		jobApplication.setId(loggedInUserId);
		jobApplication.setStatus('N');
		if(jobService.save(jobApplication)) {
			job.setErrorCode("404");
			job.setErrorMessage("Not able to apply for the job");
			logger.debug("Not able to apply for the job");
		}
		return new ResponseEntity<Job>(job , HttpStatus.OK);
	}
	
	@RequestMapping(value="/selectUser/{id}/{jobId}", method = RequestMethod.PUT)
	public ResponseEntity<Job> selectUser(@RequestParam("id")int id,@RequestParam("jobID")int jobId){
		logger.debug("Starting of the method selectUser");
		jobApplication.setStatus('S');
		if(jobService.save(jobApplication)) {
			job.setErrorCode("404");
			job.setErrorMessage("Not able to change the application status as 'selected'");
			logger.debug("Not able to change the application status as 'selected'");
		}
		return new ResponseEntity<Job>(job, HttpStatus.OK);
	}
	
	@RequestMapping(value="/canCallForInterview/{id}/{jobId}",method = RequestMethod.PUT)
	public ResponseEntity<Job> callForInterview(@PathVariable("id")int id, @PathVariable("jobId")Long jobId){
		logger.debug("Starting of the method canCallForInterview");
		jobApplication.setStatus('C');
		if(jobService.save(jobApplication)){
			job.setErrorCode("404");
			job.setErrorMessage("Not able to change the job application status 'Call for Interview'");
			logger.debug("Not able to change the job application status 'Call for Interview'");
		}
		return new ResponseEntity<Job>(job, HttpStatus.OK);
	}
	
	@RequestMapping(value="/rejectJobApplcation/{id}/{jobId}",method= RequestMethod.PUT)
	public ResponseEntity<Job> rejectJobApplication(@PathVariable("id")int id , @PathVariable("jobId")int jobId){
		logger.debug("Starting of the method rejectJobApplication");
		//jobApplication = jobDAO.getJobApplication(userID, jobID);
		
		jobApplication.setStatus('R');
		if(jobService.save(jobApplication) ==false) {
			job.setErrorCode("404");
			job.setErrorMessage("Not able to reject the application");
			logger.debug("Not able to reject the application");
		}
		else
		{
			job.setErrorCode("200");
			job.setErrorMessage("Successfully updated the status as Rejected");
		}
		return new ResponseEntity<Job>(job, HttpStatus.OK);
	}
	
	@RequestMapping(value="/postAJob/", method = RequestMethod.POST)
	public ResponseEntity<Job> postAJob(@RequestBody Job job, HttpSession httpsession) {
		logger.debug("Starting of the method postAJob");
		
		int loggedInUserId =(Integer) httpsession.getAttribute("loggedInUserId");
		
		job.setId(loggedInUserId);
		job.setStatus("N");
		
		jobService.save(job);
		
		/*if(jobDAO.save(job) == false) {
			job.setErrorCode("404");
			job.setErrorMessage("Not able to post a job");
			logger.debug("Not able to post a job");
		}*/
		return new ResponseEntity<Job>(job , HttpStatus.OK);
	}	
	
	
	 @RequestMapping(value="/jobaccept/{id}" , method = RequestMethod.PUT)
	   public  ResponseEntity<JobApplication> jobaccept(@PathVariable("id") int id, @RequestBody JobApplication jobApplication ) 
	   {
		 jobApplication = jobService.getJobApplication(jobApplication.getId());  
		 
		  if(jobApplication==null)
		  {
			 
			  jobApplication = new JobApplication();
			   return new ResponseEntity<JobApplication>(jobApplication, HttpStatus.NOT_FOUND);
		  }
		  
		  jobApplication.setStatus('A');
		  jobApplication.setRemarks("C");
		  jobService.updateJobApplication(jobApplication); 
		  
		   
		   return new ResponseEntity<JobApplication>(jobApplication, HttpStatus.OK);
	   }



}
