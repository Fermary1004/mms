<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="../resources/css/loginfo.css">
<div class="lf">
	<div class="lfbx">
	  <c:if test="${user.member_id != null}">
		  <a href="<%= request.getContextPath() %>/profileimage">
			  <c:if test="${user.member_image != null}">
			  	<img class="lfside img-thumbnail" src="/mms/resources/images/${user.member_image}" />
			  </c:if>
		  	<c:if test="${user.member_image == null}">
		  		<img class="lfside img-thumbnail" src="/mms/resources/images/base.jpg" />
		  	</c:if>
		  </a>
	  	<div class="mdside">
	  		${user.member_nick}
	  	</div>
	  	<div class="rgside">
		  	<a class="lfakr" href="<%= request.getContextPath() %>/profile">
					<span class="badge badge-warning lfbdg">프로필</span></a>
				<a class="lfakr" href="<%= request.getContextPath() %>/signout">
					<span class="badge badge-danger lfbdg">로그아웃</span>	</a>
			</div>
	  </c:if>
	  <c:if test="${user.member_id == null}">
	  	<img class="lfside" src="/mms/resources/images/base.jpg" />
	  	<div class="mdside">
	  		GUEST
	  	</div>
	  	<div class="rgside">
		  	<a  class="lfakr" href="<%= request.getContextPath() %>/">
					<span class="badge badge-success lfbdg">로그인</span></a>
		  	<a  class="lfakr" href="<%= request.getContextPath() %>/signup">
					<span class="badge badge-primary lfbdg">회원가입</span></a>
			</div>
	  </c:if>  
  </div>
</div>