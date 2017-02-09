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
<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css"/>
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css"> 
<style>
body{

background-image:  url("images/background-stripe-cream-v2.jpg");
}.msg-val{
  color : red;
   };

</style>   
  </head>
  <body >
   <div ng-controller="BlogController as blogCtrl">
       <div class="container">
	<form name="blogForm" method="POST">
	    <table>
		<tr><td colspan="2">
		  <div ng-if="blogCtrl.flag != 'edit'">
		     
		  </div>
		  <div ng-if="blogCtrl.flag == 'edit'">
		     <h3> Update Blog for ID: {{ blogCtrl.blog.c_id }} </h3> 
		  </div> </td>
		</tr>
		
		<div class="form-group">
			<div class="col-xs-6 col-sm-6 col-md-6">
				<label class="control-label" for="name">Title:</label> 
		        <input type="text" class="form-control" name="c_title" placeholder="Title" ng-model="blogCtrl.blog.c_title" required/> 
         	      <span ng-show="blogForm.c_title.$error.required" class="msg-val">Blog is required.</span> 
			</div>
		</div>
		
		<div class="form-group">
		<div class="col-xs-6 col-sm-6 col-md-6">
				<label class=" control-label" for="comment">User Id:</label> 
		       <input type="text"  class="form-control" name="id" placeholder="User Id" ng-model="blogCtrl.blog.id" required/> 
	            <span ng-show="blogForm.id.$error.required" class="msg-val">Id is required.</span> 
		</div>
		</div>
		<div class="form-group">
			<label class="col-md-1 control-label" for="comment">Description:</label> 
		  	<textarea type="textarea" class="form-control" placeholder="Description" maxlength="140" rows="5" name="c_desc" ng-model="blogCtrl.blog.c_desc" required/> 
	        <span ng-show="blogForm.c_desc.$error.required" class="msg-val">Description is required.</span> 
		</div>
		
		
		
		<div class="form-group">
		<tr>
		     <td colspan="2"> <span ng-if="blogCtrl.flag=='created'" class="msg-success">Blog successfully added.</span>
		     <span ng-if="blogCtrl.flag=='failed'" class="msg-val">Blog already exists.</span> </td>
		</tr>
	        <tr><td colspan="2">
	            <div ng-if="blogCtrl.flag != 'edit'">
		       <input  type="submit" class="w3-btn w3-lime w3-round-xlarge" ng-click="blogCtrl.createBlog()" value="Add Blog"/> 
		        <input type="button" class="w3-btn w3-light-green w3-round-xlarge" ng-click="blogCtrl.reset()" value="Reset"/>
		    </div>
		    <div ng-if="blogCtrl.flag == 'edit'">
		       <input  type="submit" class="w3-btn w3-red w3-round-xlarge" ng-click="blogCtrl.updateBlogDetail()" value="Update Blog"/> 	
			   <input type="button" class="w3-btn w3-lime w3-round-xlarge" ng-click="blogCtrl.cancelUpdate()" value="Cancel"/>				   
		    </div> </td>
		</tr>
		<tr>
		     <td colspan="2"> <span ng-if="blogCtrl.flag=='deleted'" class="msg-success">Blog successfully deleted.</span>
		</tr>
	    </table>     
	</form>
	<br>
		<div class="panel panel-danger filterable">
            <div class="panel-heading">
                <h3 class="panel-title">Blog List</h3>
                <div class="pull-right">
                    
                </div>
            </div>
            
            <table class="table table-hover">
            <thead>
           <!--  <tr class="filters"> -->
	      <tr>
	      <th width="60">Blog ID </th>
                        <th width="120">Title</th>
                        <th width="120"> Description</th>
                        <th width="60">User Id</th>
                        <th width="60">View</th>
                        <th width="60">Delete</th>
                        <th width="60">Edit</th>
	            
	      </tr>
	      </thead>
	      <tr ng-repeat="row in blogCtrl.blogs">
	         <td><span ng-bind="row.c_id"></span></td>
	         <td><span ng-bind="row.c_title"></span></td>
	         <td><span ng-bind="row.c_desc"></span></td>
	         <td><span ng-bind="row.id"></span></td>
	         <td><a href="blogview{{row.c_id}}"><button type="submit" class="btn btn-primary">View</button></a></td> 
	         <td>
		    <input type="button" class="w3-btn w3-indigo  w3-small" ng-click="blogCtrl.deleteBlog(row.c_id)" value="Delete"/></td>
		    <td><input type="button" class="w3-btn w3-teal w3-round-small" ng-click="blogCtrl.edit(row.c_id)" value="Edit"/></td>
		   
		     
		    <span ng-if="blogCtrl.flag=='updated' && row.c_id==blogCtrl.updatedId" class="msg-success">Blog successfully updated.</span> </td> 
	      </tr>	
	</table>
	</div>     
 </body>
</html>  