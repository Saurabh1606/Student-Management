<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page isELIgnored="false"%>
	<div
		style="width: 100%; background-color: #04091e; height: 62px; padding: 19px; margin-top: 68px">
		<h3 style="color: white; font-family: inherit;">Fee</h3>
	</div>
	<br>
	<div class="container">
		<h1 class="well">Add Fee</h1>
		<b><%@include file="BusinessMessage.jsp"%></b>
		<hr>

		<div class="col-lg-12 well">
			<div class="row">
				<sf:form action="Fee" method="post" commandName="form">


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
						<s:bind path="month">
							<div class="col-sm-6 form-group">
								<label>Month</label> 
							 <sf:select class="form-control" path="${status.expression}">
								<sf:option value="" label="Select" />
								<sf:options items="${monthMap}" />
							</sf:select>
							<font color="red"><sf:errors path="${status.expression}" /></font>
							</div>
							</s:bind>
						</div>
						<s:bind path="amount">
						<div class="form-group">
							<label>Amount</label>
							<sf:input path="${status.expression}" placeholder="Enter  Amount"
									class="form-control" />
							<font color="red"><sf:errors path="${status.expression}" /></font>
						</div>
						</s:bind>
					<s:bind path="date">
						<div class="form-group">
							<label>Date</label>
							<sf:input path="${status.expression}" placeholder="Enter Date"
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
	