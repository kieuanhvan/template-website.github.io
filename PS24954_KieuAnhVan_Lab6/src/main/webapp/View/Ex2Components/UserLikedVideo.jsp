<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
	<c:when test="${users != null}">
				<table class="table align-middle mb-0 bg-white table-hover">
					  <thead class="bg-light">
					    <tr>
					      <th>ID</th>
					      <th>Fullname</th>
					      <th>Email</th>
					      <th>Role</th>
					    </tr>
					  </thead>
					  <tbody>
					  <c:forEach var="item" items="${users }">
					    <tr>
					      <td>
					        <div class="d-flex align-items-center">
					          <img
					              src="https://mdbootstrap.com/img/new/avatars/8.jpg"
					              alt=""
					              style="width: 45px; height: 45px"
					              class="rounded-circle"
					              />
					          <div class="ms-3">
					            <p class="fw-bold mb-1">${item.id }</p>
					          </div>
					        </div>
					      </td>
					      <td>
					        <p class="fw-normal mb-1">${item.fullname }</p>
					      </td>
					      <td>
					        ${item.email }
					      </td>
					      <td>
								${item.admin ? "Admin":"User" }
					      </td>
					    </tr>
					   </c:forEach>
					  </tbody>
				</table>
	</c:when>
	
	<c:otherwise>
		<h3>${message }</h3>
	</c:otherwise>
	
</c:choose>