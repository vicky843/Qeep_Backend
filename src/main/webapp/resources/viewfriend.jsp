<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container" ng-controller="FriendController as ctrl">
<div class="form-group has-feedback"></div>
<div ng-hide="currentUser.id !== friend.id"> 
<input type="submit" ng-click="ctrl.getMyFriends()" class="btn btn-danger" value="Get My Friends"/>
</div>
<div ng-repeat="friend in ctrl.friend | filter: sear_text">
<div ng-hide="currentUser.id !== friend.id"> 
<p>friend Id: {{friend.friendId}} &nbsp;&nbsp;&nbsp;Status: {{friend.status}}
<!-- <input type="submit" ng-click="ctrl.unFriend(friend.userId)" class="btn btn-warning" value="unfriend"/> -->
<a href="#/chat"><input type="submit" class="btn btn-warning" value="Send Message"/></a>
</p>
</div>
</div>  
</div>
<%@ include file="/resources/friend1.jsp"%> 

</body>
</html>