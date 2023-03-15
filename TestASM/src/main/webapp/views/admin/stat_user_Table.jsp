<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table id="zero_config"
										class="table  table-hover table-striped">
										<thead class="thead-dark">
											<tr>
												<th>id</th>
												<th>Title</th>
												<th>Href</th>
												<th>Descript</th>
											</tr>
										</thead>
										<tbody id="ssss">
											<c:forEach var="v" items="${videos }" varStatus="i">
												<tr  style="cursor: pointer;">
													<td>${v.id }</td>
													<td>${v.title }</td>
													<td>${v.href }</td>
													<td>${v.descriptions }</td>
												</tr>
											</c:forEach>

										</tbody>
									</table>