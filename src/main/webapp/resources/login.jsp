<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">  
<style>
body{
background-image:  url("resources/images/yellow.jpg");
}
.msg-val{
  color : red;
   };

</style>
</head>
<body>
 <div class="container">
   <div ng-controller="UserController as userCtrl">
             
		<form name="userForm"   ng-submit="userCtrl.login()" method="POST">	  	
		  <div ng-if="userCtrl.flag != 'edit'">
		     
		  </div>
		  <div ng-if="userCtrl.flag == 'edit'">
		     <h3> Update User for ID: {{ userCtrl.user.id }} </h3> 
		  </div>    
						
		<div class="form-group">
		 	<label class="col-md-1 control-label" for="name">Username:</label>  
  				 <div class="col-md-3"> 
		      <input type="text" class="form-control" name="username" ng-model="userCtrl.user.username" required/> 
         	      <span ng-show="userForm.username.$error.required" class="msg-val">Username is required.</span> 
		 	</div>
		
		
		 
		<label class="col-md-1 control-label" for="name">Password:</label>  
  				 <div class="col-md-3"> 
		        <input type="password" class="form-control" name="password" ng-model="userCtrl.user.password" required/> 
	              <span ng-show="userForm.password.$error.required" class="msg-val">Password is required.</span> 
			</div>
		
		
				
	        
  				<label class="col-md- control-label" for="button"></label>
  					<div class="col-md-2">
	            
		       <input  type="submit" class="w3-btn w3-pink w3-round-xlarge"  ng-click="userCtrl.user.login()" value="Login"/> 
		      </div>
		   </div>
		</div>
		
	
	</div>
</div>
</html>
<!-- <!-- Register -->
 <article class="container">
  <div ng-controller="UserController as userCtrl">
		<div class="row">
			<div class="col-sm-8">
				<div class="login-main">
				<img src="resources/images/social-economic-justice.png" alt="Flower">
					<!-- <h4><i class="fa fa-dashboard"></i> Gorgeous color and design</h4>
					<span>Some sample description text about the template goes here</span>

					<h4> <i class="fa fa-money"></i> 100%  fully responsive </h4>
					<span>Another description text about the template goes here</span>

					<h4><i class="fa fa-mobile-phone"></i> Competible with all browers and mobile devices</h4>
					<span>Yet another sample description text can be placed in one line</span>

					<h4> <i class="fa fa-trophy"></i> Easy to use and custmize with mobile friendly and responsive</h4>
					<span>Your last description text about your startup or business</span> -->
				</div>
			</div> 
			 <div class="col-sm-4">
				<div class="">
				
				<h3><i class="fa fa-shield"></i> Register now</h3>
			  	<hr>
				<div class="form-group">
				  <label class="control-label" for="">Name</label>
				  <input type="text" class="form-control" name="name" placeholder="Name" ng-model="userCtrl.user.name" required/>
					<span ng-show="userForm.name.$error.required" class="msg-val">Name is required.</span>
				</div>
				<div class="form-group">
				  <label class="control-label" for="">Address</label>
				  <input type="text" class="form-control" name="address" ng-model="userCtrl.user.address" required/> 
				  <span ng-show="userForm.address.$error.required" class="msg-val">Address is required.</span>
				</div>
				<div class="form-group">
				<div class="col-sm-6 multibox">
				  <label class="control-label" for="">Mobile no.</label>
				  <input type="text" class="form-control" name="mobile" ng-model="userCtrl.user.mobile" required/> 
				  <span ng-show="userForm.mobile.$error.required" class="msg-val">Mobile no. is required.</span>
				</div>
			
				<div class="form-group">
				<div class="col-sm-6 multibox">
				  <label class="control-label" for="">Email</label>
				   <input type="text" class="form-control" name="email" ng-model="userCtrl.user.email" required/> 
				</div>
			  </div>
			  
				<div class="form-group">
				 <label class="control-label" for="">Username</label>
				  <input type="text" class="form-control" name="username" ng-model="userCtrl.user.username" required/> 
				   <span ng-show="userForm.username.$error.required" class="msg-val">Username is required.</span>
				</div>
			  
				<div class="form-group">
				 <label class="control-label" for="">Password</label>
				  <input type="password" class="form-control" name="password" ng-model="userCtrl.user.password" required/> 
				  <span ng-show="userForm.password.$error.required" class="msg-val">Password is required.</span>
				</div>

				
		      				 
				<div style="height:10px;"></div>
				<div class="form-group">
				  <label class="control-label" for=""></label>
				  <input  type="submit" class="btn btn-primary" ng-click="userCtrl.createUser()" value="Submit"/>
				  
				</div>	 

				  </div>
			</div>
			</div>
			</div>
		</div>
</article> 
 </form>        
	
</html>