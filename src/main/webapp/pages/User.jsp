<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page isELIgnored="false"%>

<div
	style="width: 100%; background-color: #04091e; height: 62px; padding: 19px; margin-top: 68px">
	<h3 style="color: white; font-family: inherit;">User</h3>
</div>
<br>
<div class="container">
	<h1 class="well">Add User</h1>
	<b><%@include file="BusinessMessage.jsp"%></b>
	<hr>

	<div class="col-lg-12 well">
		<div class="row">
			<sf:form action="User" method="post" commandName="form">
			<sf:hidden path="id" />

				<div class="col-sm-12">


					<div class="row">
						<s:bind path="roleId">
							<div class="col-sm-6 form-group">
								<label>Select User Role</label>
								<sf:select class="form-control" path="${status.expression}">
									<sf:option value="-1" label="Select" />
									<sf:options itemLabel="name" itemValue="id" items="${roleList}" />
								</sf:select>
								<font color="red"><sf:errors path="${status.expression}" /></font>
							</div>
						</s:bind>
					</div>



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
					<div class="row">
						<s:bind path="password">
							<div class="col-sm-6 form-group">
								<label>Password</label>
								<sf:input type="password" path="${status.expression}"
									placeholder="Enter Password" class="form-control" />
								<font color="red"><sf:errors path="${status.expression}" /></font>
							</div>
						</s:bind>
						<s:bind path="confirmPassword">
							<div class="col-sm-6 form-group">
								<label>Confirm Password</label>
								<sf:input type="password" path="${status.expression}"
									placeholder="Enter Confirm Password" class="form-control" />
								<font color="red"><sf:errors path="${status.expression}" /></font>
							</div>
						</s:bind>
					</div>
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
					<s:bind path="emailId">
					<div class="form-group">
						<label>Email Address</label> 
						<sf:input path="${status.expression}" placeholder="Enter emailId"
								class="form-control" />
							<font color="red"><sf:errors path="${status.expression}" /></font>
					</div>
					</s:bind>
					
					<div class="row">
					<s:bind path="country">
						<div class="col-sm-4 form-group">
							<label>Country</label>
							<sf:input path="${status.expression}" placeholder="Enter Country"
								class="form-control" />
							<font color="red"><sf:errors path="${status.expression}" /></font>
						</div>
						</s:bind>
						<s:bind path="state">
						<div class="col-sm-4 form-group">
							<label>State</label>
							<sf:input path="${status.expression}" placeholder="Enter State"
								class="form-control" />
							<font color="red"><sf:errors path="${status.expression}" /></font>
						</div>
						</s:bind>
						<s:bind path="city">
						<div class="col-sm-4 form-group">
							<label>City</label> 
							<sf:input path="${status.expression}" placeholder="Enter City"
								class="form-control" />
							<font color="red"><sf:errors path="${status.expression}" /></font>
						</div>
						</s:bind>
					</div>
					<s:bind path="address1">
					<div class="form-group">
						<label>Address Line 1</label>
						<sf:textarea rows="3" placeholder="Enter Address1" path="${status.expression}"
														class="form-control" />
							<font  color="red"><sf:errors path="${status.expression}"/></font>
					</div>
					</s:bind>
					<s:bind path="address2">
					<div class="form-group">
						<label>Address Line 2</label>
						<sf:textarea rows="3" placeholder="Enter Address2" path="${status.expression}"
														class="form-control" />
							<font  color="red"><sf:errors path="${status.expression}"/></font>
					</div>
					</s:bind>
					<input type="submit" name="operation" value="Save"
						class="btn btn-lg btn-info">
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
