<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
	<c:when test="${status == false }">
	<br><br>
		<h2 class="text-center">${message}</h2>
	</c:when>
	<c:otherwise>
			<section class="vh-100" style="background-color: #f4f5f7;">
			                <div class="container py-5 h-100">
			                    <div class="row d-flex justify-content-center align-items-center h-100">
			                        <div class="col col-lg-10 mb-4 mb-lg-0">
			                            <div class="card w-50 m-auto" style="border-radius: 15px;">
			                                <div class="card-body p-4">
			                                    <div class="">
				                                       <div class="col-md-4 gradient-custom text-center text-white  m-auto"
					                                        style="border-top-left-radius: .5rem; border-bottom-left-radius: .5rem;">
						                                        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava1-bg.webp"
						                                            alt="Avatar" class="img-fluid my-5" style="width:100%" />
				                                    </div>
				                                    <div class="col-md-12 gradient-custom text-center text-white  m-auto">
				                                    			<h5 class="mb-1">Full Name: ${user.fullname}</h5>
				                                            <p class="mb-2 pb-1" style="color: #2b2a2a;">Email: ${user.email }</p>
				                                    </div>
			                                    </div>
			                                </div>
			                            </div>
			
											<br>
											
										<c:if test="${videos != null }">
					                            <div class="card mb-3" style="border-radius: .5rem;">
					                                <div class="row g-0">
					                                    <div class="col-md-12">
					                                        <div class="card-body p-4">
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
																              <c:forEach var="itemV" items="${videos }">
																              		<tr>
																                        <th scope="row">${itemV.id}</th>
																                         <th >${itemV.title}</th>
																                         <th >${itemV.views}</th>
																                         <th >${itemV.active}</th>
																                    </tr>
																              </c:forEach>
																                </tbody>
																          </table>
					                                        </div>
					                                    </div>
					                                </div>
					                            </div>
			                            </c:if>
			                            <c:if test="${videos == null }">
			                            	<h3 class="text-center">${message}</h3>
			                            </c:if>
			                        </div>
			                    </div>
			                </div>
			            </section>

	</c:otherwise>
</c:choose>

            