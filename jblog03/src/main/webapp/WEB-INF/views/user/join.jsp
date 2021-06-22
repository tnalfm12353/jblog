<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.9.0.js" ></script>
<script type="text/javascript">
$(()=>{
	
	btn = $('#btn-checkid');
	btn.click(()=>{
		var id = $("#id").val();
		if(id == ""){
			return ;
		}
		$.ajax({
			url : "${pageContext.request.contextPath }/user/api/checkid?id=" + id,
			type: "get",
			dataType : "json",
			success : response => {
				console.log(response);
				if(response.result != "success"){
					console.error(response.message);
					return ; 
				}
				
				if(response.data){
					alert("존재하는 이메일 입니다. 다른 이메일을 사용하세요!");
					$("#id").val("");
					$("#id").focus();
					return ;
				}
				btn.hide();
				$('#img-checkid').show();
			},
			error : ({xhr, status, e})=>{
				console.error(status,e);
			}
		})
	})
})
</script>
</head>
<body>
	<div class="center-content">
		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
		<form:form modelAttribute="userVo" class="join-form" id="join-form" method="post" action="${pageContext.request.contextPath}/user/join">
			<label class="block-label" for="name">이름</label>
			<form:input path="name"/>
			<div style="font-weight:bold; margin-left:20px; color:#f00"><form:errors path="name" /></div>
			<label class="block-label" for="blog-id">아이디</label>
			<form:input path="id"/> 
			<div style="font-weight:bold; margin-left:20px; color:#f00"><form:errors path="id" /></div>
			<input id="btn-checkid" type="button" value="id 중복체크">
			<img id="img-checkid" style="display: none;" src="${pageContext.request.contextPath}/assets/images/check.png">

			<label class="block-label" for="password">패스워드</label>
			<form:password path="password"  />
			<div style="font-weight:bold; margin-left:20px; color:#f00"><form:errors path="password" /></div>
			<fieldset>
				<legend>약관동의</legend>
				<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
				<label class="l-float">서비스 약관에 동의합니다.</label>
			</fieldset>

			<input type="submit" value="가입하기">

		</form:form>
	</div>
</body>
</html>
