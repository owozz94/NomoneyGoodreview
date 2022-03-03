<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page errorPage="/ErrorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
<div class="centerPostOut">


<c:if test="${location==null }">
<h6>전체 게시글</h6>
</c:if>
<c:if test="${location!=null }">
<h6>#${location }</h6>
</c:if>
<div class="container">
  <!-- <BlogBean> list for문 -->
<c:forEach var="bean" items="${list }">
<div class="item" onclick="location.href='GetPost?num=${bean.num}'">  
	    <div class="thumbImg">
	 <img src="${bean.url }" alt="썸네일영역"> 
	    </div>
	    <div class="thumbTitle">
	   	<span>[${bean.location}]  ${bean.title }</span> 
	    </div>
	    
    </div>
</c:forEach>   
  </div>
  </div>
</body>
</html>