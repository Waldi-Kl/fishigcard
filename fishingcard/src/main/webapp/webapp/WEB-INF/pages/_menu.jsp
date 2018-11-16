<!-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%> -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<header class="w3-container w3-theme">
	<div class="w3-bar">
		<div class="w3-row">
			<div class="w3-col s9 w3-center">
				<a href="${pageContext.request.contextPath}/"
					class="w3-bar-item w3-button w3-padding-16"><i
					class="fa fa-home"></i> Home</a> <a
					href="${pageContext.request.contextPath}/admin"
					class="w3-bar-item w3-button w3-padding-16"><i
					class="fa fa-bank"></i> Administracja</a>
			<!-- <a
					href="${pageContext.request.contextPath}/admin/settingsPages"
					class="w3-bar-item w3-button w3-padding-16"><i class="fa fa-cogs"></i> Ustawienia</a> -->	

				<div class="w3-dropdown-hover">
					<button class="w3-button w3-padding-16 w3-theme">
					<i class="fa fa-folder"></i> Karta<i class="fa fa-caret-down"></i>
					</button>
					<div class="w3-dropdown-content w3-card-4 w3-bar-block">
						<a href="${pageContext.request.contextPath}/cardInfo/fishing"
							class="w3-bar-item w3-button">Wędkarska</a> <a
							href="${pageContext.request.contextPath}/cardInfo/hunting"
							class="w3-bar-item w3-button">Łowiectwa</a> <a
							href="${pageContext.request.contextPath}/cardInfo/guarding"
							class="w3-bar-item w3-button">Strażnikow</a>
					</div>

				</div>
				<a href="${pageContext.request.contextPath}/personInfo/personList"
					class="w3-bar-item w3-button w3-padding-16"><i
					class="fa fa-male"></i> Osoba</a>
					
				<a href="${pageContext.request.contextPath}/statistics/"
					class="w3-bar-item w3-button w3-padding-16"><i
					class="fa fa-bar-chart"></i> Statystyki</a>
			</div>
			<!-- 	------------------------------------------ login info  -------------------------  -->
			<div class="w3-col s3 w3-center">
				<div class="w3-container w3-cell w3-cell-middle">
					<p>
						<i class="fa fa-user"></i> Login:
						${pageContext.request.userPrincipal.name}
					</p>
				</div>
				<div class="w3-container w3-cell">
					<c:if test="${pageContext.request.userPrincipal.name != null}">
						<a href="${pageContext.request.contextPath}/logout"
							class="w3-button w3-padding-16"><i class="fa fa-sign-out"></i> Log
							out</a>
					</c:if>
				</div>
			</div>
		</div>
	</div>
</header>

