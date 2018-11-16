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

	<!-- Treść strony -->
	<div class="w3-cell-row">


		<!-- Część centralna -->
		<div class="w3-container w3-cell ">
			<div>
				<h1>Podaj dane do logowania.</h1>
				<h3>${message}</h3>

				<!--  Tu jakaś treść  -->
				<div class="w3-border">

					<!--  Tutaj jakaś tresć -->
<div class="w3-container  ">

				<div class="w3-border">
					<div class="w3-bar w3-black">
						<h3>Dane do zmiany</h3>
					</div>

					<div id="UserInfo" class="w3-container tab w3-animate-opacity">
						<!--  Tu jakaś treść  -->
						<div class="w3-container">
							<hr>
							<div class="w3-card ">

								<form class="w3-container w3-card-4 w3-padding-16" name="passupdate" accept-charset="utf-8"
									action="${pageContext.request.contextPath}/newpass/update"
									onsubmit="return validatePassChangeForm()" method='POST'>
									<!-- object="${User}" method='POST'> -->
									<div class="w3-row">

										<div>
											<input type="hidden" class="w3-input w3-border-1" id="iduser"
												value="" name="iduser">
										</div>
										<div>
											<input type="hidden" class="w3-input w3-border-1" id="idchange"
												value="" name="idchange">
										</div>
									</div>

									<div class="w3-row">
										<div class="w3-col" style="width: 150px">
											<b><label class="w3-text-black" >Nowe hasło:</label></b>
										</div>
										<div class="w3-rest">
											<input type="password" class="w3-input w3-border-1" id="newpassword"
												value="" name="newpassword">
										</div>
									</div>
									<div class="w3-row">
										<div class="w3-col" style="width: 150px">
											<b><label class="w3-text-black">Powtórz nowe hasło:</label></b>
										</div>
										<div class="w3-rest">
											<input type="password" class="w3-input w3-border-1" id="newpassword2"
												value="" name="newpassword2">
										</div>
									</div>

									<div class="container">
										<!-- <a href="#" class="w3-button w3-theme" role="button">Potwierdź</a> -->
										<button class="w3-button w3-theme" >Potwierdź</button>
									</div>
								</form>
										<!-- *************  Wyświetlanie alertu *************** -->
			<div id="id03" class="w3-modal" style="display: none;">
								<div class="w3-modal-content">
									<div class="w3-container w3-red">
										<span
											onclick="document.getElementById('id03').style.display='none'"
											class="w3-button w3-display-topright">&times;</span>
											<h3>UWAGA!</h3>
										<p>Sprawdz poprawość wprowadzanych danych.</p>
									</div>
								</div>
							</div>
							</div>
							<hr>

						</div>
					</div>

				</div>
			</div>
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