<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Vizew - Blog &amp; Magazine HTML Template</title>
<%@include file="/common/head.jsp"%>

</head>

<body>
	<%@include file="/common/header.jsp"%>
	<div class="vizew-breadcrumb">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="#"><i
									class="fa fa-home" aria-hidden="true"></i> Home</a></li>
							<li class="breadcrumb-item"><a href="#">Feature</a></li>
							<li class="breadcrumb-item active" aria-current="page">Archive
								by Category MUSIC</li>
						</ol>
					</nav>
				</div>
			</div>
		</div>
	</div>
<section class="h-100 gradient-custom-2">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col col-lg-9 col-xl-7">
        <div class="card"><br>
						<form action="" id="formUpload"  enctype="multipart/form-data">
							<div class="rounded-top text-white d-flex flex-row"
								style="background-color: #000; height: 200px; margin: 10px;">
								<div class="ms-4 mt-5 d-flex flex-column" style="width: 150px;">


									<img
										src="https://firebasestorage.googleapis.com/v0/b/travel-371117.appspot.com/o/images%2FgirlImage.png?alt=media&token=f216500b-d7a0-4788-9654-cf5aeaef6825"
										alt="Generic placeholder image"
										class="img-fluid img-thumbnail mt-4 mb-2"
										style="width: 150px; z-index: 1" id="myimage"
										class="img-fluid">

									<button type="button" class="border-0" style="z-index: 1;">
										<input id="fileUser" style="width: 80%;" type="file"
											class="btn btn-outline-dark" onchange="loadImage(event)" name="image"/>
									</button>



								</div>
								<div class="ms-3" style="margin-top: 130px; margin-left: 10px;">
									<h5>${sessionScope.currentUser.username}</h5>
									<p>New York</p>
								</div>
							</div>
							<div class="p-4 text-black" style="background-color: #f8f9fa;">

							</div>
							<div class="card-body p-4 text-black">
								<div class="mb-5">
									<p class="lead fw-normal mb-1">About</p>

									<div class="p-4" style="background-color: #f8f9fa;">
						
											<div class="form-group">
												<label for="exampleInputEmail1">Update email</label> <input
													type="email" class="form-control" id="exampleInputEmail1"
													aria-describedby="emailHelp" placeholder="Enter your email" name="email">
											</div>
								
									</div>

								</div>
								<div class="d-flex justify-content-between align-items-end mb-4">
									<p class="lead fw-normal mb-0"></p>
									<p class="mb-0">
										<button type="submit" class="btn btn-success"
											>Cập nhật</button>
									</p>
								</div>
							</div>
						</form>
					</div>
      </div>
    </div>
  </div>
</section>


	<%@include file="/common/footer.jsp"%>
	<%@include file="/common/script.jsp"%>
</body>
<script type="text/javascript">

$(document).ready(function() {
	
	$( "#formUpload" ).on( "submit", function( event ) {
	    event.preventDefault();

	    $.ajax({
	        type: "POST",
	        url: "update-your-profile",
	        data: new FormData(this),
	        success: function(data) {
					console.log("success");
	        },
	        error:function(error){
	        	console.log("error");
	        }
	    });

	});
})



	function loadImage(e){
		var selectedFile = event.target.files[0];
		  var reader = new FileReader();
		  var imgtag = document.getElementById("myimage");
		  imgtag.title = selectedFile.name;
		  
		  reader.onload = function(event) {
			    imgtag.src = event.target.result;
			  };
			  reader.readAsDataURL(selectedFile);
	}
</script>
</html>