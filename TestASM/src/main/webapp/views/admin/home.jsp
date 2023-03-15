<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="/common/head_a.jsp"%>
</head>
<body>
	<c:url value="/admin" var="url"></c:url>
	<div id="main-wrapper">
		<!--         header -->
		<!--         nav -->
		<%@include file="/common/header_a.jsp"%>
		<div class="page-wrapper">
			<!-- ============================================================== -->
			<!-- Bread crumb and right sidebar toggle -->
			<!-- ============================================================== -->
			<div class="page-breadcrumb">
				<div class="row">
					<div class="col-12 d-flex no-block align-items-center">
						<h4 class="page-title">Quản lí tiểu phẩm</h4>
						<div class="ml-auto text-right">
							<nav aria-label="breadcrumb">
								<ol class="breadcrumb">
									<li class="breadcrumb-item"><a href="#">Home</a></li>
									<li class="breadcrumb-item active" aria-current="page">Library</li>
								</ol>
							</nav>
						</div>
					</div>
				</div>
			</div>
			<!-- ============================================================== -->
			<!-- End Bread crumb and right sidebar toggle -->
			<!-- ============================================================== -->
			<!-- ============================================================== -->
			<!-- Container fluid  -->
			<!-- ============================================================== -->
			<div class="container-fluid">
				<!-- ============================================================== -->
				<!-- Start Page Content -->
				<!-- ============================================================== -->
				<div class="row">
					<div class="col-md-6 ">
						<div class="card w-100">
							<form class="form-horizontal" id="formSkits" method="POST"
								action="${url }/video?action=add">
								<div class="card-body">
									<h4 class="card-title">Tiểu phẩm</h4>
									<div class="form-group row">
										<label for="fname"
											class="col-sm-3 text-right control-label col-form-label">Tiêu
											đề</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="fname"
												name="title" placeholder="First Name Here">
										</div>
									</div>
									<div class="form-group row">
										<label for="lname"
											class="col-sm-3 text-right control-label col-form-label">Link
											href </label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="lname"
												name="href" placeholder="Link Video"
												onchange="getPoster(this)"> <small
												class="text-danger text-uppercase font-weight-bold"
												id="msgHref"></small>
										</div>
									</div>
 										<input type="hidden"  name="currentHref" value="">
									<div class="form-group row">
										<label for="cono1"
											class="col-sm-3 text-right control-label col-form-label">Mô
											tả </label>
										<div class="col-sm-9">
											<textarea class="form-control" name="descriptions"></textarea>
										</div>
									</div>

								</div>
								<div class="border-top">
									<div class="card-body">
										<button id="btnAdd" type="button" class="btn btn-primary"
											onclick="addElement()">Add</button>
										<button type="button" class="btn btn-primary" onclick="deleteElement()">Delete</button>
										<button type="button" class="btn btn-primary"
											onclick="clearForm()">Clear Form</button>
									</div>
								</div>
							</form>
						</div>
					</div>
					<div class="col-md-6 ">
						<div class="w-100 ">
							<img class="img-fluid" style="width: 95%;" alt="Show poster"
								id="showPoster" src="">
						</div>
					</div>
					<div class="col-md-12">
						<div class="card">
							<div class="card-body">
								<h5 class="card-title m-b-0">Danh sách tiều phẩm</h5>
								<div class="table-responsive" id="tableInfo">
								
									<table id="zero_config"
										class="table  table-hover table-striped">
										<thead class="thead-dark">
											<tr>
												<th>id</th>
												<th>Title</th>
												<th>Href</th>
												<th>Descript</th>
												<th>Trạng thái</th>
											</tr>
										</thead>
										<tbody id="ssss">
											<c:forEach var="v" items="${videos }" varStatus="i">
												<tr  onclick="editItem(this)" style="cursor: pointer;">
													<td>${v.id }</td>
													<td>${v.title }</td>
													<td>${v.href }</td>
													<td>${v.descriptions }</td>
													<td>${v.isActive ?"Hoạt động":"Tạm ngưng" }</td>
												</tr>
											</c:forEach>

										</tbody>
									</table>
								</div>
							</div>
						</div>



					</div>
				</div>
			</div>
			<footer class="footer text-center">
				All Rights Reserved by Matrix-admin. Designed and Developed by <a
					href="https://wrappixel.com">WrapPixel</a>.
			</footer>

		</div>
	</div>

	<%@include file="/common/script_a.jsp"%>
	<script type="text/javascript">
	var isUpdata = false ;
   
function editItem(me){
	isUpdata = true;
	 var form  = document.getElementById("formSkits");
    	form.title.value = me.children[1].textContent;
    	form.href.value = me.children[2].textContent;
    	getPoster(form.href);
    	form.descriptions.value = me.children[3].textContent;
    	form.currentHref.value = me.children[2].textContent;
    	$("#btnAdd").text("Update");
}

function deleteElement(){
    $.ajax({
        type: "POST",
        url: "${url }/video?action=delete",
        data: $($( "#formSkits" )).serialize(),
        success: function(data) {
        	alert("Xóa thành công");
        	location.reload();
        },
        error: function (jqXhr, textStatus, errorMessage) { 
        	alert("Error");
    	}
    });
}
    function addElement(){
    	var url ="";
    	if(isUpdata){
    		url ="${url }/video?action=update"
    	}else{
    		url ="${url }/video?action=add"
    	}
		    $.ajax({
		        type: "POST",
		        url: url,
		        data: $($( "#formSkits" )).serialize(),
		        success: function(data) {
// 		        	$("#msgHref").text("");
// 		        	$('#zero_config').DataTable().clear().destroy();
// 			    	$('#zero_config').DataTable({
// 			          "aaData":data,
// 			          "columns":[ {"data" : "id"},
// 			        	{"data" : "title"}
// 			          ,
// 						{"data" : "href"}
// 			          ,
// 						{"data" : "descriptions"}
// 			          ]
// 			        });
		        	location.reload();
		        	if(isUpdata){
		        		alert("Update thành công");
		        	}else{
		        		alert("Đã thêm");
		        	}
		        },
		        error: function (jqXhr, textStatus, errorMessage) { 
		        	$("#msgHref").text("Link video đã tồn tại!");
		    	}
		    });
    	
    }
    		
    function clearForm(){
    	$("#btnAdd").text("ADD");
    	isUpdata = false;
    	var form  = document.getElementById("formSkits");
    	form.title.value =null;
    	form.href.value = null;
    	getPoster(form.href);
    	form.descriptions.value = null;
    
    }

    	function getPoster(me){
    		document.getElementById("showPoster").src = "https://img.youtube.com/vi/" + me.value+"/maxresdefault.jpg";
    	}
    </script>
</body>
</html>