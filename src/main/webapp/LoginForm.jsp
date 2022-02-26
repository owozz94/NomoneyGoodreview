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
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous"> <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<c:if test="${msg ==1}">
	<script type="text/javascript">
		alert("아이디 또는 비밀번호를 잘못 입력했습니다.");
	</script>
</c:if>
<c:if test="${msg ==2}">
	<script type="text/javascript">
		alert("아이디를 입력해 주세요.");
	</script>
</c:if>
<c:if test="${msg ==3}">
	<script type="text/javascript">
		alert("비밀번호를 입력해 주세요.");
	</script>
</c:if>
<form method="post" action="LoginFormProc">
<div class="LineOutBox">
<div class="PostInBox">
		<div class="LoginBanner">
			<a href="Main.jsp"><img src="img/banner.png" alt="banner" width="50%"></a>
		</div>
		<div class="LoginBox">
			<div class = "loginForm">
				<div class="btnDiv">	
					<div class="btn-group" role="group" aria-label="Basic radio toggle button group">
					  <input type="radio" class="btn-check " name="userType" id="btnradio1" autocomplete="off" checked value="advertiser">
					  <label class="btn btn-outline-primary" for="btnradio1"><span class="text">광고주 로그인</span></label>
					  <input type="radio" class="btn-check" name="userType" id="btnradio2" autocomplete="off" value="reviewer">
					  <label class="btn btn-outline-primary" for="btnradio2">리뷰어 로그인</label>
					</div>
				</div>
	  <div class="inputID">
	    <input class="form-control" name="id" type="text" placeholder="아이디" aria-label="default input example">
		  
 		</div>
		<div class="inputPassword">
		  <input class="form-control" type="password" name="password" placeholder="비밀번호" aria-label="default input example">
		</div>
 	
 	<div class="loginBtn">
 	  <input type="submit" class="btn btn-primary" width="500" value="로그인">
 	  </div>
  <div class="loginJoiinURL"> 
  <span>회원이 아니신가요?</span>
  <a href="JoinTypeSelect.jsp" style="text-decoration: none;"><span>가입하기</span></a>
  </div>
</div>
  </div>
  </div>
  </div>
  </form>
</body>
</html>