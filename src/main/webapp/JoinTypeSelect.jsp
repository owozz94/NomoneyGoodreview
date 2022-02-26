<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page errorPage="/ErrorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/styles.css" rel="stylesheet" type="text/css">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous"> <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
<div class="LineOutBox">
	<div class="PostInBox">
	<div class="JoinTypebanner">
	<a href="Main.jsp"><img src="img/banner.png" alt="banner" width="50%"></a>
	</div>
		<div class="joinExplanation">
			대한민국의 모든 체험,<br>
			대한민국의 모든 리뷰어
		</div>
		<div class="joinContentOut">
		<div class="joinContent">
		<div class="joinAdvertiser">
		광고주/기업회원
			<div class="adChild">
			  <Button type="button" class="btn btn-primary" onclick="location.href='AdvertiserJoin.jsp'">광고주 회원가입</Button>
			</div>
		</div>
		<div class="joinReviwer">
		리뷰어/개인회원
			<div class="ReviwerChild">
			 <Button type="button" class="btn btn-primary" onclick="location.href='ReviewerJoin.jsp'">리뷰어 회원가입</Button>
			</div>
		</div>
		</div>
		</div>
	</div>
</div>
</body>
</html>