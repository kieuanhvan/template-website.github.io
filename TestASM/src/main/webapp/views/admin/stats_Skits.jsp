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
                                <h5 class="card-title">Lượt like của các tiểu phẩm</h5>
                                <div class="table-responsive">
                                    <table id="zero_config" class="table table-striped table-bordered">
                                        <thead>
                                            <tr>
                                                <th>Title</th>
                                                <th>Link</th>
                                                <th>Like</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                       <c:forEach var="v" items="${ videoLikeds }">
                                            <tr>
                                                <td>${v.title }</td>
                                                <td>${v.href }</td>
                                                <td>${v.totalLike }</td>
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
                All Rights Reserved by Matrix-admin. Designed and Developed by <a href="https://wrappixel.com">WrapPixel</a>.
            </footer>
        </div>
    </div>
    <%@include file="/common/script_a.jsp" %>
</body>
</html>