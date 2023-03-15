<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!-- ##### Trending Posts Area Start ##### -->
    <section class="trending-posts-area">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <!-- Section Heading -->
                    <div class="section-heading">
                        <h4>Trending Videos</h4>
                        <div class="line"></div>
                    </div>
                </div>
            </div>
		<h5>Trang ${currentPageId }</h5>
		 <input type="hidden" id="currentPageId" name="custId" value="${currentPageId }">
            <div class="row">
            		<c:forEach var="v" items="${videos}" >
            	
			                <!-- Single Blog Post -->
			                <div class="col-12 col-md-4">
			                    <div class="single-post-area mb-80">
			                        <!-- Post Thumbnail -->
			                        <div class="post-thumbnail">
			                            
							 <a href="<c:url value='video?action=watch&id=${v.href }'/>" class="btn play-btn"><img src="${v.posters }" alt=""></a>
			                            <!-- Video Duration -->
			                            <span class="video-duration">05.03</span>
			                        </div>
			
			                        <!-- Post Content -->
			                        <div class="post-content">
			                            <a href="#" class="post-cata cata-sm cata-success">BestVideo</a>
			                            <a href="single-post.html" class="post-title">${v.title }</a>
			                            <div class="post-meta d-flex">
			                                <a href="#"><i class="fa fa-comments-o" aria-hidden="true"></i> 22</a>
			                                <a href="#"><i class="fa fa-eye" aria-hidden="true"></i> 16</a>
			                                <a href="#"><i class="fa fa-thumbs-o-up" aria-hidden="true"></i> 15</a>
			                            </div>
			                        </div>
			                    </div>
			                </div>
                </c:forEach>
            </div>

        </div>
    </section>
        <!-- ##### Trending Posts Area End ##### -->