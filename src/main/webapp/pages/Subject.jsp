<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page isELIgnored="false"%>
<div style="width: 100%;background-color: #04091e;height: 69px; padding: 25px ;margin-top: 40px" >
<h4 style="color: white; font-family: inherit;">SUBJECT</h4></div>
<br>
<div class="container">
    <h1 class="well">Add Subject</h1>
    <b><%@include file="BusinessMessage.jsp"%></b> 
    <hr>
    <br>
	<div class="col-lg-12 well">
	<div class="row">
				<sf:form action="Subject" method="post" commandName="form" >
				<sf:hidden path="id" />

            
					<div class="col-lg-12">
						<s:bind path="name">			
						<div class="form-group">
							<label>Subject Name</label> 	
							<sf:input path="${status.expression}" placeholder="Enter Name" class="form-control" />
							&nbsp;<font  color="red"><sf:errors path="${status.expression}"/></font>
						</div>
						</s:bind>
						<s:bind path="description">	
						<div class="form-group">
							<label>Description</label>
							<sf:textarea rows="3" placeholder="Enter Description" path="${status.expression}"
														class="form-control" />
							<font  color="red"><sf:errors path="${status.expression}"/></font>
						</div>
						</s:bind>
					<input type="submit" name="operation"
                        class="btn btn-lg btn-info" value="Save" >
                        <input type="submit" name="operation"
                        class="btn btn-lg btn-info" value="Reset" >						
					</div>
					
				</sf:form> 
				</div>
	</div>
	</div>
	<br><br>
	<hr>
	
