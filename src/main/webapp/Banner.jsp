<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page errorPage="/ErrorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<link href="css/styles.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="bannerOutBox">

	<div class="Bannerbtn">
	
	<c:if test="${user.id!=null }">
	
	${user.id }님 | 
	<a href="LogoutProc" style="text-decoration: none;">로그아웃</a>
	</c:if>
	<c:if test="${user.id==null }">
	<div class="Bannerbtn">
	<span class="BannerbtnLine">
	<a href='LoginForm.jsp' style="text-decoration: none;">로그인</a></span>
			<span><a href='JoinTypeSelect.jsp' style="text-decoration: none;">회원가입</a>
			</span></div>
	  </c:if>
	</div>
	
	<div class="PostBanner">
	<a href="MainThumbnail"><img src="img/banner.png" alt="banner" width="50%"></a>
</div>
</div>
</body>
</html>