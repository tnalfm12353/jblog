<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<% pageContext.setAttribute("newLine", "\n"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
</head>
<body>
	<div id="container">
		<c:set var="title" value="${map.blogInfo.title}" scope="request" />
		<c:set var="userId" value="${map.blogInfo.userId}" scope="request" />
		<c:import url="/WEB-INF/views/blog/include/header.jsp" />
		<div id="wrapper">
			<div id="content">
				<div class="blog-content">
					<c:choose>
						<c:when test="${map.post.title == null }">
							<h4>게시물이 존재 하지 않습니다.</h4>
							<p>
								게시글이 존재 하지 않습니다.
							</p>
						</c:when>
						<c:otherwise>
							<h4>${map.post.title }</h4>
							<p>
								${fn:replace(map.post.contents, newLine, "<br/>")}
							<p>
						</c:otherwise>
					</c:choose>
				</div>
				<ul class="blog-list">
					<c:forEach items="${map.postList }" var="post">
						<li><a href="${pageContext.request.contextPath }/${userId}/${post.categoryNo }/${post.no}">${post.title }</a> <span>${post.regDate }</span>	</li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div id="extra">
			<div class="blog-logo">
				<img src="${pageContext.request.contextPath}${map.blogInfo.logo}">
			</div>
		</div>

		<div id="navigation">
			<h2>카테고리</h2>
			<ul>
				<c:forEach items="${map.categoryList }" var="category">
					<li><a href="${pageContext.request.contextPath}/${map.blogInfo.userId}/${category.no}">${category.name }</a></li>
				</c:forEach>
			</ul>
		</div>
		<c:import url="/WEB-INF/views/blog/include/footer.jsp" />
	</div>
</body>
</html>