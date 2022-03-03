<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page errorPage="/ErrorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<c:if test="${msg ==1}">
	<script type="text/javascript">
		alert("아이디 또는 비밀번호를 잘못 입력했습니다.");
	</script>
	<c:remove var="msg"/>
</c:if>
<c:if test="${msg ==2}">
	<script type="text/javascript">
		alert("빈칸을 채워주세요.");
	</script>
	<c:remove var="msg"/>
</c:if>
<c:set var="center" value="${center}"/>
<c:if test="${msg==4}">
	<script type="text/javascript">
		alert("회원가입이 완료되었습니다!")
	</script>
	<c:remove var="msg"/>
	
</c:if>
<div class="PostOutBox">
	<div class="MainBox">
		<div class="PostBanner">
			<jsp:include page="Banner.jsp"/>
		</div>
		<div class="center">
			<div class="nav">
				<jsp:include page="Left.jsp"/>
			</div>
			<div class="MainContent">
				<jsp:include page="${center}"/>
			</div>
		</div>
		<div class="MainFooter">
			<jsp:include page="Footer.jsp"/>
		</div>
		</div>
		
	</div>
	
</body>
</html>