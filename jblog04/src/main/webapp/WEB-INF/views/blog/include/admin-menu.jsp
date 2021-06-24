<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<ul class="admin-menu">
	<li><a href="${pageContext.request.contextPath}/${authUser.id}/admin/basic" <c:if test="${element == 'basic' }"> style="color:black;" </c:if>>기본설정</a></li>
	<li><a href="${pageContext.request.contextPath}/${authUser.id}/admin/category" <c:if test="${element == 'category' }"> style="color:black;" </c:if>>카테고리</a></li>
	<li><a href="${pageContext.request.contextPath}/${authUser.id}/admin/write" <c:if test="${element == 'write' }"> style="color:black;" </c:if>>글작성</a></li>
</ul>