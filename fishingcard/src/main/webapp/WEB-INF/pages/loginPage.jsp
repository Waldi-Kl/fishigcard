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
		<a href="${pageContext.request.contextPath}/"
			class="w3-bar-item w3-button w3-padding-16"><i class="fa fa-home"></i>
			Home</a>

		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<a href="${pageContext.request.contextPath}/logout"
				class="w3-bar-item w3-button w3-padding-16"><i
				class="fa fa-sign-out"></i>Log out</a>
		</c:if>
	</div>
	</header>

	<!-- Treść strony  w3-cell-row -->
	<div class=" w3-container">

		<!-- Boczny panel -->

		<!-- Część centralna -->
		<div class="w3-container w3-cell ">
			<div>
				<h2>Logowanie</h2>
				<h3>${message}</h3>

				<div class="w3-card w3-theme">
					<!-- //w3-theme w3-white -->
					<div class="w3-responsive w3-card-4">

						<!-- /login?error=true -->

						<c:if test="${param.error == 'true'}">

							<div id="id01" class="w3-modal" style="display: inline;">
								<div class="w3-modal-content">
									<div class="w3-container w3-red">
										<span
											onclick="document.getElementById('id01').style.display='none'"
											class="w3-button w3-display-topright">&times;</span>
										<p>Logowanie Nieudane!!!</p>
										<!--	<p>Reason:${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</p>
										<p>Info z kontrolera:${message}</p>-->
										<p>Sprawdź wprowadzane dane.</p>

									</div>
								</div>
							</div>
						</c:if>
					</div>

					<div class="w3-card-4 w3-theme">
						<div class="w3-container">
							<h2>Dane do logowania</h2>
						</div>
						<form class="w3-container" name='f'
							action="${pageContext.request.contextPath}/j_spring_security_check"
							method='POST'>
							<p>
								<label class="w3-text-white"><b>Login</b></label> <input
									id="login" class="w3-input w3-border" type="text"
									name="userlogin" value="" />
							</p>
							<p>
								<label class="w3-text-white"><b>Pasword</b></label> <input
									class="w3-input w3-border" type="password" name="password" />
							</p>
							<p>
								<button class="w3-btn w3-theme" name="submit" type="submit">Wyślij</button>
							</p>
						</form>

						<div class="w3-container">

							<a
								href="${pageContext.request.contextPath}/forgotpassword/forgot/"
								class="w3-small">Reset hasła</a>

							<!-- class="w3-small" >Reset hasła</a> -->
							<p></p>
						</div>
					</div>

				</div>
				<p></p>
			</div>

		</div>
	</div>

	<jsp:include page="_footer.jsp" />
	<script>
		var myContextPath = '${pageContext.request.contextPath}';
		document.getElementById("myAnchor").onclick = function() {
			myFunction3(myContextPath)
		};
	</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/base.js">		
	</script>