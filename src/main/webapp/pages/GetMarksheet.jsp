<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fm"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page isELIgnored="false"%>

<c:url var="addSearch" value="/ctl/Marksheet/getMarksheet" />

<div style="width: 100%;background-color: #04091e;height: 69px; padding: 25px ;margin-top: 68px" >
<h4 style="color: white; font-family: inherit;">Get Marksheet</h4></div>

<br>
<div class="container">
    <h1 class="well">Get Marksheet</h1>
     <b><%@include file="BusinessMessage.jsp"%></b>
    <hr>
    <br>
	<div class="col-lg-12 well">
	<div class="row">
				<sf:form action="${addSearch }" method="post" commandName="form">
            
           
            
					<div class="col-sm-12">
					<s:bind path="rollNo">
						<div class="form-group">
							<label>Roll No.</label>
							<sf:input path="rollNo" class="form-control"  placeholder="Search By Roll No" />
								
								
								<font  color="red"> <sf:errors path="rollNo" cssClass="help-block" /></font>
						</div>				
						</s:bind>
						
					<input type="submit"
                        name="operation" class="btn btn-lg btn-info" value="Go" >					
					</div>
					
				</sf:form>
				</div>
	</div>
	</div>
	<br>
	<hr>
	
			<c:if test="${marksheet!=null }">
			<center>
			<table border="1" style="width: 70%; border-style: none;">

				<tr>
					<td width="50%" align="center"><label><b>Name:</b></label>&emsp;&emsp;&emsp;${marksheet.name}</td>
					<td align="center" width="50%"><label><b>Roll No:</b></label>&emsp;&emsp;&emsp;${marksheet.rollNo}</td>
				</tr>

			</table>
			<br>
			<table style="width: 70%;" border-collapse=collapse;
				border="1px solid black">
				<tr>
					<th>Subject</th>
					<th>Maximum Mark</th>
					<th>Minimum Mark</th>
					<th>Obtained Mark</th>
				</tr>
				<tr>
					<td align="center">Physics</td>
					<td align="center">100</td>
					<td align="center">35</td>
					<td align="center">${marksheet.physics}</td>
				</tr>
				<tr>
					<td align="center">Chemistry</td>
					<td align="center">100</td>
					<td align="center">35</td>
					<td align="center">${marksheet.chemistry}</td>
				</tr>
				<tr>
					<td align="center">Maths</td>
					<td align="center">100</td>
					<td align="center">35</td>
					<td align="center">${marksheet.maths}</td>
				</tr>
				<tr>
					<td align="center"><b>Total</b></td>
					<td align="center"><b>300</b></td>
					<td></td>
					<td align="center"><b>${marksheet.chemistry + marksheet.maths +marksheet.physics}</b></td>
				</tr>
			</table>
			<br>
			<table border="1" style="width: 70%; border-style: none;">
				<tr>
					<th>Result:</th>
					<td align="center"><font
						color="green"><c:out
										value="${(marksheet.chemistry >35 && marksheet.maths>35 && marksheet.physics>35)?'Pass':'Fail'} ">
									</c:out></font></td>
					
					<th>Percentage:</th>
					<td align="center"><fm:formatNumber
										maxFractionDigits="2"
										value="${(marksheet.chemistry + marksheet.maths + marksheet.physics)/3}" /><span>%</span></td>
				</tr>
			</table>
			</center>
			<br>
			<hr>
			<br><br>
			
		
	</center>
	</c:if>
	