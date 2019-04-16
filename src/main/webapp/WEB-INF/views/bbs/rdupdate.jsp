<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UPDATER</title>
<link rel="stylesheet" href="../resources/css/bootstrap.min.css">
</head>
<body>
	<jsp:include page="loginfo.jsp" />
	<div class="jumbotron">
  	<h1>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;게시글 수정</h1>  
  </div>
	<div class="container">
		<form action="<%= request.getContextPath()%>/bbs/rdupdate" method="post">
			<div class="form-group">
			  <label for="recdboard_id">글 번호 :</label>
			  <input type="text" class="form-control col-6" id="recdboard_id" name="recdboard_id" value="${detail.recdboard_id}" readonly>
			</div>
			<div class="form-group">
			  <label for="recdboard_title">제목 :</label>
			  <input type="text" class="form-control col-6" id="recdboard_title" name="recdboard_title" value="${detail.recdboard_title}">
			</div>
			<div class="form-group">
			  <label for="recdboard_writer">작성자 :</label>
			  <input type="text" class="form-control col-6" id="recdboard_writer" name="recdboard_writer" value="${detail.recdboard_writer}" hidden>
			  <input type="text" class="form-control col-6" value="${detail.member_nick}" readonly>
			</div>
			<div class="form-group">
			  <label for="recdboard_content">내용 :</label>
			  <textarea rows="10" class="form-control col-6" id="recdboard_content" name="recdboard_content">${detail.recdboard_content}</textarea>
			</div>
			<div class="form-group">
				<label for="recdboard_tags">태그 :</label>
				<input type="text" class="form-control col-6" id="recdboard_tags" name="recdboard_tags" value="${detail.recdboard_tags}">
			</div>
			<button class="btn btn-outline-primary" type="submit">수정</button>
		</form>
	</div>
</body>
</html>