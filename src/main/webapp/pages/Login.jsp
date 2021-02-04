<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>


<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page isELIgnored="false"%>


<div style="width: 100%;background-color: #04091e;height: 69px; padding: 25px ;margin-top: 68px" >
<h4 style="color: white; font-family: inherit;">USER LOGIN</h4></div>
<br>
<div class="container">
    <h1 class="well">Login</h1>
     <b><%@include file="BusinessMessage.jsp"%></b> 
    <hr>
    <br>
	<div class="col-lg-12 well">
	<div class="row">
				<sf:form action="Login" method="post" commandName="form" >
				
				
              
               
            
					<div class="col-sm-12">
						<div class="row">
						  <s:bind path="login">
							<div class="col-sm-6 form-group">
								<label>Login Id<font color="red">*</font></label>
								<sf:input path="${status.expression}" placeholder="Enter Login" class="form-control" />
								<font  color="red"><sf:errors path="${status.expression}"/></font>
							</div>
							</s:bind>
							<s:bind path="password">
							<div class="col-sm-6 form-group">
								<label>Password<font color="red">*</font></label>
								<sf:input type="password" path="${status.expression}" placeholder="Enter Password"
									class="form-control" />
								<font  color="red"><sf:errors path="${status.expression}"/></font>
							</div>
							</s:bind>
						</div>					
						
						
					 <input type="submit" value="SignIn" name="operation" class="btn btn-skin btn-block btn-lg">					
					</div>
					
				</sf:form>
				</div>
	</div>
	</div>
	<br><br>
	<hr>
