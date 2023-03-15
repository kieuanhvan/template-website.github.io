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
<title>Từ khóa ${Title }</title>
<%@include file="/common/head.jsp"%>

</head>

<body>
	<%@include file="/common/header.jsp"%>

 <!-- ##### Breadcrumb Area Start ##### -->
    <div class="vizew-breadcrumb">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#"><i class="fa fa-home" aria-hidden="true"></i> Home</a></li>
                            <li class="breadcrumb-item"><a href="#">Feature</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Archive by Category MUSIC</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <!-- ##### Breadcrumb Area End ##### -->
    <!-- ##### Archive List Posts Area Start ##### -->
    <div class="vizew-archive-list-posts-area mb-80">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-12 col-lg-8">
					<div class="archive-catagory-view mb-50 d-flex align-items-center justify-content-between">
                        <!-- Catagory -->
                        <div class="archive-catagory">
                            <h4><i class="fa fa-music" aria-hidden="true"></i>Từ khóa "${Title }" </h4>
                        </div>
                    </div>
                    
    <c:choose>
    	<c:when test="${videos == null }">
	<div class="archive-catagory-view mb-50 d-flex align-items-center justify-content-between">
                        <!-- Catagory -->
                        <div class="archive-catagory">
                            <h4><i class="fa fa-music" aria-hidden="true"></i> "Không tìm thấy" </h4>
                        </div>
                    </div>
</c:when>
    	<c:otherwise>
    		<c:forEach var="v" items="${videos}" varStatus="loop">
										<!-- Single Post Area -->
				                    <div class="single-post-area style-2">
				                        <div class="row align-items-center">
				                            <div class="col-12 col-md-6">
				                                <!-- Post Thumbnail -->
				                                <div class="post-thumbnail">
				                                    
							 <a href="<c:url value='video?action=watch&id=${v.href }'/>" class="btn play-btn"><img src="${v.posters }" alt=""></a>
				                                    <!-- Video Duration -->
				<!--                                     <span class="video-duration">05.03</span> -->
				                                </div>
				                            </div>
				                            <div class="col-12 col-md-6">
				                                <!-- Post Content -->
				                                <div class="post-content mt-0">
				                                    <a href="#" class="post-cata cata-sm cata-success">Sports</a>
				                                    <a href="single-post.html" class="post-title mb-2">${v.title }</a>
				                                    <div class="post-meta d-flex align-items-center mb-2">
				                                        <a href="#" class="post-author">By Jane</a>
				                                        <i class="fa fa-circle" aria-hidden="true"></i>
				                                        <a href="#" class="post-date">Sep 08, 2018</a>
				                                    </div>
				                                    <p class="mb-2">${v.descriptions }</p>
				                       
				                                </div>
				                            </div>
				                        </div>
				                    </div>
                    </c:forEach>
    	</c:otherwise>
    </c:choose>
                    
                    <div class="archive-catagory-view mb-50 d-flex align-items-center justify-content-between">
                        <div class="archive-catagory">
                            <h4><i class="fa fa-music" aria-hidden="true"></i> "Có thể bạn thích" </h4>
                        </div>
                    </div>
                    
                    
                         <c:forEach var="v" items="${videosOther}" varStatus="loop">
										<!-- Single Post Area -->
				                    <div class="single-post-area style-2">
				                        <div class="row align-items-center">
				                            <div class="col-12 col-md-6">
				                                <!-- Post Thumbnail -->
				                                <div class="post-thumbnail">
				                                    
							 <a href="<c:url value='video?action=watch&id=${v.href }'/>" class="btn play-btn"><img src="${v.posters }" alt=""></a>
				                                    <!-- Video Duration -->
				<!--                                     <span class="video-duration">05.03</span> -->
				                                </div>
				                            </div>
				                            <div class="col-12 col-md-6">
				                                <!-- Post Content -->
				                                <div class="post-content mt-0">
				                                    <a href="#" class="post-cata cata-sm cata-success">Sports</a>
				                                    <a href="single-post.html" class="post-title mb-2">${v.title }</a>
				                                    <div class="post-meta d-flex align-items-center mb-2">
				                                        <a href="#" class="post-author">By Jane</a>
				                                        <i class="fa fa-circle" aria-hidden="true"></i>
				                                        <a href="#" class="post-date">Sep 08, 2018</a>
				                                    </div>
				                                    <p class="mb-2">${v.descriptions }</p>
				                       
				                                </div>
				                            </div>
				                        </div>
				                    </div>
                    </c:forEach>
                    
                    
                        </div>
                            </div>
                        </div>
                    </div>
	<!-- ##### Trending Posts Area End ##### -->
	<%@include file="/common/footer.jsp"%>
	<%@include file="/common/script.jsp"%>
</body>

</html>