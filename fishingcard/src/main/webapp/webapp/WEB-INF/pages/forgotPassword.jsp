<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<title>${title}</title>
</head>
<body>

	<header class="w3-container w3-theme">
	<div class="w3-bar">
		<div class="w3-row">
			<!-- 	------------------------------------------ linki -------------------------  -->
			<div class="w3-col s9 w3-center">
				<a href="${pageContext.request.contextPath}/"
					class="w3-bar-item w3-button w3-padding-16"><i
					class="fa fa-home"></i> Home</a>

			</div>

		</div>
	</div>

	</header>

	<div class="w3-cell-row">

		<!-- Część centralna -->

		<div class="w3-container w3-cell w3-border">
			<p>${errorMessage}</p>
			<p>${successMessage}</p>
			<h2>Zmiana hasła.</h2>
			
				<p>Podaj Twój email:</p>			
				<form class="w3-container" name='forgot'
					action="${pageContext.request.contextPath}/forgotpassword/forgot/"
					method='POST'>
					<p>
						<label class="w3-text"><b>E-mail</b></label> <input id="email"
							class="w3-input w3-border" type="email" name="email" value="" />
					</p>

					<p>
						<button class="w3-btn w3-theme" name="submit" type="submit">Wyślij</button>
					</p>
				</form>

		</div>

	</div>


	<jsp:include page="_footer.jsp" />



</body>
</html>