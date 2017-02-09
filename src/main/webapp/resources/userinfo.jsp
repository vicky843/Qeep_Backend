
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<title>Insert title here</title>
<!-- <style>
body {
	background-color: #5DADEC;
	color: #0000;
}
</style>
 -->
</head>
<body>
<div ng-controller="HomeController as ctrl">
<div ng-hide="currentUser==''">
<div class="container">
<div class="row">
<h3>
<div class="col-sm-6" style="color:brown;">
Welcome: {{currentUser.username}}
</div><br>
<div class="col-sm-6" style="text-align: right;">

</div>
</h3>
</div>
</div>
</div>
</div>
<div class="container">
<div class="row">
<div class="col-sm-12" style="text-align: left;">
<div ng-controller="UserController as ctr">

<button type="submit" ng-click="ctr.getSelectedUser()" class="w3-btn w3-blue w3-border w3-border-red w3-round-xlarge">My Profile</button>
</div>
</div>
</div>
</div>
<div ng-controller="FriendController as ctrl" class="container">
<div class="form-group has-feedback"></div>
<div class="row">
<div class="col-sm-3">
<p><input type="text" ng-model="sear_text" placeholder="Search the User" class="form-control cols-sm-5"></p>
</div>
</div>
    <table  class="w3-table-all">
        <thead>
            <tr>
            	<th>Id</th>
                <th>Name</th>
                <th>Email</th>
                <th>Mobile Number</th>
                <th>Address</th>
                <!-- <th>Role</th> -->
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <tr ng-repeat="user in ctrl.users | filter: sear_text">
            	<td><span ng-bind="user.id"></span></td>
	        	<td><span ng-bind="user.name"></span></td>
	        	<td><span ng-bind="user.email"></span></td>
	        	<td><span ng-bind="user.mobile"></span></td>
	        	<td><span ng-bind="user.address"></span></td>
	         	<!-- <td><span ng-bind="user.role"></span></td> -->
                <td><button type="button" ng-click="ctrl.sendFriendRequest(user.id)" class="w3-btn w3-khaki w3-border w3-border-red w3-round-xlarge">Send Friend Request</button></td>
            </tr>
        </tbody>
    </table>
</div>
</body>
</html>