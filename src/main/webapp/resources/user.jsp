 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"href="resources/css/bootstrap-theme.min.css" />

</head>
<body ng-app="myApp">
  
   <div ng-controller="UserController as userCtrl">
    <div class="row">
    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
	<form name="userForm" method="POST">
	    <table>
	<tr>
		<td colspan="2">
		   <div ng-if="userCtrl.flag != 'edit'">
		    
		  </div>
		  <div ng-if="userCtrl.flag == 'edit'">
		     <h3> Update User for ID: {{ userCtrl.user.id }} </h3> 
		  </div> 
		  </td>
	</tr>
	
     
		
		     <div class="col-sm-10">
				<div class="">
				
				<h3><i class="fa fa-shield"></i> Register now</h3>
			  	<hr>
				<div class="form-group">
				 <label class="control-label" for="">Name</label>
				<input type="text" class="form-control" name="name" placeholder="Name" ng-model="userCtrl.user.name" required/> 
         	     <span ng-show="userForm.name.$error.required" class="msg-val">Name is required.</span>
         	      </div>
         	      </div>
										
				<div class="form-group">
				<label class="control-label" for="">Address</label>
		        <input type="text" class="form-control" name="address" ng-model="userCtrl.user.address" required/> 
	               <span ng-show="userForm.address.$error.required" class="msg-val">Address is required.</span> 
	              </div>
         	      
		
		
				<div class="form-group">
				<div class="col-xs-6 col-sm-6 col-md-6">
				<label class="control-label" for="">Mobile</label>
		      <input type="text" class="form-control" name="mobile" ng-model="userCtrl.user.mobile" required/> 
	          <span ng-show="userForm.mobile.$error.required" class="msg-val">Mobile is required.</span> 
		      </div>
			</div>
				
				<div class="form-group">
				<div class="col-xs-6 col-sm-6 col-md-6">
				<label class="control-label" for="">Email</label>
		      <input type="text" class="form-control" name="email" ng-model="userCtrl.user.email" required/> 
	         <span ng-show="userForm.email.$error.required" class="msg-val">Email is required.</span> 
			</div>
		</div>
		     <div class="form-group">
		     <div class="col-xs-6 col-sm-6 col-md-6">
				<label class="control-label" for="">Username</label>
		       <input type="text" class="form-control" name="username" ng-model="userCtrl.user.username" required/> 
	              <span ng-show="userForm.username.$error.required" class="msg-val">Username is required.</span> 
	               </div>
         	     </div>
		
		
			<div class="form-group">
			<div class="col-xs-6 col-sm-6 col-md-6">
				<label class="control-label" for="">Password</label>
		      <input type="password" class="form-control" name="password" ng-model="userCtrl.user.password" required/> 
	              <span ng-show="userForm.password.$error.required" class="msg-val">Password is required.</span> 
	               </div>
         	      </div>
		
		
		<!-- <tr>
		     <td colspan="2"> <span ng-if="userCtrl.flag=='created'" class="msg-success">User successfully added.</span>
		     <span ng-if="userCtrl.flag=='failed'" class="msg-val">User already exists.</span> </td>
		</tr> -->
	        <div style="height:10px;"></div>
				<div class="form-group">
				  <label class="control-label" for=""></label>
	            <div ng-if="userCtrl.flag != 'edit'">
		       <input  type="submit" class="btn btn-primary"  ng-click="userCtrl.createUser()" value="Add User"/> 
		       <input type="button" ng-click="userCtrl.reset()" value="Reset"/>
		    </div>
		    <div ng-if="userCtrl.flag == 'edit'">
		       <input  type="submit" class="btn btn-primary" ng-click="userCtrl.updateUserDetail()" value="Update User"/> 	
			   <input type="button" ng-click="userCtrl.cancelUpdate()" value="Cancel"/>				   
		    </div> 
		
		<tr>
		     <td colspan="2"> <span ng-if="userCtrl.flag=='deleted'" class="msg-success">User successfully deleted.</span>
		</tr>
 </table>      
</form>
	
	 <div class="container">
    <div class="row col-md-6 col-md-offset-2 custyle">
        <table class="table table-striped custab">
	      <tr><th>Id</th><th>Name</th> <th>Address</th><th>Mobile </th> <th>Email </th><th>Role </th><th>Username</th><th>Password </th><th>Action </th> </tr>
	      <tr ng-repeat="row in userCtrl.users">
	          <td><span ng-bind="row.id"></span></td>
	         <td><span ng-bind="row.name"></span></td>
	         <td><span ng-bind="row.address"></span></td>
	          <td><span ng-bind="row.mobile"></span></td>
	          <td><span ng-bind="row.email"></span></td>
	          <td><span ng-bind="row.role"></span></td>
	          <td><span ng-bind="row.username"></span></td>
	          <td><span ng-bind="row.password"></span></td>
	         <td>
		    <input type="button"  class="btn btn-danger btn-xs" ng-click="userCtrl.deleteUser(row.id)" value="Delete"/>
		    <input type="button" class="glyphicon glyphicon-edit" ng-click="userCtrl.edit(row.id)" value="Edit"/>
		    <span ng-if="userCtrl.flag=='updated' && row.id==userCtrl.updatedId" class="msg-success">User successfully updated.</span> </td> 
	      </tr>	
	</table>
	</div>
	</div>
	</div>
  </body>
</html> 