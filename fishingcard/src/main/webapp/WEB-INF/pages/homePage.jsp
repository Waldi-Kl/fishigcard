<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${pageContext.request.contextPath}/css/w3.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/w3_theme.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<title>${title}</title>
<style>

</style>
</head>
<body>

<jsp:include page="_menu.jsp" />

	<div class="w3-cell-row">


		<!-- Część centralna -->
		<div class="w3-container w3-cell ">
			<div>
				<h1>Witaj w aplikacji Karta Wędkarska</h1>
				<h3>${message}</h3>

				<!--  Tu jakaś treść  -->
				<div class="w3-border">

					<!--  Tutaj jakaś tresć -->
					<div class="w3-container w3-cell"></div>

				</div>
			</div>
		</div>
	</div>



	<jsp:include page="_footer.jsp" />

	<!-- Script for Sidebar, Tabs, Accordions, Progress bars and slideshows -->

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/base.js">
		
	</script>

</body>
</html>