<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<link rel="stylesheet" href="./resources/css/bootstrap.min.css">
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="./resources/js/jquery.validate.min.js"></script>
<script src="./resources/js/additional-methods.min.js"></script>
<script src="./resources/js/validate.js"></script>
<head>
	<title>SIGNUP</title>
</head>
<body>
	<div class="jumbotron">
	  <h1>회 원 가 입</h1>  
	</div>
	<div class="container">	
		<form action="<%= request.getContextPath() %>/signup" method="post" id="signup">
			<div class="form-group row col-lg-6 col-md-8 col-sm-10 col-11">
			  <label for="member_email">
			  	<b>E-MAIL :</b>
			  </label>
			  <input type="email" class="form-control" name="member_email" id="member_email" placeholder="사용하시는 Email을 입력해주세요">
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
			  <input type="text" class="form-control" name="member_nick" id="member_nick" placeholder="게시판에서 사용하실 ID를 입력해주세요">
			</div>
			<div class="form-group row col-lg-6 col-md-8 col-sm-10 col-11">
			  <label for="member_name">
			  	<b>NAME :</b>
			  </label>
			  <input type="text" class="form-control" name="member_name" id="member_name" placeholder="이름을 입력해주세요">
			</div>
			<div class="form-group row col-lg-6 col-md-8 col-sm-10 col-11">
			  <label for="member_birth">
			  	<b>BIRTH :</b>
			  </label>
			  <input type="date" class="form-control" name="inputbirth" id="inputbirth">
			</div>
			<div class="form-check-inline">
			  <label class="form-check-label" for="male">
			    <input type="radio" class="form-check-input" name="member_gender" id="male" value="male" checked>Male
			  </label>
			</div>
			<div class="form-check-inline">
			  <label class="form-check-label" for="female">
			    <input type="radio" class="form-check-input" name="member_gender" id="female" value="female">Female
			  </label>
			</div>
		</form>
		<hr>
		<div>
			<a href="<%= request.getContextPath() %>/">
				<button type="button" class="btn btn-primary">로그인 화면으로</button></a>
			<button id="submit" type="button" class="btn btn-success">&nbsp;&nbsp;&nbsp;&nbsp;회원가입&nbsp;&nbsp;&nbsp;&nbsp;</button>
			<a href="<%= request.getContextPath() %>/bbs/list">
				<button type="button" class="btn btn-secondary">그냥 이용하기</button></a>
		</div>
	</div>
</body>
</html>