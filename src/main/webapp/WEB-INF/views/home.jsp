<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<link rel="stylesheet" href="./resources/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<head>
	<title>HELLO</title>
</head>
<body>
	<div class="jumbotron">
	  <h1>Hellooo Hellooo Heeello</h1>  
	</div>
	<div class="container">
		<form action="<%= request.getContextPath() %>/" method="post">
			<div class="form-group row col-lg-6 col-md-8 col-sm-10 col-11">
			  <label for="member_email">
			  	<b>E-MAIL :</b>
			  </label>
			  <input type="email" class="form-control" name="member_email" id="member_email">
			</div>
			<div class="form-group row col-lg-6 col-md-8 col-sm-10 col-11">
			  <label for="member_pw">
			  	<b>PASSWORD :</b>
			  </label>
			  <input type="password" class="form-control" name="member_pw" id="member_pw">
			</div>
			<hr>
			<div class="form-group">
				<button type="submit" class="btn btn-primary">&nbsp;&nbsp;로그인&nbsp;&nbsp;</button>
				<a href="<%= request.getContextPath() %>/signup">
					<button type="button" class="btn btn-success">회원가입</button>
				</a>
			</div>
		</form>
	</div>
</body>
</html>
