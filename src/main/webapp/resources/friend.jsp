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
</head>
<body>
	<div class="container" ng-controller="FriendController as ctrl">
<div class="form-group has-feedback"></div>
 Search for friend
<p><input type="text" ng-model="sear_text"></p> 
<input type="submit" ng-click="ctrl.getMyFriendRequests()" class="btn btn-success" value="Friend request"/>
<div ng-repeat="friend in ctrl.friend | filter: sear_text">
<div ng-hide="currentUser.id !== friend.friendId">
<p>UserId: {{friend.id}}&nbsp;&nbsp;&nbsp;Status: {{friend.status}}
<input type="submit" ng-click="ctrl.acceptFriendRequest(friend.id)" class="btn btn-warning" value="Accept Friend request"/>
<input type="submit" ng-click="ctrl.rejectFriendRequest(friend.id)" class="btn btn-danger" value="Reject Friend request"/>
</fieldset>
</div>
</div> 
</body>
</html>