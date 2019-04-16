<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../resources/css/list.css">
<link rel="stylesheet" href="../resources/css/bootstrap.min.css">
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<meta charset="UTF-8">
<title>RDBOARD</title>
</head>
<body>
	<jsp:include page="loginfo.jsp" />
	<div class="jumbotron jumbotron-fluid" id="bgblk">
		<h1><a href="<%= request.getContextPath() %>/bbs/list"><span>◁</span></a>
		자료 게시판
		<a href="<%= request.getContextPath() %>/bbs/list"><span>▷</span></a></h1>  
	</div>
	<div class="container">
		<table class="table table-striped table-hover">
	    <thead>
	      <tr>
	        <th class="id">글 번호</th>
	        <th class="title">제목</th>
	        <th class="writer">작성자</th>
	        <th class="recd">추천수</th>
	        <th class="tags">태그</th>
	        <th class="editdate">작성일</th>
	      </tr>
	    </thead>
	    <tbody>
	    	<c:forEach items="${list}" var="board">
	      <tr>
	        <td>${board.recdboard_id}</td>
					<td><a href="<%= request.getContextPath() %>/bbs/rddetail?recdboard_id=${board.recdboard_id}">${board.recdboard_title}</a></td>
					<td>
						<span>
							<c:if test="${board.member_image != null}">
						  	<img class="img-thumbnail" style="width:30px" src="/mms/resources/images/${board.member_image}" />
						  </c:if>
				  	</span>
						${board.member_nick}
					</td>
					<td>${board.recdboard_recd}</td>
					<td>${board.recdboard_tags}</td>
					<td>${board.printdate}</td>
	      </tr>
	      </c:forEach>
	    </tbody>
	  </table>
		<hr>
		<br>
		<div>
			<form action="<%= request.getContextPath() %>/bbs/rdsearch" method="get">
				<select name="key">
					<option value="id">글 번호</option>
					<option value="title">제목</option>
					<option value="content">내용</option>
					<option value="writer">작성자</option>
					<option value="tags">태그</option>
				</select>
				<input type="text" name="word">
				<button class="btn btn-primary col-sm-2">검색</button>
			</form>
			<a href="<%= request.getContextPath() %>/bbs/rdregister">
				<button class="btn btn-primary col-sm-2">글쓰기</button></a>
		</div>
	</div>
</body>
</html>