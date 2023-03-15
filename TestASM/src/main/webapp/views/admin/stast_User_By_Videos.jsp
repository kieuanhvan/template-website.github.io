<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <%@include file="/common/head_a.jsp" %>
</head>
<body  >

    <div id="main-wrapper">
<!--         header -->
<!--         nav -->
     <%@include file="/common/header_a.jsp" %>
        <div class="page-wrapper">
            <!-- ============================================================== -->
            <!-- Bread crumb and right sidebar toggle -->
            <!-- ============================================================== -->
            <div class="page-breadcrumb">
                <div class="row">
                    <div class="col-12 d-flex no-block align-items-center">
                        <h4 class="page-title">Tables</h4>
                        <c:url value="/admin" var="url"/>
                        <a href="${url }/get-user-video-liked-href?href=CihmFK_vg_I">cccc</a>
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
            
            
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12">
                        
                        
                        
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Lọc Người dùng theo tiểu phẩm</h5>
                                <div class="table-responsive">
                                    <select class="select2 form-control custom-select" style="width: 25%; height:36px;" onchange="getUserByVideo(this)">
                                            <option>Select</option>
                                            <optgroup label="Tên tiểu phẩm">
                                            <c:forEach var="v" items="${ videoLikeds }">
                                                <option value="${v.href }">${v.title}</option>
                                              </c:forEach>
                                            </optgroup>
                                        </select>
                                    <table id="zero_config" class="table table-striped table-bordered">
                                        <thead>
                                            <tr>
                                                <th>User name</th>
                                                <th>Email</th>
                                            </tr>
                                        </thead>
                                        <tbody id="tableData">
                                        </tbody>
                                    </table>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <footer class="footer text-center">
                All Rights Reserved by Matrix-admin. Designed and Developed by <a href="https://wrappixel.com">WrapPixel</a>.
            </footer>
        </div>
    </div>
    <%@include file="/common/script_a.jsp" %>
    <script type="text/javascript">
    	function getUserByVideo(me){
        	$.ajax({url: '${url}' +"/get-user-video-liked-href?href="+me.value, 
        		dataType: 'json',
    			 success: function(data,status,xhr){
    					$('#zero_config').DataTable().clear().destroy();
    			    	$('#zero_config').DataTable({
    			          "aaData":data,
    			          "columns":[ {"data" : "username"},
    			        	  						{"data" : "email"} ]
    			        });
    		  	},
    		  	error: function (jqXhr, textStatus, errorMessage) { 
    		        	alert("error");
    		    	}
    	 });
    }
    </script>
</body>
</html>









