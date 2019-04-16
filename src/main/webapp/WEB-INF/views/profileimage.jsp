<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./resources/css/bootstrap.min.css">
<title>PROFILE</title>
</head>
<body>
	<div class="container">
		<c:if test="${user.member_image != null}">
	  	<img style="width:100px" class="rounded" src="/mms/resources/images/${user.member_image}" />
	  </c:if>
	 	<c:if test="${user.member_image == null}">
	 		<img style="width:100px" class="rounded" src="/mms/resources/images/base.jpg" />
	 	</c:if>
	 	<p>프로필 이미지 변경</p>
		<form action="<%= request.getContextPath() %>/profileimage" method="post" enctype="multipart/form-data">
			<div class="custom-file">
				<input type="file" class="custom-file-input col-6" id="profileimage" name="profileimage">
				<label class="custom-file-label col-6" for="profileimage">파일을 선택하세요</label>		    
		  	<button type="submit" class="btn btn-primary">수정하기</button>
				<a href="<%= request.getContextPath() %>/bbs/list">
					<button type="button" class="btn btn-secondary">뒤로가기</button></a>
			</div>
		</form>
	</div>
</body>
</html>