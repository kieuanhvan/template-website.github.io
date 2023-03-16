<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Exercises 2</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/Template/assets/MDB5-STANDARD-UI-KIT-Free-6.1.0/css/mdb.min.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/Template/assets/icofont/icofont/icofont.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<body>
	<jsp:include page="MyMenu.jsp"></jsp:include>
	<!-- Tabs navs -->
	<ul class="nav nav-tabs nav-fill mb-3" id="ex1" role="tablist">
		<li class="nav-item" role="presentation"><a
			class="nav-link active" id="ex2-tab-1" data-mdb-toggle="tab"
			href="#ex2-tabs-1" role="tab" aria-controls="ex2-tabs-1"
			aria-selected="true">1.Random 3 video</a></li>
		<li class="nav-item" role="presentation"><a class="nav-link"
			id="ex2-tab-2" data-mdb-toggle="tab" href="#ex2-tabs-2" role="tab"
			aria-controls="ex2-tabs-2" aria-selected="false">2.Filter videos by year</a></li>
	</ul>
	<!-- Tabs navs -->

	<!-- Tabs content -->
	<div class="tab-content" id="ex2-content">
		<div class="tab-pane fade show active" id="ex2-tabs-1" role="tabpanel"
			aria-labelledby="ex2-tab-1">
					<h3 class="text-center text-danger">Hiển thị ngẫu nhiên video</h3>

					<div class="input-group w-25 ms-3">
						<input type="number" id="form1" class="form-control"  placeholder="Nhập vào số lượng"/>
						<button type="button" class="btn btn-primary"
							onclick="SelectTopVideo(this)">
							<i class="fas fa-search"></i>
						</button>
					</div>
					
					<br>
					<div class="Result">
						
					</div>
		</div>
		<div class="tab-pane fade" id="ex2-tabs-2" role="tabpanel"
			aria-labelledby="ex2-tab-2">
			<br>
			<h3 class="text-center text-danger">Hiển thị video theo năm</h3>
			
			<div class="container-fluid h-100 bg-light">
					  <div class="row">
					    <div class="col-12 text-center align-items-center justify-content-center" style="overflow: hidden;">
					      <select class="my-select selectpicker btn btn-warning btn-rounded w-25" data-container="body" onchange="myFunction(this)">
					      <option value="null">Lựa chọn năm</option>
									  <option value="2023">2023</option>
									  <option value="2022">2022</option>
									  <option value="2021">2021</option>
									  <option value="2020">2020</option>
									  <option value="2019">2019</option>
							</select>
					    </div>
					  </div>
			</div>
			<br>
			<div class="Result">

			</div>
		</div>
	</div>
	<!-- Tabs content -->

	<script
		src="${pageContext.request.contextPath}/Template/assets/MDB5-STANDARD-UI-KIT-Free-6.1.0/js/mdb.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/Template/assets/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript">
	
	
	function myFunction(me){
		var result = me.parentElement.parentElement.parentElement.parentElement.children[4];
		$.get("Show-info-favourite-video-by-year?year=" + me.value, function(data, status) {
			result.innerHTML = data;
		});
	}
	
		function SelectTopVideo(me) {
			var result = me.parentElement.parentElement.children[3];
			var dataV = me.previousElementSibling.value;
			$.get("Show-Amount-Video?amount=" + dataV, function(data, status) {
				result.innerHTML = data;
			});
		}

		function FindVideosFavouriteOfUser(me) {
			var result = me.parentElement.parentElement.children[4];
			var dataV = me.previousElementSibling.value;
			$.get("VideoOfUser?data=" + dataV, function(data, status) {
				result.innerHTML = data;
			});
		}
		
	</script>
</body>
</html>