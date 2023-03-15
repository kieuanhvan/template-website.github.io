<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- <!-- Preloader --> 
<!--     <div class="preloader d-flex align-items-center justify-content-center"> -->
<!--         <div class="lds-ellipsis"> -->
<!--             <div></div> -->
<!--             <div></div> -->
<!--             <div></div> -->
<!--             <div></div> -->
<!--         </div> -->
<!--     </div> -->

    <!-- ##### Header Area Start ##### -->
    <header class="header-area"  style="z-index:100000;">
      

        <!-- Navbar Area -->
        <div class="vizew-main-menu" id="sticker" >
            <div class="classy-nav-container breakpoint-off">
                <div class="container">

                    <!-- Menu -->
                    <nav class="classy-navbar justify-content-between" id="vizewNav">

                        <!-- Nav brand -->
                        <a href="index.php" class="nav-brand"><img src="${pageContext.request.contextPath}/templates/users/img/core-img/logo.png" alt=""></a>

                        <!-- Navbar Toggler -->
                        <div class="classy-navbar-toggler">
                            <span class="navbarToggler"><span></span><span></span><span></span></span>
                        </div>

                        <div class="classy-menu">

                            <!-- Close Button -->
                            <div class="classycloseIcon">
                                <div class="cross-wrap"><span class="top"></span><span class="bottom"></span></div>
                            </div>

                            <!-- Nav Start -->
                            <div class="classynav">
                            
                                <ul>
                                    <li class="${home != null ? 'active' :'' }"><a href="index.php">Home</a></li>
                                    <c:choose>
                                    	<c:when test="${not empty sessionScope.currentUser }">
			                                    <li><a href="#">Library</a>
			                                        <ul class="dropdown">
			                                            <li><a href="<c:url value='history'/>">- History</a></li>
			                                            <li><a href="favourite">- Favourites</a></li>
			                                            <li><a href="favourite" data-toggle="modal" data-target="#ModalLoginForm">- Change password</a></li>
			                                        </ul>
			                                    </li>
											 <li><a href="#">
													<i   class="fa fa-user" aria-hidden="true">  
					                            			${sessionScope.currentUser.username}</i>
											</a>
		                                        <ul class="dropdown">
		                                            <li><a href="logout">- Log out</a></li>
		                                            <li><a href="edit-profile">- Update profile</a></li>
		                                        </ul>
	                                    </li>
	                                    
                                    	</c:when>
                                    	<c:otherwise>
                                    	 <li><a href="#">
													<i   class="fa fa-user" aria-hidden="true">  
					                            			${sessionScope.currentUser.username == null? "Tài khoản":sessionScope.currentUser.username}</i>
											</a>
		                                        <ul class="dropdown">
		                                            <li><a href="LoginCtrl">- Login</a></li>
		                                            <li><a href="register">- Register</a></li>
		                                        </ul>
	                                    </li>

							
                                    	</c:otherwise>
                                    </c:choose>
                                </ul>
                                
                            </div>
                            <!-- Nav End -->
                        </div>
                    </nav>
                </div>
            </div>
        </div>
    </header><br/>
    
    
                    
                    
                    
    <!-- Modal HTML Markup -->
<div id="ModalLoginForm" class="modal fade">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title">Update password</h1>
            </div>
            <div class="modal-body">
            
                <form role="form" id="changeform">
                    <input type="hidden" name="_token" value="">
                    <div class="form-group">
                        <label class="control-label text-dark font-weight-bold">New Password</label>
                        <div>
                            <input type="password" class="form-control input-lg bg-light text-dark " name="currentPassword">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label text-dark font-weight-bold">Confirm Password</label>
                        <div>
                            <input type="password" class="form-control input-lg bg-light text-dark " name="newPassword">
                        </div>
                    </div>
                    <div class="form-group">
                        <div>
                            <button type="submit"  class="btn btn-success">
                                Update password
                            </button>
                        </div>
                    </div>
                    
                </form>
                <h4 id="message" class="text-dark font-weight-bold"></h4>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
    <script src="<c:url value='/templates/users/js/jquery/jquery-2.2.4.min.js'/>"></script>
	<script type="text/javascript">

	
	$(document).ready(function() {
		$( "#changeform" ).on( "submit", function( event ) {
		    event.preventDefault();
		    $.ajax({
		        type: "POST",
		        url: "changePassword",
		        data: $(this).serialize(),
		   	 		success: function(data,status,xhr){
					$("#message").text("success");
				 	 },
				  	error: function (jqXhr, textStatus, errorMessage) { 
					  $("#message").text("fail");
				    }
				  
		    });

		});
	})
	
	
		
		</script>
		
		

