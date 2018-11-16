<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="d"%>
<%@ page isELIgnored="false"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${pageContext.request.contextPath}/css/w3.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/w3_theme.css"
	rel="stylesheet" type="text/css" />

<title>${title}</title>
</head>
<body>
	<jsp:include page="_menuAdmin.jsp" />




	<!-- Część centralna -->
	<div class="w3-container  ">
	<h3>Ustawienia aplikacji - słowniki.</h3>

		<div class="w3-border">
			<div class="w3-bar w3-black">
				<button class="w3-black w3-bar-item w3-button testbtn w3-padding-16"
					onclick="openTabs(event,'Names')">Imiona</button>
				<button class="w3-black w3-bar-item w3-button testbtn w3-padding-16"
					onclick="openTabs(event,'Streets')">Ulice</button>
			</div>

			<div id="Names" class="w3-container tab w3-animate-opacity">
				<div class="w3-padding-16">
<p>Cos 2</p>
				</div>


				<!--  Tu jakaś treść  -->
				
			</div>
			
			<div id="Streets" class="w3-container tab w3-animate-opacity">
				<p>Cos</p>
			</div>
			
			<!-- *************  Wyświetlanie alertu *************** -->
			<div id="id02" class="w3-modal" style="display: none;">
				<div class="w3-modal-content">
					<div class="w3-container w3-red">
						<span
							onclick="document.getElementById('id02').style.display='none'"
							class="w3-button w3-display-topright">&times;</span>
						<h3>UWAGA!</h3>
						<p>Uzupełnij wszystkie pola!!!</p>
					</div>
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