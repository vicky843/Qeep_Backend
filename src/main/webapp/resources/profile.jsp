<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container panel">
<div ng-controller="UserController as ctrl">
<!-- <h1 style="color:#22d686;">Profile</h1> -->
<h1>Profile</h1>
<h3>
Name: {{selectedUser.name}}</br></br>
Email: {{selectedUser.email}}</br></br>
Mobile Number: {{selectedUser.mobile}}</br></br>
Address: {{selectedUser.address}}</br></br>
Username: {{selectedUser.username}}</br></br>
</h3>
</div>
</div>
</body>
</html>