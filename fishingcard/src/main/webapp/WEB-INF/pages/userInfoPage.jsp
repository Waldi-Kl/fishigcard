<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="d"%>
<%@ page isELIgnored="false"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//PL" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${pageContext.request.contextPath}/css/w3.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/w3_theme.css" rel="stylesheet" type="text/css"/>

<title>${title}</title>
</head>
<body>
	<jsp:include page="_menuAdmin.jsp" />


	<!-- Treść strony -->
	<div class="w3-cell-row">


		<!-- Część centralna -->
		<div class="w3-container w3-cell ">

			<div>
				<h2>Administracja użytkownikami</h2>
			</div>
			<!--  Tu jakaś treść  -->
			<div class="w3-container  ">

				<div class="w3-border">
					<div class="w3-bar w3-black">
						<button
							class="w3-black w3-bar-item w3-button testbtn w3-padding-16"
							onclick="openTabs(event,'UserInfo')">Dane użytkownika</button>
						<button
							class="w3-black w3-bar-item w3-button testbtn w3-padding-16"
							onclick="openTabs(event,'UserRole')">Role systemowe</button>
					</div>

					<div id="UserInfo" class="w3-container tab w3-animate-opacity">
						<!--  Tu jakaś treść  -->
						<div class="w3-container">
							<hr>
							<div class="w3-card">
								<div class="w3-container w3-black">
									<h3>Dane do zmiany</h3>
								</div>
								<form class="w3-container w3-card-4" name="userInfoForm" accept-charset="utf-8"
									action="${pageContext.request.contextPath}/userInfo/updateuser"
									 method='POST'>
									<!-- object="${User}" method='POST'> -->
									<div class="w3-row">

										<div class="w3-rest">
											<input type="hidden" class="w3-input w3-border-1" id="id"
												value="${user.id}" name="id">
										</div>
									</div>
									<div class="w3-row">
										<div class="w3-col" style="width: 150px">
											<b><label class="w3-text-black">Imię:</label></b>
										</div>
										<div class="w3-rest">
											<input type="text" class="w3-input w3-border-1" id="name"
												value="${user.name}" name="name">
										</div>
									</div>
									<div class="w3-row">
										<div class="w3-col" style="width: 150px">
											<b><label class="w3-text-black" >Nazwisko:</label></b>
										</div>
										<div class="w3-rest">
											<input type="text" class="w3-input w3-border-1" id="surname"
												value="${user.surname}" name="surname">
										</div>
									</div>
									<div class="w3-row">
										<div class="w3-col" style="width: 150px">
											<b><label class="w3-text-black">Email:</label></b>
										</div>
										<div class="w3-rest">
											<input type="text" class="w3-input w3-border-1" id="email"
												value="${user.email}" name="email">
										</div>
									</div>

									<div class="container">
										<!-- <a href="#" class="w3-button w3-theme" role="button">Potwierdź</a> -->
										<button class="w3-button w3-theme" >Potwierdź</button>
									</div>
								</form>
							</div>
							<hr>

						</div>
					</div>
					<div id="UserRole" class="w3-container tab w3-animate-opacity">
						<div class="w3-container">
							<hr>
							<div class="w3-card">
								<div class="w3-container w3-black">
									<h3>Role przypisne do użytkownika</h3>
								</div>
								<form class="w3-container w3-card-4" name="userInfoForm" accept-charset="utf-8"
									action="${pageContext.request.contextPath}/userInfo/updaterole"
									 method='POST'>
									<div class="w3-row">
										<div class="w3-col" style="width: 150px">
											<b><label class="w3-text-black">Rola:</label></b>
										</div>
										<div class="w3-rest">
											<!-- <input type="text" class="w3-input w3-border-1" id="role"
												value="${role.get(0)}" name="rule">  -->
											<select class="w3-select" name="option">
												<option value="" disabled selected>${role.get(0)}</option>
												<option value="ADMIN">ADMIN</option>
												<option value="HOST">HOST</option>
												<option value="USER">USER</option>
												<option value="BRAK">BRAK</option>
											</select>
										</div>
									</div>
									<input type="hidden" name="userID" value="${user.id}">
									<div class="container">
										<button class="w3-button w3-theme" >Potwierdź</button>
									</div>
								</form>
							</div>
							<hr>

						</div>
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