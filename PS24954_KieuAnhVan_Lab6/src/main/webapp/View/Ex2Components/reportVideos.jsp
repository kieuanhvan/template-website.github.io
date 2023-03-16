<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
	<c:when test="${reportVideos != null }">
			<table class="table table-hover">
				<thead>
					<tr>
						<th scope="col">Title</th>
						<th scope="col">Likes</th>
						<th scope="col">New Date</th>
						<th scope="col">Old Date</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${reportVideos != null }">
							<c:forEach var="itemV" items="${reportVideos }">
									<tr>
										<th scope="row">${itemV.group}</th>
										<th>${itemV.likes}</th>
										<th>${itemV.newDate}</th>
										<th>${itemV.oldDate}</th>
									</tr>
							</c:forEach>
					</c:if>
				</tbody>
		</table>
	</c:when>
	<c:otherwise>
		<h3 class="text-center">${message }</h3>
	</c:otherwise>
</c:choose>