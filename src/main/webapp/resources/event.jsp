<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en-US">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"href="resources/css/bootstrap-theme.min.css" />
<!-- <script src="resources/js/angular.min.js"></script>
<script src="resources/js/angular-resource.min.js"></script>
<script src="resources/js/event.js"></script> 
<script src="resources/js/jquery-1.12.4.min.js"></script>
 <script src="resources/js/bootstrap.min.js"></script>   -->
<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css"/>
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css"> 
   <style>
   body{
background-image:  url("resources/images/e1714a3aa5e4f318c48727ed68cef69c.jpg");
   
  } 
  .msg-val{
  color : red;
   };

}
  
   </style> 
  </head>
  <body >
   <div ng-controller="EventController as eventCtrl">
       <div class="container">
	<form name="eventForm" method="POST">
	    <table>
		<tr><td colspan="2">
		  <div ng-if="eventCtrl.flag != 'edit'">
		     
		  </div>
		  <div ng-if="eventCtrl.flag == 'edit'">
		     <h3> Update Event for ID: {{ eventCtrl.event.c_id }} </h3> 
		  </div> </td>
		</tr>
		
	  
		
		     <div class="col-sm-10">
				<div class="">
				
				
				<div class="form-group">
				 <label class="control-label" for="">Event Name:</label>
				<input type="text" class="form-control" name="c_name" ng-model="eventCtrl.event.c_name" required/> 
         	      <span ng-show="eventForm.c_name.$error.required" class="msg-val">Event is required.</span>
         	      </div>
         	      </div>
										
				<div class="form-group">
				<label class="control-label" for="">Description</label>
		        <input type="text"  class="form-control" name="c_desc" ng-model="eventCtrl.event.c_desc" required/> 
	              <span ng-show="eventForm.c_desc.$error.required" class="msg-val">Description is required.</span>
	              </div>
         	      
		
		
				<div class="form-group">
				<div class="col-xs-6 col-sm-6 col-md-6">
				<label class="control-label" for="">Venue</label>
		      <input type="text" class="form-control" name="c_venue" ng-model="eventCtrl.event.c_venue" required/> 
	              <span ng-show="eventForm.c_venue.$error.required" class="msg-val">Venue is required.</span>
		      </div>
			</div>
				
				<div class="form-group">
				<div class="col-xs-6 col-sm-6 col-md-6">
				<label class="control-label" for="">Date</label>
		      <input type="date"   name="c_dateTime" ng-model="eventCtrl.event.c_dateTime" class="form-control" required/> 
	              <span ng-show="eventForm.c_dateTime.$error.required" class="msg-val">Date is required.</span> 
			</div>
		</div>
		    
	        <div style="height:10px;"></div>
				<div class="form-group">
				  <label class="control-label" for=""></label>
	            <div ng-if="eventCtrl.flag != 'edit'">
		       <input  type="submit" class="w3-btn w3-pink w3-round-xlarge" ng-click="eventCtrl.createEvent()" value="Add Event"/> 
		       <!-- <input type="button" ng-click="eventCtrl.reset()" value="Reset"/> -->
		    </div>
		    <div ng-if="eventCtrl.flag == 'edit'">
		       <input  type="submit" class="w3-btn w3-red w3-round-xlarge" ng-click="eventCtrl.updateEventDetail()" value="Update Event"/> 	
			   <input type="button" ng-click="eventCtrl.cancelUpdate()" value="Cancel"/>				   
		    </div> </td>
		</tr>
		<tr>
		     <td colspan="2"> <span ng-if="eventCtrl.flag=='deleted'" class="msg-success">Event successfully deleted.</span>
		</tr>
 </table>      
</form>
	
       <div class="container">
        <table class="table table-hover">
        
	      <tr><th>Event Id</th> 
	          <th>Name</th> 
	          <th>Venue</th> 
	          <th>Description</th> 
	          <th>Date</th>
	          <th>Action</th>
	      </tr>
	      <tr ng-repeat="row in eventCtrl.events">
	         <td><span ng-bind="row.c_id"></span></td>
	         <td><span ng-bind="row.c_name"></span></td>
	         <td><span ng-bind="row.c_venue"></span></td>
	         <td><span ng-bind="row.c_desc"></span></td>
	         <td><span ng-bind="row.c_dateTime"></span></td>
	         <td>
		    <input type="button" class="w3-btn w3-lime w3-round-xlarge" ng-click="eventCtrl.deleteEvent(row.c_id)" value="Delete"/>
		    <input type="button" class="w3-btn w3-indigo w3-round-xlarge" ng-click="eventCtrl.edit(row.c_id)" value="Edit"/>
		    <span ng-if="eventCtrl.flag=='updated' && row.c_id==eventCtrl.updatedId" class="msg-success">Event successfully updated.</span> </td> 
	      </tr>	
	</table>
	</div>     
 </body>
</html>  