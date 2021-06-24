<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.9.0.js"></script>
</head>
<body>
	<div class="center-content">
		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
		<form class="login-form" action="${pageContext.request.contextPath}/user/auth" method="post">
      		<label>아이디</label> <input type="text" name="id" value="${id }" />
      		<label>패스워드</label> <input type="password" name="password" />
      		<div style="display:flex; padding:3px;">
      			<input type="submit" value="로그인" >
      			<c:if test="${result == false }">
      				<div style="flex-direction:column; flex:auto; color:#f00; font-weight:bold;">
	      				<p>가입하지 않은 아이디이거나,</p>
	      				<p>잘못된 비밀번호입니다.</p>
	      			</div>
	      		</c:if>
      		</div>
		</form>
	</div>
</body>
</html>
