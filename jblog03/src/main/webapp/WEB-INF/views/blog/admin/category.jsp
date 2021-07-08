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
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/ejs/ejs.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.9.0.js"></script>
<script type="text/javascript">
	var listItemTemplate = new EJS({
		url: "${pageContext.request.contextPath }/assets/js/ejs/listitem-template.ejs"
	});
	var listTemplate = new EJS({
		url: "${pageContext.request.contextPath }/assets/js/ejs/list-template.ejs"
	});
	
	const fetch = () =>{
		$.ajax({
			url:"${pageContext.request.contextPath}/${authUser.id }/admin/api/category",
			type: "get",
			dataType: "json",
			success: function(response) {
				var html = listTemplate.render(response);
				$(".admin-cat").append(html);
			}
		})
	}
	
	$(()=>{
		$("#add-category-form").submit((e)=>{
			e.preventDefault();
			let categoryVo = {};
			categoryVo.name = $("#input-name").val();
			categoryVo.description = $("#input-description").val();
			console.log(categoryVo);
			$.ajax({
				url:"${pageContext.request.contextPath}/${authUser.id }/admin/api/category",
				type: "post",
				contentType: "application/json",
				dataType: "json",
				data: JSON.stringify(categoryVo),
				success: function(response) {
					console.log(response);
					var html = listItemTemplate.render(response.data);
					$(".admin-cat").append(html);
				}
			});
		});
		
		
		
	});
	
	$(document).on('click', '.admin-cat td a', function(event){
		event.preventDefault();
		const _url = $(this).attr("href");
		$.ajax({
			url: _url,
			type: "delete",
			dataType: "json",
			success: function(response) {
				console.log(response);
				console.log($(".admin-cat #category-" + response.data));
				$(".admin-cat #category-" + response.data).remove();
			}
		});
	});

	fetch();
</script>
</head>
<body>
	<div id="container">
		<c:set var="element" value="category" scope="request" />
		<c:import url="/WEB-INF/views/blog/include/header.jsp" />
		<div id="wrapper">
			<div id="content" class="full-screen">
				<c:import url="/WEB-INF/views/blog/include/admin-menu.jsp" />
		      	<table class="admin-cat">
		      		<tr>
		      			<th>번호</th>
		      			<th>카테고리명</th>
		      			<th>포스트 수</th>
		      			<th>설명</th>
		      			<th>삭제</th>      			
		      		</tr>
		      						  
				</table>
      	
      			<h4 class="n-c">새로운 카테고리 추가</h4>
      			<form id="add-category-form" action="" method="post">
      				<input type="hidden" name="userid" value="${category.userId }" />
			      	<table id="admin-cat-add">
			      		<tr>
			      			<td class="t">카테고리명</td>
			      			<td><input type="text" name="name" id="input-name"></td>
			      		</tr>
			      		<tr>
			      			<td class="t">설명</td>
			      			<td><input type="text" name="description" id="input-description"></td>
			      		</tr>
			      		<tr>
			      			<td class="s">&nbsp;</td>
			      			<td><input type="submit" value="카테고리 추가"></td>
			      		</tr>      		      		
			      	</table>
		      	</form>
			</div>
		</div>
		<c:import url="/WEB-INF/views/blog/include/footer.jsp" />
	</div>
</body>
</html>