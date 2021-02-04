<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<%@page isELIgnored="false"%>
       <header class="header_area">
          	
            <div class="main_menu">
            	<nav class="navbar navbar-expand-lg navbar-light">
					<div class="container">
						<!-- Brand and toggle get grouped for better mobile display -->
						<a class="navbar-brand logo_h" href="">Student information System</a>
						
						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse offset" id="navbarSupportedContent">
							<ul class="nav navbar-nav menu_nav ml-auto">
								<li class="nav-item active"><a class="nav-link" href="<c:url value="/Welcome"/>">Home</a></li> 
								
						
				
								 <c:choose>
            
           						 <c:when test="${sessionScope.roleLogin.id == 1}">
								<li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Administration</a>
									<ul class="dropdown-menu">
										<li class="nav-item"><a class="nav-link" href="<c:url value="/ctl/Assignment"/>">Add Assignment</a></li>
										<li class="nav-item"><a class="nav-link" href="<c:url value="/ctl/Subject"/>">Add Subject</a></li>
										<li class="nav-item"><a class="nav-link" href="<c:url value="/ctl/Attendance"/>">Add Attendance</a></li>
										<li class="nav-item"><a class="nav-link" href="<c:url value="/ctl/User"/>">Add User</a></li>
										<li class="nav-item"><a class="nav-link" href="<c:url value="/ctl/Fee"/>">Add Fee</a></li>
									</ul>
								</li> 
								
								<li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Report</a>
									<ul class="dropdown-menu">
										<li class="nav-item"><a class="nav-link" href="<c:url value="/ctl/User/Search/Admin"/>">Admin Report</a></li>
										<li class="nav-item"><a class="nav-link" href="<c:url value="/ctl/User/Search/Student"/>">Student Report</a></li>
										<li class="nav-item"><a class="nav-link" href="<c:url value="/ctl/User/Search/Faculty"/>">Teacher Report</a></li>
										<li class="nav-item"><a class="nav-link" href="<c:url value="/ctl/Assignment/Search"/>">Assignment Report</a></li>
										<li class="nav-item"><a class="nav-link" href="<c:url value="/ctl/Attendance/Search"/>">Attendance Report</a></li>
										<li class="nav-item"><a class="nav-link" href="<c:url value="/ctl/Subject/Search"/>">Subject Report</a></li>
										<li class="nav-item"><a class="nav-link" href="<c:url value="/ctl/Marksheet/Search"/>">Marksheet Report</a></li>
										<li class="nav-item"><a class="nav-link" href="<c:url value="/ctl/Marksheet/MeritList"/>">Marksheet Marit List</a></li>
										<li class="nav-item"><a class="nav-link" href="<c:url value="/ctl/Fee/Search"/>">Fee Report</a></li>
										
									</ul>
								</li> 
								
								<li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">My Account</a>
									<ul class="dropdown-menu">
										<li class="nav-item"><a class="nav-link" href="<c:url value="/ctl/User/profile"/>">My Profile</a></li>
										<li class="nav-item"><a class="nav-link" href="<c:url value="/ctl/User/changepassword"/>">Change Password</a></li>
										
										
									</ul>
								</li> 
							</c:when></c:choose>					
				
								<c:choose>
            
           						 <c:when test="${sessionScope.roleLogin.id == 2}">
					        <li class="nav-item"><a class="nav-link" href="<c:url value="/ctl/Marksheet/getMarksheet"/>">Get Marksheet</a></li>
								<li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Administration</a>
									<ul class="dropdown-menu">
										<li class="nav-item"><a class="nav-link" href="<c:url value="/ctl/Subject/Search"/>">Subject List</a></li>
										
										<li class="nav-item"><a class="nav-link" href="<c:url value="/ctl/Attendance/Search"/>">My Attendance</a></li>
										<li class="nav-item"><a class="nav-link" href="<c:url value="/ctl/Assignment/Search"/>">Assignment</a></li>
									
									</ul>
								</li>
								
								<li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">My Account</a>
									<ul class="dropdown-menu">
										<li class="nav-item"><a class="nav-link" href="<c:url value="/ctl/User/profile"/>">My Profile</a></li>
										<li class="nav-item"><a class="nav-link" href="<c:url value="/ctl/User/changepassword"/>">Change Password</a></li>
										
										
									</ul>
								</li> 
						
					</c:when>
					</c:choose>
							
								<c:choose>
            
           						 <c:when test="${sessionScope.roleLogin.id == 3}">	
								<li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Administration</a>
									<ul class="dropdown-menu">
										<li class="nav-item"><a class="nav-link" href="<c:url value="/ctl/Assignment"/>">Add Assignment</a></li>
										<li class="nav-item"><a class="nav-link" href="<c:url value="/ctl/Subject"/>">Add Subject</a></li>
										<li class="nav-item"><a class="nav-link" href="<c:url value="/ctl/Attendance"/>">Add Attendance</a></li>
										<li class="nav-item"><a class="nav-link" href="<c:url value="/ctl/Marksheet"/>">Add MarkSheet</a></li>
									
									</ul>
								</li> 
								
								<li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Report</a>
									<ul class="dropdown-menu">
										<li class="nav-item"><a class="nav-link" href="<c:url value="/ctl/Assignment/Search"/>">Assignment Report</a></li>
										<li class="nav-item"><a class="nav-link" href="<c:url value="/ctl/Attendance/Search"/>">Attendance Report</a></li>
										<li class="nav-item"><a class="nav-link" href="<c:url value="/ctl/Subject/Search"/>">Subject Report</a></li>
										<li class="nav-item"><a class="nav-link" href="<c:url value="/ctl/Marksheet/Search"/>">Marksheet Report</a></li>
										<li class="nav-item"><a class="nav-link" href="<c:url value="/ctl/Marksheet/MeritList"/>">Marksheet Marit List</a></li>
									</ul>
								</li> 
								
								<li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">My Account</a>
									<ul class="dropdown-menu">
										<li class="nav-item"><a class="nav-link" href="<c:url value="/ctl/User/profile"/>">My Profile</a></li>
										<li class="nav-item"><a class="nav-link" href="<c:url value="/ctl/User/changepassword"/>">Change Password</a></li>
										
										
									</ul>
								</li> 
												
				</c:when>
				</c:choose>
				 
								<c:choose>
           						 <c:when test="${sessionScope.roleLogin.id > 0}">
           						 <c:url var="log" value="/Login" />
								<li class="nav-item"><a class="nav-link" href="${log}">Logout</a></li>
								</c:when>
								<c:otherwise>
								<c:url var="log" value="/Login" />
								<li class="nav-item"><a class="nav-link" href="${log}">Login</a></li> 
								</c:otherwise>
								</c:choose>			
					
							</ul>
						</div> 
					</div>
            	</nav>
            </div>
        </header>
