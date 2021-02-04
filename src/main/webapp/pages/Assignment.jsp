<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page isELIgnored="false"%>
<div
	style="width: 100%; background-color: #04091e; height: 62px; padding: 19px; margin-top: 68px">
	<h3 style="color: white; font-family: inherit;">Assignment</h3>
</div>
<br>
<div class="container">
	<h1 class="well">Add Assignment</h1>
	<b><%@include file="BusinessMessage.jsp"%></b>
	<hr>

	<div class="col-lg-12 well">
		<div class="row">
			<sf:form action="Assignment" method="post" commandName="form">


				<sf:hidden path="id" />

				<div class="col-sm-12">



					<div class="row">
						<s:bind path="subjectId">
							<div class="col-sm-6 form-group">
								<label>Select Subject</label>
								<sf:select class="form-control" path="${status.expression}">
									<sf:option value="-1" label="Select" />
									<sf:options itemLabel="name" itemValue="id"
										items="${subjectList}" />
								</sf:select>
								<font color="red"><sf:errors path="${status.expression}" /></font>
							</div>
						</s:bind>
						<s:bind path="assignmentTitle">
							<div class="col-sm-6 form-group">
								<label>Assignment Title</label>
								<sf:input path="${status.expression}" placeholder="Enter Assignment Title"
									class="form-control" />
								<font color="red"><sf:errors path="${status.expression}" /></font>
							</div>
						</s:bind>
					</div>
					<div class="row">
					<s:bind path="dueDate">
						<div class="col-sm-6 form-group">
							<label>Due Date</label> 
							<sf:input path="${status.expression}" placeholder="Enter DueDate"
									class="form-control" />
							<font color="red"><sf:errors path="${status.expression}" /></font>
						</div>
						</s:bind>
						<s:bind path="assignmentFile">
						<div class="col-sm-6 form-group">
							<label>Assignment File</label> 
							<sf:input path="${status.expression}" placeholder="Enter Assignment File"
									class="form-control" />
							<font color="red"><sf:errors path="${status.expression}" /></font>
						</div>
						</s:bind>
					</div>
					<s:bind path="description">	
						<div class="form-group">
							<label>Description</label>
							<sf:textarea rows="3" placeholder="Enter Description" path="${status.expression}"
														class="form-control" />
							<font  color="red"><sf:errors path="${status.expression}"/></font>
						</div>
						</s:bind>

					<input type="submit" name="operation"
						value="Save" class="btn btn-lg btn-info">
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
