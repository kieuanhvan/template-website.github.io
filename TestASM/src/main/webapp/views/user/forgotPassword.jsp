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
    <title>forgot password</title>
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
                            <li class="breadcrumb-item"><a href="index.php"><i class="fa fa-home" aria-hidden="true"></i> Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Forgot Password</li>
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
                            <h4>Get password</h4>
                            <div class="line"></div>
                        </div>
					<h3 class="text-danger" id="message"></h3>
                        <form >
                            <div class="form-group">
                                <input type="text" name="username" class="form-control" id="exampleInputEmail1" placeholder="Your email">
                            </div>
                            <button type="button" onclick="getPassword(this)" class="btn vizew-btn w-100 mt-30">Send</button>
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
		<script type="text/javascript">
				function getPassword(me){
					 $.ajax({url: "forgot-password?email="+me.previousElementSibling.children[0].value, 
						 success: function(data,status,xhr){
						$("#message").text("success");m
					  },
					  error: function (jqXhr, textStatus, errorMessage) { 
						  $("#message").text("fail");
					    }
				 });
					 
					 
				}
		</script>
</body>

</html>