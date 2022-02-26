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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</head>
<body>

<c:if test="${msg==1}">
	<script type="text/javascript">
		alert("제목을 입력해주세요.")
	</script>
</c:if>
<c:if test="${msg==2}">
	<script type="text/javascript">
		alert("내용을 입력해주세요.")
	</script>
</c:if>
<form action="FileProc" method="post" enctype="multipart/form-data">
<div class="PostOutBox" >
	<div class="PostInBox">
	<div class="writeBoxBottom">
		<div class="writeBtn">
			<div class="select">
			<input type="submit"  class="btn btn-primary" value="발행">
				  <select class="form-select" name="location" aria-label="Default select example">
					<option value="서울">서울</option>
					<option value="경기">경기</option>
					<option value="충청">충청</option>
					<option value="대구">대구</option>
					<option value="경북">경북</option>
					<option value="부산">부산</option>
					<option value="경남">경남</option>
					<option value="전라">전라</option>
					<option value="제주">제주</option>
				</select>
			</div>
		</div>
		<div class="selectBottomBox">
			<div class="writeTitle" >
			  <span>제목</span>
			  <input type="text" name="title" class="form-control" id="exampleFormControlInput1" placeholder="제목">
			</div>
			<div class="WriteContent">
			   <span>내용</span>
			  <textarea class="form-control" placeholder="내용" rows="23" name="content"></textarea>
			</div>
			<input type="file" name="filename" >
		</div>
	</div>
	</div>
	
</div>	
</form>
</body>
</html>