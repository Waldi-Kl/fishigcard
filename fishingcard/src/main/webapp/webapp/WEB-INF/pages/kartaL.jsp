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
<link href="${pageContext.request.contextPath}/css/w3.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/w3_theme.css" rel="stylesheet" type="text/css"/>

<title>${title}</title>
</head>
<body>
<jsp:include page="_menuCard.jsp"/>


	<!-- Treść strony -->
	<div class="w3-cell-row">


		<!-- Część centralna -->
		<div class="w3-container w3-cell ">
			<div>
				<h2>Karta Łowiecka</h2>
				
				<!--  Tu jakaś treść  -->
				<div class="w3-border">
				
						<!--  Tutaj jakaś tresć -->
						<p>Message : ${message}</p>
						
						<dir>
						<div class="w3-bar w3-black">
  <button class="w3-bar-item w3-button" onclick="openCity('London')">London</button>
  <button class="w3-bar-item w3-button" onclick="openCity('Paris')">Paris</button>
  <button class="w3-bar-item w3-button" onclick="openCity('Tokyo')">Tokyo</button>
</div>

<div id="London" class="w3-container w3-display-container city">
  <span onclick="this.parentElement.style.display='none'"
  class="w3-button w3-large w3-display-topright">&times;</span>
  <h2>London</h2>
  <p>London is the capital city of England.</p>
</div>

<div id="Paris" class="w3-container w3-display-container city" style="display:none">
  <span onclick="this.parentElement.style.display='none'"
  class="w3-button w3-large w3-display-topright">&times;</span>
  <h2>Paris</h2>
  <p>Paris is the capital of France.</p> 
</div>

<div id="Tokyo" class="w3-container w3-display-container city" style="display:none">
  <span onclick="this.parentElement.style.display='none'"
  class="w3-button w3-large w3-display-topright">&times;</span>
  <h2>Tokyo</h2>
  <p>Tokyo is the capital of Japan.</p>
</div>
						</dir>

				</div>
			</div>

		</div>
	</div>

<jsp:include page="_footer.jsp"/>

	<!-- Script for Sidebar, Tabs, Accordions, Progress bars and slideshows -->
	<script type="text/javascript"
    src="${pageContext.request.contextPath}/js/base.js">

    </script>
</body>
</html>