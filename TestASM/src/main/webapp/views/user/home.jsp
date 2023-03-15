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
      
           <!-- Top Header Area -->
        <div class="top-header-area" style="z-index:10000;">
            <div class="container">
                <div class="row align-items-center">
                    <div class=" col-md-12 " style="z-index:-1">
                        <!-- Breaking News Widget -->
                        <div class="breaking-news-area d-flex align-items-center mx-auto">
                            <div class="news-title">
                                <p>Thông báo: </p>
                            </div>
                            <div id="breakingNewsTicker" class="ticker">
                                <ul>
                                    <li><a href="#">10 Things Amazon Echo Can Do</a></li>
                                    <li><a href="#">Welcome to Colorlib Family.</a></li>
                                    <li><a href="#">Boys 'doing well' after Thai</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                  <!-- ##### Header Area End ##### -->
      <div class="col-12 col-md-12 "  >
              <br><br>
                       <div class="top-meta-data ">
                            <div class="  top-search-area dropdown mx-auto w-50 d-flex align-items-center justify-content-center" >
      
	                                    	<input class="col-md-9"   type="search" name="top-search" id="topSearch" 
	                                    placeholder="Search..." onchange="showResult(this)"  onfocus="showDropdown()" onblur="offDropdown()"
	                                    	
	                                    >
<!-- 	                                     oninput="showResult(this)"   onfocusin="showResult(this)"-->
	                                    <a class="col-md-3"  type="button"  class="btn"><i class="fa fa-search" aria-hidden="true" id="clickFind"></i></a>
	                                    
           
                                    <div class="dropdown-menu  w-75" aria-labelledby="dropdownMenuButton" id = "dropdownTitle">
											
									    </div>
									    
                            </div>
                        </div>
                        
                        
                    </div>
                </div>
            </div>
        </div>
        
       <!-- ##### Hero Area Start ##### -->
    <section class="hero--area section-padding-80">
        <div class="container">
            <div class="row no-gutters">
                <div class="col-12 col-md-7 col-lg-8">
                    <div class="tab-content">
                     
                        <c:forEach var="v" items="${videos}" varStatus="loop">
	                        <div class="tab-pane fade ${loop.index == 0 ? ' show active': '' }" id="post-${v.id }" role="tabpanel" aria-labelledby="post-${v.id }-tab">
	                            <!-- Single Feature Post -->
	                            <div class="single-feature-post video-post bg-img" 
	                            style="background-image: url(${v.posters }">
	                                <!-- Play Button -->
	                                <a href="<c:url value='video?action=watch&id=${v.href }'/>" class="btn play-btn"><i class="fa fa-play" aria-hidden="true"></i></a>
	
	                                <!-- Post Content -->
	                                <div class="post-content">
	                                    <a href="#" class="post-cata">Best Video</a>
	                                    <a href="<c:url value='video?action=watch&id=${v.href }'/>" class="post-title">${v.title }</a>
	                                    <div class="post-meta d-flex">
	                                        <a href="#"><i class="fa fa-comments-o" aria-hidden="true"></i> 25</a>
	                                        <a href="#"><i class="fa fa-eye" aria-hidden="true"></i> 25</a>
	                                        <a href="#"><i class="fa fa-thumbs-o-up" aria-hidden="true"></i> 25</a>
	                                    </div>
	                                </div>
	
	                                <!-- Video Duration -->
	                                <span class="video-duration">05.03</span>
	                            </div>
	                        </div>
                        </c:forEach>
                        
                        
                    </div>
                </div>

                <div class="col-12 col-md-5 col-lg-4">
                    <ul class="nav vizew-nav-tab" role="tablist">

						<c:forEach var="v" items="${videos}" >
			                        <li class="nav-item">
			                            <a class="nav-link" id="post-2-tab" data-toggle="pill" href="#post-${v.id }" role="tab" aria-controls="post-${v.id }" aria-selected="false">
			                                <!-- Single Blog Post -->
			                                <div class="single-blog-post style-2 d-flex align-items-center">
			                                    <div class="post-thumbnail">
			                                        <img src="${v.posters }" alt="">
			                                    </div>
			                                    <div class="post-content">
			                                        <h6 class="post-title">${v.title}</h6>
			                                        <div class="post-meta d-flex justify-content-between">
			                                            <span><i class="fa fa-comments-o" aria-hidden="true"></i> 14</span>
			                                            <span><i class="fa fa-eye" aria-hidden="true"></i> ${v.views }</span>
			                                            <span><i class="fa fa-thumbs-o-up" aria-hidden="true"></i> 84</span>
			                                        </div>
			                                    </div>
			                                </div>
			                            </a>
			                        </li>
						</c:forEach>
						
                    </ul>
                </div>
            </div>
        </div>
    </section>
    <!-- ##### Hero Area End ##### -->

     <!-- ##### Trending Posts Area Start ##### -->
        <div id="showProducts">
        	
        </div>
    <!-- ##### Trending Posts Area End ##### -->
     <!-- Pagination -->
                    <nav id="pagination" class="mt-50">
                        <ul class="pagination justify-content-center">
                            <button id="buttonPre" disabled class="page-link bg-dark" style="margin-right:4px"  onclick="pre()"><i class="fa fa-angle-left"></i></button>
                            <c:forEach varStatus="i" begin = "1" end="${maxPage }">
	                            <li class="page-item ${i.index  == 1? 'active' : ''}" id="li${i.index }"><a class="page-link" onclick="getVideoPageId(this , '${i.index }')">${i.index }</a></li>
                            </c:forEach>
                            <button id="buttonNext" class="page-link bg-dark" onclick="next()"><i class="fa fa-angle-right"></i></button>
                        </ul>
                    </nav>
                    <br>

      	<%@include file="/common/footer.jsp" %>
		<%@include file="/common/script.jsp" %>
			<script>
			  $("#clickFind").click(function(){
// 				  let res = $("#topSearch").val().replace(/ /g, "_");
				  
			        window.location.href = "findVideos?title="+ $("#topSearch").val();
			    });
			  
    		function addTitleToInputs(me){
    			document.getElementById("topSearch").value = me.textContent;
    		}
