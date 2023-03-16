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
			aria-selected="true">1.Find Favourite Video By Key</a></li>
		<li class="nav-item" role="presentation"><a class="nav-link"
			id="ex2-tab-2" data-mdb-toggle="tab" href="#ex2-tabs-2" role="tab"
			aria-controls="ex2-tabs-2" aria-selected="false">2.Find Video By User</a></li>
		<li class="nav-item" role="presentation"><a class="nav-link"
			id="ex2-tab-3" data-mdb-toggle="tab" href="#ex2-tabs-3" role="tab"
			aria-controls="ex2-tabs-3" aria-selected="false">3.Find Video By Date</a></li>
		<li class="nav-item" role="presentation"><a class="nav-link"
			id="ex2-tab-4" data-mdb-toggle="tab" href="#ex2-tabs-4" role="tab"
			aria-controls="ex2-tabs-4" aria-selected="false">4.Find Video By Month</a></li>
	</ul>
	<!-- Tabs navs -->

	<!-- Tabs content -->
	<div class="tab-content" id="ex2-content">
		<div class="tab-pane fade show active" id="ex2-tabs-1" role="tabpanel"
			aria-labelledby="ex2-tab-1">
					<h3 class="text-center text-danger">Tìm video yêu thích theo tên</h3>

					<div class="input-group w-25 ms-3">
						<input type="search" id="form1" class="form-control" />
						<button type="button" class="btn btn-primary"
							onclick="FindVideosByName(this)">
							<i class="fas fa-search"></i>
						</button>
					</div>
					
					<br>
					<div class="Result">
						<jsp:include page="Ex2Components/FavouritesVideo.jsp"></jsp:include>
					</div>
		</div>
		<div class="tab-pane fade" id="ex2-tabs-2" role="tabpanel"
			aria-labelledby="ex2-tab-2">
						<br>
			<h3 class="text-center text-danger">Tìm video yêy thích theo id
				User</h3>

			<div class="input-group w-25 ms-3">
				<input type="search" id="form1" class="form-control" />
				<button type="button" class="btn btn-primary"
					onclick="FindVideosFavouriteOfUser(this)">
					<i class="fas fa-search"></i>
				</button>
			</div>
			<br>
			<div class="Result">
				<jsp:include page="Ex2Components/VideosOfUser.jsp"></jsp:include>
			</div>
			

		</div>
		<div class="tab-pane fade" id="ex2-tabs-3" role="tabpanel"
			aria-labelledby="ex2-tab-3">
			
			
						<h3 class="text-center text-danger">Tìm video theo ngày</h3>
						<div class="input-group w-25 ms-3">
							<input type="text" id="form1" class="form-control w-25" placeholder="Bắt đầu"/>
							<span class="m-2">Đến</span>
							<input type="text" id="form2" class="form-control w-25" placeholder="Kết thúc"/>
							<button type="button" class="btn btn-primary"
								onclick="findVideoByDate(this)">
								<i class="fas fa-search"></i>
							</button>
						</div>
						
						<br>
						<div class="Result">
									<jsp:include page="Ex2Components/UserLikedVideo.jsp"></jsp:include>
						</div>

		</div>
		<div class="tab-pane fade" id="ex2-tabs-4" role="tabpanel"
			aria-labelledby="ex2-tab-4">
			
			<h3 class="text-center text-danger">Tìm kiếm video theo tháng</h3>
			
			
				<div class="card">
  					<div class="card-body">
						<form class="row"  id="myform">
								<div class="form-check form-switch col-md-2">
									  <input class="form-check-input" type="checkbox"  name="month" value="1">
									  <label class="form-check-label" >January</label>
								</div>
								
								<div class="form-check form-switch col-md-2">
									  <input class="form-check-input" type="checkbox"  name="month" value="2">
									  <label class="form-check-label" >February</label>
								</div>
								
								<div class="form-check form-switch col-md-2">
									  <input class="form-check-input" type="checkbox"  name="month" value="3">
									  <label class="form-check-label" >March</label>
								</div>
								
								<div class="form-check form-switch col-md-2">
									  <input class="form-check-input" type="checkbox"  name="month" value="4">
									  <label class="form-check-label" >April</label>
								</div>
								
								<div class="form-check form-switch col-md-2">
									  <input class="form-check-input" type="checkbox"  name="month" value="5">
									  <label class="form-check-label" >May</label>
								</div>
								
								<div class="form-check form-switch col-md-2">
									  <input class="form-check-input" type="checkbox"  name="month" value="6">
									  <label class="form-check-label" >June</label>
								</div>
								
								<div class="form-check form-switch col-md-2">
									  <input class="form-check-input" type="checkbox"  name="month" value="7">
									  <label class="form-check-label" >July</label>
								</div>
								
								<div class="form-check form-switch col-md-2">
									  <input class="form-check-input" type="checkbox"  name="month" value="8">
									  <label class="form-check-label" >August</label>
								</div>
								
								<div class="form-check form-switch col-md-2">
									  <input class="form-check-input" type="checkbox"  name="month" value="9">
									  <label class="form-check-label" >September</label>
								</div>
								
								<div class="form-check form-switch col-md-2">
									  <input class="form-check-input" type="checkbox"  name="month" value="10">
									  <label class="form-check-label" >October</label>
								</div>
								
								<div class="form-check form-switch col-md-2">
									  <input class="form-check-input" type="checkbox"  name="month" value="11">
									  <label class="form-check-label" >November</label>
								</div>
								
								<div class="form-check form-switch col-md-2">
									  <input class="form-check-input" type="checkbox"  name="month" value="12">
									  <label class="form-check-label" >December</label>
								</div><br><br>
								<button class="w-25 m-auto btn btn-success" >submit</button>
						</form>
					</div>
				</div>
				<br>
		
			<div class="Result" id="results">
					
			</div>
						
		</div>
	</div>
	<!-- Tabs content -->

	<script
		src="${pageContext.request.contextPath}/Template/assets/MDB5-STANDARD-UI-KIT-Free-6.1.0/js/mdb.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/Template/assets/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript">

	$(document).ready(function() {
		
		$( "#myform" ).on( "submit", function( event ) {
		    event.preventDefault();
		    $.ajax({
		        type: "POST",
		        url: "Find-favourite-video-by-month",
		        data: $(this).serialize(),
		        success: function(data) {
						document.getElementById("results").innerHTML  = data;
		        }
		    });

		});
	})
		
		
		function findVideoByDate(me){
			var result = me.parentElement.parentElement.children[3];
			var data1 = me.previousElementSibling.value;
			var data2 = me.previousElementSibling.previousElementSibling.previousElementSibling.value;

			 $.get("Find-favourite-video-by-date?min="+data2+"&max="+data1, function(data, status){
				  result.innerHTML = data;
			  });
		}
	
		function FindVideosByName(me) {
			var result = me.parentElement.parentElement.children[3];
			var dataV = me.previousElementSibling.value;
				  $.get("VideoByTitle?title="+dataV, function(data, status){
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