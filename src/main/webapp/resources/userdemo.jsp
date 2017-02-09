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
<!-- <script src="resources/js/angular.min.js"></script>
<script src="resources/js/angular-resource.min.js"></script> -->
<!-- <script src="resources/js/app.js"></script>  --> 
<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css"/>
</head>
<body ng-app="myApp">
  <body ng-app="myApp">
   <div ng-controller="UserController as userCtrl">
    
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
		<tr>
		       <td>Name: </td>
		       <td> <input type="text" class="form-control" name="name" ng-model="userCtrl.user.name" required/> 
         	      <!-- <span ng-show="userForm.name.$error.required" class="msg-val">Name is required.</span> --> </td>
		</tr><br>
				
		<tr>
		      <td>Address: </td> <td> <input type="text" class="form-control" name="address" ng-model="userCtrl.user.address" required/> 
	              <!-- <span ng-show="userForm.address.$error.required" class="msg-val">Address is required.</span> --> </td>
		</tr>
		
		<tr>
		      <td>Mobile: </td> <td> <input type="text" class="form-control" name="mobile" ng-model="userCtrl.user.mobile" required/> 
	              <span ng-show="userForm.mobile.$error.required" class="msg-val">Mobile is required.</span> </td>
		</tr>
		
		<tr>
		      <td>Email: </td> <td> <input type="text" class="form-control" name="email" ng-model="userCtrl.user.email" required/> 
	              <span ng-show="userForm.email.$error.required" class="msg-val">Email is required.</span> </td>
		</tr><br>
		
		<tr>
		      <td>Role: </td> <td> <input type="text" class="form-control" name="role" ng-model="userCtrl.user.role" required/> 
	              <span ng-show="userForm.role.$error.required" class="msg-val">Role is required.</span> </td>
		</tr><br>
		
		<tr>
		     <td colspan="2"> <span ng-if="userCtrl.flag=='created'" class="msg-success">User successfully added.</span>
		     <span ng-if="userCtrl.flag=='failed'" class="msg-val">User already exists.</span> </td>
		</tr>
	        <tr><td colspan="2">
	            <div ng-if="userCtrl.flag != 'edit'">
		       <input  type="submit" ng-click="userCtrl.createUser()" value="Add User"/> 
		       <input type="button" ng-click="userCtrl.reset()" value="Reset"/>
		    </div>
		    <div ng-if="userCtrl.flag == 'edit'">
		       <input  type="submit" ng-click="userCtrl.updateUser()" value="Update User"/> 	
			   <input type="button" ng-click="userCtrl.cancelUpdate()" value="Cancel"/>				   
		    </div> </td>
		</tr>
		<tr>
		     <td colspan="2"> <span ng-if="userCtrl.flag=='deleted'" class="msg-success">User successfully deleted.</span>
		</tr>
	    </table>     
	</form>
        <table>
	      <tr><th>Name</th> <th>Address</th><th>Mobile </th> <th>Email </th><th>Role </th><th>Action </th> </tr>
	      <tr ng-repeat="row in userCtrl.users">
	        
	         <td><span ng-bind="row.name"></span></td>
	         <td><span ng-bind="row.address"></span></td>
	          <td><span ng-bind="row.mobile"></span></td>
	          <td><span ng-bind="row.email"></span></td>
	          <td><span ng-bind="row.role"></span></td>
	         <td>
		    <input type="button" ng-click="userCtrl.deleteUser(row.id)" value="Delete"/>
		    <input type="button" ng-click="userCtrl.edit(row.id)" value="Edit"/>
		    <span ng-if="userCtrl.flag=='updated' && row.id==userCtrl.updatedId" class="msg-success">User successfully updated.</span> </td> 
	      </tr>	
	</table>
	</div>
  </body>
</html>