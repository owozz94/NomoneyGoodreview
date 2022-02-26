<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page errorPage="ErrorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<link href="css/styles.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
<c:if test="${msg==1}">
	<script type="text/javascript">
		alert("이미 존재하는 아이디입니다.")
	</script>
</c:if>
<c:if test="${msg==2}">
	<script type="text/javascript">
		alert("비밀번호가 일치하지 않습니다.")
	</script>
</c:if>
<c:if test="${msg==3}">
	<script type="text/javascript">
		alert("빈칸을 채워주세요.")
	</script>
</c:if>
<form method="post" action="AdvertiserJoin">
<div class="PostOutBox">
<div class="PostInBox">
<div class="joinInBoxBottom">
	<div class="PostBanner">
	<a href="Main.jsp"><img src="img/banner.png" alt="banner" width="80%"></a>
	</div>
	<div class="joinForm">
		<span>아이디</span>
	  	<input type="text" maxlength="15" name="id" class="form-control" id="exampleFormControlInput1">
	</div>
	<div class="joinForm">
		<span>비밀번호</span>
	  	<input type="password" maxlength="25" name="password" class="form-control" id="exampleFormControlInput1">
	</div>
	<div class="joinForm">
		<span>비밀번호 재확인</span>
  		<input type="password" maxlength="25" name="password_2" class="form-control" id="exampleFormControlInput1">
	</div>
		<div class="joinForm">
		<span>이름</span>
  		<input type="text" name="name" maxlength="10" class="form-control" id="exampleFormControlInput1">
	</div>
	<div class="joinForm">
		<span>이메일</span>
  		<input type="email" name="email" class="form-control" id="exampleFormControlInput1">
	</div>
	<div class="joinForm">
		<span>휴대전화</span>
  		<input type="text" name="tel" maxlength="15" class="form-control" id="exampleFormControlInput1">
	</div>
	<div class="joinForm">
		<span>상호명</span>
  		<input type="text" name="restaurantname" maxlength="15" class="form-control" id="exampleFormControlInput1">
	</div>
	<div class="joinForm">
		<span>대표자 성명</span>
  		<input type="text" name="companyname" maxlength="15" class="form-control" id="exampleFormControlInput1">
	</div>
	<div class="joinForm">
		<span>사업자 번호</span>
  		<input type="text" name="registration" maxlength="15" class="form-control" id="exampleFormControlInput1">
	</div>
	<div class="joinbtn">
	 <input type="submit" class="btn btn-primary" value="가입하기">
	</div>
	</div>
	</div>
	</div>
	</form>
</body>
</html>