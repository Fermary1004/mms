<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<link rel="stylesheet" href="./resources/css/bootstrap.min.css">
<head>
<meta charset="UTF-8">
<title>PROFILE</title>
</head>
<body>
	<div class="jumbotron">
	  <h1>프로필 편집</h1>  
	</div>
	<div class="container">	
		<form action="<%= request.getContextPath() %>/profile" method="post" id="profile">
			<input type="text" name="member_id" id="member_id" value="${user.member_id}" hidden>
			<div class="form-group row col-lg-6 col-md-8 col-sm-10 col-11">
			  <label for="member_email">
			  	<b>E-MAIL :</b>
			  </label>
			  <input type="email" class="form-control" name="member_email" id="member_email" value="${user.member_email}" readonly>
			</div>
			<div class="form-group row col-lg-6 col-md-8 col-sm-10 col-11">
			  <label for="member_pw">
			  	<b>PASSWORD :</b>
			  </label>
			  <input type="password" class="form-control" name="member_pw" id="member_pw" placeholder="비밀번호를 입력해주세요">
			</div>
			<div class="form-group row col-lg-6 col-md-8 col-sm-10 col-11">
			  <label for="member_nick">
			  	<b>NICK_NAME :</b>
			  </label>
			  <input type="text" class="form-control" name="member_nick" id="member_nick" value="${user.member_nick}">
			</div>
			<div class="form-group row col-lg-6 col-md-8 col-sm-10 col-11">
			  <label for="member_name">
			  	<b>NAME :</b>
			  </label>
			  <input type="text" class="form-control" name="member_name" id="member_name" value="${user.member_name}">
			</div>
			<div class="form-group row col-lg-6 col-md-8 col-sm-10 col-11">
			  <label for="member_birth">
			  	<b>BIRTH :</b>
			  </label>
			  <input type="date" class="form-control" name="inputbirth" id="inputbirth">
			</div>
			<div class="form-check-inline">
			  <label class="form-check-label" for="male">
			    <input type="radio" class="form-check-input" name="member_gender" id="male" value="male" <c:if test="${user.member_gender == 'male'}">checked</c:if>>Male
			  </label>
			</div>
			<div class="form-check-inline">
			  <label class="form-check-label" for="female">
			    <input type="radio" class="form-check-input" name="member_gender" id="female" value="female" <c:if test="${user.member_gender == 'female'}">checked</c:if>>Female
			  </label>
			</div>
		<hr>
		<div>
			<button type="submit" class="btn btn-primary">수정하기</button>
			<a href="<%= request.getContextPath() %>/bbs/list">
				<button type="button" class="btn btn-secondary">뒤로가기</button>
			</a>
		</div>
		</form>
	</div>
</body>
</html>