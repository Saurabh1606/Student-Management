<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page isELIgnored="false"%>
	<div
		style="width: 100%; background-color: #04091e; height: 62px; padding: 19px; margin-top: 68px">
		<h3 style="color: white; font-family: inherit;">Marksheet</h3>
	</div>
	<br>
	<div class="container">
		<h1 class="well">Add Marksheet</h1>
		<b><%@include file="BusinessMessage.jsp"%></b>
		<hr>

		<div class="col-lg-12 well">
			<div class="row">
				<sf:form action="Marksheet" method="post" commandName="form">
             <sf:hidden path="id" />
					<div class="col-sm-12">
						<div class="row">
							<s:bind path="studentId">
							<div class="col-sm-6 form-group">
								<label>Select Student</label>
								<sf:select class="form-control" path="${status.expression}">
									<sf:option value="-1" label="Select" />
									<sf:options itemLabel="firstName" itemValue="id"
										items="${userList}" />
								</sf:select>
								<font color="red"><sf:errors path="${status.expression}" /></font>
							</div>
						</s:bind>
					<s:bind path="rollNo">
						<div class="col-sm-6 form-group">
							<label>Date</label> 
							<sf:input path="${status.expression}" placeholder="Enter Roll No"
									class="form-control" />
							<font color="red"><sf:errors path="${status.expression}" /></font>
						</div>
						</s:bind>
						</div>
						<s:bind path="physics">
						<div class="form-group">
							<label>Physics</label>
							<sf:input path="${status.expression}" placeholder="Enter Physics Marks"
									class="form-control" />
							<font color="red"><sf:errors path="${status.expression}" /></font>
						</div>
						</s:bind>
						<s:bind path="chemistry">
						<div class="form-group">
							<label>Chemistry</label>
								<sf:input path="${status.expression}" placeholder="Enter Chemisrty Marks"
									class="form-control" />
							<font color="red"><sf:errors path="${status.expression}" /></font>
						</div>
						</s:bind>
						<s:bind path="maths">
						<div class="form-group">
							<label>Maths</label>
							<sf:input path="${status.expression}" placeholder="Enter Maths Marks"
									class="form-control" />
							<font color="red"><sf:errors path="${status.expression}" /></font>
						</div>
						</s:bind>
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
