<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:choose>
    	<c:when test="${videosTitle != null }">
    	<c:forEach var="e" items="${videosTitle }">
    	<a class="dropdown-item" style="overflow:hidden;" onclick="addTitleToInputs(this)">${e}</a>
    	</c:forEach>
    	
    	</c:when>
    </c:choose>