//     		topSearch
    		</script>
    		
		<script type="text/javascript">
		function offDropdown(){
			setTimeout(function () {$("#dropdownTitle").removeClass(" show")}, 1000);
			
		}
		function showDropdown(){
			
			$("#dropdownTitle").addClass(" show");
		}
		function showResult(me){

			setTimeout(function(){
				 $.ajax({
				        type: "GET",
				        url: "findVideos?q="+me.value+"&state=open",
				   	 		success: function(data,status,xhr){
								document.getElementById("dropdownTitle").innerHTML = data;
						 	 },
						  	error: function (jqXhr, textStatus, errorMessage) { 
							 console.log("error");
						    }
				    });
			}, 10);
			
		}
		
		
		function next(){
			if( parseInt($('#currentPageId').val()) < parseInt('${maxPage }') ){
	 			getVideoPageId(null,parseInt($('#currentPageId').val())+ 1);
	 			$('li').removeClass("active");
			}else{
				$("#buttonNext").attr('disabled', 'disabled');
			}

			 
		}
		
		function pre(){
			$("#buttonNext").removeAttr('disabled');
			$('li').removeClass("active");
			getVideoPageId(null,parseInt($('#currentPageId').val() )-1);
		}
		
		function getVideoPageId(me , idPage){
			  $(' #pagination ul li').click(function(){
				    $('li').removeClass("active");
				    $(this).addClass("active");
				});
			
			 $.ajax({url: "get-video-pageId?pageId="+idPage, 
				 success: function(data,status,xhr){
				document.getElementById("showProducts").innerHTML = data;
				if(parseInt($('#currentPageId').val() ) > 1){
					$("#buttonPre").removeAttr('disabled');
				}else{
					$("#buttonPre").attr('disabled', 'disabled');
				}
				if( parseInt($('#currentPageId').val()) < parseInt('${maxPage }') ){
					$("#buttonNext").removeAttr('disabled');
				}
				$("#li"+parseInt($('#currentPageId').val())).addClass("active");
				
			  },
			  error: function (jqXhr, textStatus, errorMessage) { 
			        alert("error");
			    }
		 });
		}
		
		 $.ajax({url: "get-video-pageId?pageId=1", 
			 success: function(data,status,xhr){
			document.getElementById("showProducts").innerHTML = data;
		  },
		  error: function (jqXhr, textStatus, errorMessage) { 
		        alert("error");
		    }
	 });
		</script>
</body>

</html>