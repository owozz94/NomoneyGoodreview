<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page errorPage="/ErrorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>

<div class="leftOutBox">
<div class="thumbnail">
<div class="thumbnailImg">
<img src="img/blogthumb.png" alt="thumb" width="160"><br>
</div>
<div class="leftNotice">
<pre>문의사항은 아래 메일로 
부탁드립니다.
(first_run@naver.com)
</pre>
</div>
<div class="writebtn">
<c:if test="${user.type==1}">
	  <button type="button" class="btn btn-primary" onClick="location.href='WriteForm.jsp'">글쓰기</button>
</c:if>
</div>
</div>
<nav>
<ul class="nav flex-column" >
<li class="nav-item">
    <a class="nav-link active" aria-current="page" href="MainThumbnail">전체보기</a>
  </li>
  <li class="nav-item">
    <a class="nav-link active"  href="MainThumbnail?location=서울">#서울</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="MainThumbnail?location=경기">#경기</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="MainThumbnail?location=대전">#대전</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="MainThumbnail?location=충청">#충청</a>
  </li>
   <li class="nav-item">
    <a class="nav-link" href="MainThumbnail?location=대구">#대구</a>
  </li>
   <li class="nav-item">
    <a class="nav-link" href="MainThumbnail?location=경북">#경북</a>
  </li>
   <li class="nav-item">
    <a class="nav-link" href="MainThumbnail?location=부산">#부산</a>
  </li>
   <li class="nav-item">
    <a class="nav-link" href="MainThumbnail?location=경남">#경남</a>
  </li>
   <li class="nav-item">
    <a class="nav-link" href="MainThumbnail?location=광주">#광주</a>
  </li>
   <li class="nav-item">
    <a class="nav-link" href="MainThumbnail?location=전라">#전라</a>
  </li>
   <li class="nav-item">
    <a class="nav-link" href="MainThumbnail?location=제주">#제주</a>
  </li>
</ul>
</nav>
<div class="deleteUser">

<!-- Modal -->
<div class="modal fade" id="exampleModalToggle" aria-hidden="true" aria-labelledby="exampleModalToggleLabel" tabindex="-1">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalToggleLabel">회원탈퇴</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        회원을 탈퇴하시겠습니까?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
        <button class="btn btn-primary" data-bs-target="#exampleModalToggle2" data-bs-toggle="modal">확인</button>
      </div>
    </div>
  </div>
</div>
<div class="modal fade" id="exampleModalToggle2" aria-hidden="true" aria-labelledby="exampleModalToggleLabel2" tabindex="-1">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalToggleLabel2">회원탈퇴</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      
      <form action="DeleteUser" method="post">
      <div class="modal-body">
          <div class="mb-3">
            <label for="recipient-name" class="col-form-label">아이디</label>
            <input type="text" name="id" class="form-control" id="recipient-name">
          </div>
          <div class="mb-3">
            <label for="password" class="col-form-label">비밀번호</label>
             <input type="password" name="password" class="form-control" id="recipient-name">
          </div>
      </div>
      <div class="modal-footer">
        <button class="btn btn-primary" data-bs-target="#exampleModalToggle2" data-bs-toggle="modal">회원탈퇴</button>
      </div>
        </form>
    </div>
  </div>
</div>
<c:if test="${user.id!=null }">
<a data-bs-toggle="modal" href="#exampleModalToggle" role="button">회원 탈퇴</a>
</c:if>
</div>
</div>
</body>
</html>