<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REGISTER</title>
<link rel="stylesheet" href="../resources/css/bootstrap.min.css">
</head>
<body>
	<div class="jumbotron">
		<h1>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;게시글 등록</h1>  
	</div>
	<div class="container">
		<form action="<%= request.getContextPath()%>/bbs/rdregister" method="post">
			<div class="form-group">
			  <label for="recdboard_title">제목 :</label>
			  <input type="text" class="form-control col-6" id="recdboard_title" name="recdboard_title">
			</div>
			<div class="form-group">
			  <label for="recdboard_writer">작성자 :</label>
			  <input type="text" class="form-control col-6" id="recdboard_writer" name="recdboard_writer" value="${user.member_id}" hidden>
			  <input type="text" class="form-control col-6" value="${user.member_nick}" readonly>
			</div>
			<div class="form-group">
			  <label for="recdboard_content">내용 :</label>
			  <textarea rows="10" class="form-control col-6" id="recdboard_content" name="recdboard_content"></textarea>
			</div>
			<div class="form-group">
				<label for="recdboard_tags">태그 :</label>
				<input type="text" class="form-control col-6" id="recdboard_tags" name="recdboard_tags">
			</div>
			<button class="btn btn-outline-primary" type="submit">등록</button>
		</form>
	</div>
</body>
</html>