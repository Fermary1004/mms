<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../resources/css/bootstrap.min.css">
<title>${detail.freeboard_title}</title>
</head>
<body>
	<jsp:include page="loginfo.jsp" />	
	<div class="jumbotron jumbotron-fluid">
  	<h1>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;게시글 상세</h1>  
  </div>
	<div class="container">
  	<div class="form-group">
		  <label for="freeboard_id">글 번호 :</label>
		  <input type="text" class="form-control col-6" id="freeboard_id" name="freeboard_id" value="${detail.freeboard_id}" readonly>
		</div>
		<div class="form-group">
		  <label for="freeboard_title">제목 :</label>
		  <input type="text" class="form-control col-6" id="freeboard_title" name="freeboard_title" value="${detail.freeboard_title}" readonly>
		</div>
		<div class="form-group">
		  <label for="freeboard_writer">작성자 :</label>
		  <input type="text" class="form-control col-6" id="freeboard_writer" name="freeboard_writer" value="${detail.member_nick}" readonly>
		</div>
		<div class="form-group">
		  <label for="freeboard_content">내용 :</label>
		  <textarea rows="10" class="form-control col-6" id="freeboard_content" name="freeboard_content" readonly>${detail.freeboard_content}</textarea>
		</div>
		<div class="form-group">
		  <label for="freeboard_regdate">편집일자 :</label>
		  <input type="text" class="form-control col-6" value="${detail.printeddate}" readonly>
		</div>
		<div class="form-group">
		  <label for="freeboard_regdate">작성일자 :</label>
		  <input type="text" class="form-control col-6" value="${detail.printdate}" readonly>
		</div>
		<a href="<%= request.getContextPath() %>/bbs/list">
			<button class="btn btn-outline-primary" type="button">뒤로가기</button></a>
		<c:if test="${detail.freeboard_writer == user.member_id || user.authority == 'admin'}">
		<a href="<%= request.getContextPath() %>/bbs/update?freeboard_id=${detail.freeboard_id}">
			<button class="btn btn-outline-danger" type="button">수정</button></a>
		<a href="<%= request.getContextPath() %>/bbs/delete?freeboard_id=${detail.freeboard_id}">
			<button class="btn btn-outline-secondary" type="button">삭제</button></a></c:if>
	</div>
</body>
</html>