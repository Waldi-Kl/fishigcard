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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
<title>${title}</title>
</head>
<body><!-- 
	<header class="w3-container w3-theme">
	<div class="w3-bar">
		<div class="w3-row">
			<div class="w3-col s9 w3-center">
				<a href="${pageContext.request.contextPath}/"
					class="w3-bar-item w3-button w3-padding-16"><i
					class="fa fa-home"></i> Home</a>
			</div>-->
			<!-- 	------------------------------------------ login info  -------------------------  -->
			<!--<div class="w3-col s3 w3-center">
				<div class="w3-container w3-cell">
					<p>Login: ${pageContext.request.userPrincipal.name}</p>
				</div>
				<div class="w3-container w3-cell">
					<c:if test="${pageContext.request.userPrincipal.name != null}">
						<a href="${pageContext.request.contextPath}/logout"
							class="w3-button w3-padding-16"><i
							class="fa fa-sign-out"></i> Log out</a>
					</c:if>
				</div>
			</div>
		</div>
	</div>

</header> -->

	<header class="w3-container w3-theme">
	<div class="w3-bar">
		<div class="w3-row">
			<!-- 	------------------------------------------ linki -------------------------  -->
			<div class="w3-col s9 w3-center">
				<a href="${pageContext.request.contextPath}/"
					class="w3-bar-item w3-button w3-padding-16"><i
					class="fa fa-home"></i> Home</a>
			</div>

			<!-- 	------------------------------------------ login info  -------------------------  -->
			<div class="w3-col s3 w3-center">
				<div class="w3-container w3-cell w3-cell-middle">
				<p><i class="fa fa-user"></i> Login: ${pageContext.request.userPrincipal.name}</p>							  
				</div>
				<div class="w3-container w3-cell">
					<c:if test="${pageContext.request.userPrincipal.name != null}">
						<a href="${pageContext.request.contextPath}/logout"
							class="w3-button w3-padding-16"><i
							class="fa fa-sign-out"></i> Log out</a>
					</c:if>
				</div>
			</div>
		</div>
	</div>

	</header>

	<!-- Treść strony -->
	<div class="w3-cell-row">


		<!-- Część centralna -->
		<div class="w3-container w3-cell ">
			<div>
				<h1>Nie powodzenie</h1>
				<h3>${message}</h3>

				<!--  Tu jakaś treść  -->
				<div class="w3-border">

					<!--  Tutaj jakaś tresć -->

				</div>
			</div>

		</div>
	</div>

	<jsp:include page="_footer.jsp" />

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/base.js">

    </script>

</body>
</html>