<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

 <link rel="stylesheet" href="/Student-Information-System/resources/css/bootstrap.css">
        <link rel="stylesheet" href="/Student-Information-System/resources/vendors/linericon/style.css">
        <link rel="stylesheet" href="/Student-Information-System/resources/css/font-awesome.min.css">
        <link rel="stylesheet" href="/Student-Information-System/resources/vendors/owl-carousel/owl.carousel.min.css">
        <link rel="stylesheet" href="/Student-Information-System/resources/lightbox/simpleLightbox.css">
        <link rel="stylesheet" href="/Student-Information-System/resources/vendors/nice-select/css/nice-select.css">
        <link rel="stylesheet" href="/Student-Information-System/resources/vendors/animate-css/animate.css">
        <link rel="stylesheet" href="/Student-Information-System/resources/vendors/popup/magnific-popup.css">
        <!-- main css -->
        <link rel="stylesheet" href="/Student-Information-System/resources/css/style.css">
        <link rel="stylesheet" href="/Student-Information-System/resources/css/responsive.css">
        <link rel="stylesheet" href="/Student-Information-System/resources/css/login.css">
        <script src="/Student-Information-System/resources/js/jquery-3.3.1.min.js"></script>
        <script src="/Student-Information-System/resources/js/jquery.min.js"></script>
         <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/Student-Information-System/resources/css/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  
  <script src="/Student-Information-System/resources/js/jquery.min.js"></script>
<script language="javascript">
	$(function() {
		$("#selectall").click(function() {
			$('.case').attr('checked', this.checked);
		});
		$(".case").click(function() {

			if ($(".case").length == $(".case:checked").length) {
				$("#selectall").attr("checked", "checked");
			} else {
				$("#selectall").removeAttr("checked");
			}

		});
	});
</script>
</head>


<body>


	<tiles:insertAttribute name="header"></tiles:insertAttribute>

	<div id="page">

		<div id="body" style="margin-left: 0">


			<tiles:insertAttribute name="body"></tiles:insertAttribute>

		</div>

	</div>
	
<tiles:insertAttribute name="footer"></tiles:insertAttribute>

</body>
</html>