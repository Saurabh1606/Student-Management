<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>



<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page isELIgnored="false"%>

<c:url var="addUrl" value="/ctl/User/profile"></c:url>
	<div
		style="width: 100%; background-color: #04091e; height: 62px; padding: 19px; margin-top: 68px">
		<h3 style="color: white; font-family: inherit;">MY PROFILE</h3>
	</div>
	<br>
	<div class="container">
		<h1 class="well">My Profile</h1>
		<b><%@include file="BusinessMessage.jsp"%></b>
		<hr>

		<div class="col-lg-12 well">
			<div class="row">
				<sf:form action="${addUrl }" method="post" commandName="form">

                    <sf:hidden path="id" />
					
					

					<div class="col-sm-12">

						

						<div class="row">
						<s:bind path="firstName">
							<div class="col-sm-6 form-group">
								<label>First Name</label>
								<sf:input path="${status.expression}"
									placeholder="Enter First Name" class="form-control" />
								<font color="red"><sf:errors path="${status.expression}" /></font>
							</div>
						</s:bind>
						<s:bind path="lastName">
							<div class="col-sm-6 form-group">
								<label>Last Name</label>
								<sf:input path="${status.expression}"
									placeholder="Enter Last Name" class="form-control" />
								<font color="red"><sf:errors path="${status.expression}" /></font>
							</div>
						</s:bind>
					</div>
						
						<s:bind path="login">
						<div class="form-group">
							<label>Login Id</label>
							<sf:input path="${status.expression}" placeholder="Enter Login"
								class="form-control" />
							<font color="red"><sf:errors path="${status.expression}" /></font>
						</div>
					</s:bind>
						
						<s:bind path="mobileNo">
						<div class="form-group">
							<label>Phone Number</label>
							<sf:input  path="${status.expression}"
								placeholder="Enter Phone No" class="form-control" />
							<font color="red"><sf:errors path="${status.expression}" /></font>
						</div>
					</s:bind>

						<div class="row">
						<s:bind path="gender">
							<div class="col-sm-6 form-group">
								<label>Gender</label>
								<sf:select class="form-control" path="${status.expression}">
									<sf:option value="" label="Select" />
									<sf:options items="${genderMap}" />
								</sf:select>
								<font color="red"><sf:errors path="${status.expression}" /></font>
							</div>
						</s:bind>
						<s:bind path="dob">
						<div class="col-sm-6 form-group">
							<label>Date Of Birth</label> 
							<sf:input path="${status.expression}" placeholder="Enter Date of Birth"
								class="form-control" />
							<font color="red"><sf:errors path="${status.expression}" /></font>
						</div>
						</s:bind>
					</div>
						

						<input type="submit" name="operation" value="Save"
							class="btn btn-lg btn-info" >
					</div>
				</sf:form>
			</div>
		</div>
	</div>
	<br>
	<br>
	<hr>
	<br>
	<br>
	<%@include file="Footer.jsp"%>
</body>
</html>