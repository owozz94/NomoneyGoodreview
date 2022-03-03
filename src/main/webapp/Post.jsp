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
<div class="OutBox">
	<div class="PostInBoxBottom">
	<div class="BannerBottomBox">

	<div class="location">
	#${BlogBean.location }
	</div>
		<div class="PostTitle">
		${BlogBean.title }
		</div>
		</div>
		<div class="TitleBottomBox">
			<div class="PostId">
			${BlogBean.id }
			<span>${BlogBean.d_date }</span>
			</div>
     	   <div class="PostNav">
     	   <c:if test="${user.id==BlogBean.id}">
			 <nav class="navbar navbar-expand-lg navbar-light">
			  <ul class="navbar-nav me-auto mb-2 mb-lg-0">
			 <li class="nav-item dropdown">
	          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	            설정
	          </a>
	          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
	         
	            <li><a class="dropdown-item" href="GetPost?option=update&num=${BlogBean.num}">수정하기</a>
	           
	            <li><hr class="dropdown-divider"></li>
	            <li><a class="dropdown-item" href="Delete?option=delete&num=${BlogBean.num}">삭제하기</a></li>
	           
	          </ul>
	        </li>
	        </ul>
	        </nav>
	        </c:if>
	          <div class="PostCount"> 조회수  ${BlogBean.readcount } </div>
	        </div>
	      </div>
	      <div class="PostContent">
		      <div class="PostBanner">
		       <a href="#">	<img src="img/postBanner.png" alt="banner" width="100%" height="270px"/></a>
		      </div>
				<pre class="PostAd">
				${BlogBean.content}
			</pre>
				<c:if test="${BlogBean.url!=null }">
					<div class="foodImg">
						<img src="${BlogBean.url}" alt="이미지" width="450" height="350">
					</div>
				</c:if>
				<pre class="postNotice">
				<span>[노머니굳리뷰 체험단 참여 방법]</span>
				1. 제공옵션을 꼭 확인하시고 댓글에 적어주세요!
				2. 기간 내 체험이 가능한지 꼼꼼히 확인해주세요!
				3. 취소를 원할 경우, 댓글을 삭제해주세요!(당일 금지)
			</pre>	
		</div>
<div class="LastContentBox">
<div class="PostanwserLine">
<h6>댓글</h6>
</div>
<c:forEach var="list" items="${comment}">
<div class="Postanwser">

<div class="PostComentId">${list.id }</div>
<span class="PostComment">
${list.content }
</span>
<c:if test="${user.id==list.id}">
<span class="postDelete">

<a href="CommentSubmit?commentNum=${list.commentNum }&num=${BlogBean.num}&type=commentDelete" style="text-decoration: none;">x</a></span>
</c:if>
<div class="postComentDate">${list.d_date }</div>

</div>
</c:forEach>
<c:if test="${ucmt.commentNum==null }">
 <div class="notComment">
<h6>댓글이 없습니다.</h6>
</div>
</c:if>
 <form method="post" action="CommentSubmit">
 <c:if test="${user.id!=null }">
<div class="UserComentBox">
<div class="UserComent">
  <div class="CommentWrite">댓글쓰기</div>
  <input type="hidden" name="num" value="${BlogBean.num}"/>
   <textarea class="form-control" rows="2" name="comment"></textarea>
</div>
<div class="commentSubmit">
<input type="submit" class="btn btn-primary" value="신청">
</div>
</div>
 </c:if>
 
 </form>

</div>
</div>
</div>

</body>
</html>