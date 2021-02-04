<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page isELIgnored="false"%>

<c:url var="addUrl" value="/ctl/User/changepassword"></c:url>
<div style="width: 100%;background-color: #04091e;height: 69px; padding: 25px ;margin-top: 68px" >
<h4 style="color: white; font-family: inherit;">CHANGE PASSWORD</h4></div>
<br>
<div class="container">
    <h1 class="well">Change Password</h1>
     <b><%@include file="BusinessMessage.jsp"%></b>
    <hr>
    <br>
	<div class="col-lg-12 well">
	<div class="row">
				<sf:form action="${addUrl }" method="post" commandName="form">
            
        
           
              
            
					<div class="col-lg-12">
							<s:bind path="oldPassword">		
						<div class="form-group">
							<label>Old Password</label>
							 <sf:input type="password" path="${status.expression}" placeholder="Enter Old Password"
									class="form-control" />
								&nbsp;<font color="red"> <sf:errors path="${status.expression}" cssClass="help-block" /></font>
						</div>
						</s:bind>
						<s:bind path="newPassword">
						<div class="form-group">
							<label>New Password</label> <sf:input type="password" path="${status.expression}" placeholder="Enter New Password"
														class="form-control" />
								&nbsp;<font color="red"><sf:errors path="${status.expression}" cssClass="help-block" /></font>
						</div>
						</s:bind>
						<s:bind path="confirmPassword">
						<div class="form-group">
							<label>Confirm Password</label> <sf:input type="password" path="${status.expression}" placeholder="Enter Confirm Password"
									class="form-control" />
								&nbsp;<font color="red"> <sf:errors path="${status.expression}" cssClass="help-block" /></font>
						</div>
						</s:bind>
					<input type="submit"
                        name="operation" class="btn btn-lg btn-info" value="ChangePassword" >					
					</div>
					
				</sf:form> 
				</div>
	</div>
	</div>
	<br><br>
	<hr>
