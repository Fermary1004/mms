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
		<form action="<%= request.getContextPath()%>/bbs/register" method="post">
			<div class="form-group">
			  <label for="freeboard_title">제목 :</label>
			  <input type="text" class="form-control col-6" id="freeboard_title" name="freeboard_title">
			</div>
			<div class="form-group">
			  <label for="freeboard_writer">작성자 :</label>
			  <input type="text" class="form-control col-6" id="freeboard_writer" name="freeboard_writer" value="${user.member_id}" hidden>
			  <input type="text" class="form-control col-6" value="${user.member_nick}" readonly>
			</div>
			<div class="form-group">
			  <label for="freeboard_content">내용 :</label>
			  <textarea rows="10" class="form-control col-6" id="freeboard_content" name="freeboard_content"></textarea>
			</div>
			<button class="btn btn-outline-primary" type="submit">등록</button>
		</form>
	</div>
</body>
</html>