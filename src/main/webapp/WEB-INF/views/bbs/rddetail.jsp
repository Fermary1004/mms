<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../resources/css/bootstrap.min.css">
<title>${detail.recdboard_title}</title>
</head>
<body>
	<jsp:include page="loginfo.jsp" />	
	<div class="jumbotron jumbotron-fluid">
  	<h1>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;게시글 상세</h1>  
  </div>
	<div class="container">
  	<div class="form-group">
		  <label for="recdboard_id">글 번호 :</label>
		  <input type="text" class="form-control col-6" id="recdboard_id" name="recdboard_id" value="${detail.recdboard_id}" readonly>
		</div>
		<div class="form-group">
		  <label for="recdboard_title">제목 :</label>
		  <input type="text" class="form-control col-6" id="recdboard_title" name="recdboard_title" value="${detail.recdboard_title}" readonly>
		</div>
		<div class="form-group">
		  <label for="recdboard_writer">작성자 :</label>
		  <input type="text" class="form-control col-6" id="recdboard_writer" name="recdboard_writer" value="${detail.member_nick}" readonly>
		</div>
		<div class="form-group">
		  <label for="recdboard_content">내용 :</label>
		  <textarea rows="10" class="form-control col-6" id="recdboard_content" name="recdboard_content" readonly>${detail.recdboard_content}</textarea>
		</div>
		<div class="form-group">
		  <label for="recdboard_tags">태그 :</label>
		  <input type="text" class="form-control col-6" id="recdboard_tags" name="recdboard_tags" value="${detail.recdboard_tags}" readonly>
		</div>
		<div class="form-group">
		  <label for="recdboard_regdate">편집일자 :</label>
		  <input type="text" class="form-control col-6" value="${detail.printeddate}" readonly>
		</div>
		<div class="form-group">
		  <label for="recdboard_regdate">작성일자 :</label>
		  <input type="text" class="form-control col-6" value="${detail.printdate}" readonly>
		</div>
		<div class="form-group">
		  <label for="recdboard_recd">추천수 :</label>
			<input type="text" class="form-control col-6" name="recdboard_recd" id="recdboard_recd" value="${detail.recdboard_recd}" readonly>
		</div>
		<a href="<%= request.getContextPath() %>/bbs/rdlist">
			<button class="btn btn-outline-primary" type="button">뒤로가기</button></a>
		<c:if test="${detail.recdboard_writer == user.member_id || user.authority == 'admin'}">
		<a href="<%= request.getContextPath() %>/bbs/rdupdate?recdboard_id=${detail.recdboard_id}">
			<button class="btn btn-outline-danger" type="button">수정</button></a>
		<a href="<%= request.getContextPath() %>/bbs/rddelete?recdboard_id=${detail.recdboard_id}">
			<button class="btn btn-outline-secondary" type="button">삭제</button></a></c:if>
		<c:if test="${detail.recommend == false}">
		<a href="<%= request.getContextPath() %>/bbs/recomend?recdboard_id=${detail.recdboard_id}&recdboard_recd=${detail.recdboard_recd}">
			<button class="btn btn-outline-secondary" type="button">추천</button></a></c:if>
	</div>
</body>
</html>