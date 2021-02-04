<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page isELIgnored="false"%>
<div style="width: 100%;background-color: #04091e;height: 69px; padding: 19px ;margin-top: 68px" >
<h2 style="color: white; font-family:inherit;">Marksheet Marit List</h2></div>
<br><br>



<table class="table">
			<thead class="thead-dark">
				<tr>
					
					<th scope="col">S.No.</th>
					<th scope="col">Roll No.</th>
					<th scope="col">Student Name</th>
					<th scope="col">Physics</th>
					<th scope="col">Chemistry</th>
					<th scope="col">Maths</th>
					<th scope="col">Total</th>
				
				
				</tr>
			</thead>
			 <c:forEach items="${meritList}" var="marksheet" varStatus="ct">
			<tbody>
				<tr>
					
					 <td>${ct.index+1}</td>
								<td>${marksheet.rollNo }</td>
								<td>${marksheet.name }</td>
								<td>${marksheet.physics }</td>
								<td>${marksheet.maths }</td>
								<td>${marksheet.chemistry }</td>
								<td>${marksheet.physics + marksheet.maths + marksheet.chemistry}</td>
					</tr>
					
			</tbody>
			</c:forEach>
		</table>
		
		
		
		
<br><br>
	