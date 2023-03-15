<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Vizew - Blog &amp; Magazine HTML Template</title>
    <%@include file="/common/head.jsp" %>

</head>

<body>
      <%@include file="/common/header.jsp" %>
      
      <!-- ##### Breadcrumb Area Start ##### -->
    <div class="vizew-breadcrumb">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#"><i class="fa fa-home" aria-hidden="true"></i> Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Login</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <!-- ##### Breadcrumb Area End ##### -->

    <!-- ##### Login Area Start ##### -->
    <div class="vizew-login-area section-padding-80">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-12 col-md-6">
                    <div class="login-content">
                        <!-- Section Title -->
                        <div class="section-heading">
                            <h4>Đăng kí</h4>
                            <div class="line"></div>
                        </div>
					<h3 class="text-danger">${message }</h3>
                        <form action="register" method="post">
                            <div class="form-group">
                                <input type="text" name="username" class="form-control" id="exampleInputEmail1" placeholder="User Name">
                            </div>
                            <div class="form-group">
                                <input type="email" name="email"  class="form-control" placeholder="Email">
                            </div>
                            <div class="form-group">
                                <input type="password" name="password"  class="form-control"  placeholder="Password">
                            </div>
                            <div class="form-group">
                                <input type="password" name="confirmPassword"  class="form-control"  placeholder="confirmPassword">
                            </div>
                            
                            <button type="submit" class="btn vizew-btn w-100 mt-30">Dang ki</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- ##### Login Area End ##### -->
    <!-- ##### Trending Posts Area End ##### -->
      	<%@include file="/common/footer.jsp" %>
		<%@include file="/common/script.jsp" %>
</body>

</html>