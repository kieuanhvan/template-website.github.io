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
			aria-selected="true">1.Videos Of User</a></li>
		<li class="nav-item" role="presentation"><a class="nav-link"
			id="ex2-tab-2" data-mdb-toggle="tab" href="#ex2-tabs-2" role="tab"
			aria-controls="ex2-tabs-2" aria-selected="false">2.Find Video</a></li>
		<li class="nav-item" role="presentation"><a class="nav-link"
			id="ex2-tab-3" data-mdb-toggle="tab" href="#ex2-tabs-3" role="tab"
			aria-controls="ex2-tabs-3" aria-selected="false">3.Find Users By
				Video</a></li>
		<li class="nav-item" role="presentation"><a class="nav-link"
			id="ex2-tab-4" data-mdb-toggle="tab" href="#ex2-tabs-4" role="tab"
			aria-controls="ex2-tabs-4" aria-selected="false">4.Show All
				Videos</a></li>
		<li class="nav-item" role="presentation"><a class="nav-link"
			id="ex2-tab-5" data-mdb-toggle="tab" href="#ex2-tabs-5" role="tab"
			aria-controls="ex2-tabs-5" aria-selected="false">5.Report</a></li>
	</ul>
	<!-- Tabs navs -->

	<!-- Tabs content -->
	<div class="tab-content" id="ex2-content">
		<div class="tab-pane fade show active" id="ex2-tabs-1" role="tabpanel"
			aria-labelledby="ex2-tab-1">
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
		<div class="tab-pane fade" id="ex2-tabs-2" role="tabpanel"
			aria-labelledby="ex2-tab-2">
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
		<div class="tab-pane fade" id="ex2-tabs-3" role="tabpanel"
			aria-labelledby="ex2-tab-3">
						<h3 class="text-center text-danger">Tìm User Đã like video theo id</h3>
						<div class="input-group w-25 ms-3">
							<input type="search" id="form1" class="form-control" />
							<button type="button" class="btn btn-primary"
								onclick="FindUserLikedVideoByVideoId(this)">
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
			
			<h3 class="text-center text-danger">Phân loại video</h3>
			
			
				<div class="border w-25">
						<div class="form-check form-check-inline">
						  <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" onchange="handleChange1(this);" value="true" />
						  <label class="form-check-label" for="inlineRadio1">Favourite</label>
						</div>
						
						<div class="form-check form-check-inline">
							  <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" onchange="handleChange1(this);" value="false" />
							  <label class="form-check-label" for="inlineRadio2">Not Favourite</label>
						</div>
				</div>
		
			<div class="Result">
					
			</div>
						
		</div>
		<div class="tab-pane fade" id="ex2-tabs-5" role="tabpanel"
			aria-labelledby="ex2-tab-5">

			</div>
	</div>
	<!-- Tabs content -->

	<script
		src="${pageContext.request.contextPath}/Template/assets/MDB5-STANDARD-UI-KIT-Free-6.1.0/js/mdb.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/Template/assets/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript">
	getReport();
	function getReport(){
		 $.get("get-report-videos", function(data, status){
			 document.getElementById("ex2-tabs-5").innerHTML = data;
		  });
	}
		function handleChange1(me){
			var result = me.parentElement.parentElement.parentElement.children[2];
			 $.get("FindVideosIsLike?status="+me.value, function(data, status){
				  result.innerHTML = data;
			  });
		}
		
		
		
		function FindUserLikedVideoByVideoId(me){
			var result = me.parentElement.parentElement.children[3];
			var dataV = me.previousElementSibling.value;
			 $.get("FindUserLikedVideoByVideoId?id="+dataV, function(data, status){
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