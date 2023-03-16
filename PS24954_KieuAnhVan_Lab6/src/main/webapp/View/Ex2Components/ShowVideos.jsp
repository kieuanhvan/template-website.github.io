<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
	<c:when test="${videos != null }">
			<table class="table table-hover">
						<thead>
							<tr>
								<th scope="col">ID</th>
								<th scope="col">Title</th>
								<th scope="col">Views</th>
								<th scope="col">Acvite</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${videos != null }">
									<c:forEach var="itemV" items="${videos }">
											<tr>
												<th scope="row">${itemV.id}</th>
												<th>${itemV.title}</th>
												<th>${itemV.views}</th>
												<th>${itemV.active}</th>
											</tr>
									</c:forEach>
							</c:if>
						</tbody>
		</table>
	</c:when>
	<c:otherwise>
		<h3>${message}</h3>
	</c:otherwise>
</c:choose>