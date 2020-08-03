<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Blog Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
         <style>
            .topbar{
                height: 100px;
                width: 100%;
                font-weight: 300;
                background-color: blueviolet;
            }
            .topbar > h1{
                text-align: center;
                color: aliceblue;
                font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
                font-size: xx-large;
                font-weight: 900;
            }
    
            .menu{
                position: relative;
                left: 350px
            }
            .menu > li{
                display: inline;
                color: cornsilk;
                font-size: 25px;
                padding-left: 30px;
                padding-right: 30px;
            }
            </style>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
              <div class="col-12">

				 <!--top bar-->
                <div class="row">
                    <div class="col-12">
                        <div class="topbar">
                            <h1>Tour Blogs</h1>
                            <ul class="menu">
                            	<li><a style ="color: white"  href="myblogs">${sessionScope.blogger.name}</a></li>
                                <li><a style ="color: white"  href="myblogs"> My Blogs</a></li>
                                <li><a style ="color: white"  href="blogs">Blogs</a></li>
                                <li><a style ="color: white"  href="logout">Log Out</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!--Post blogs-->
                <div class="row">
                    <div class="col-2">
                    </div>
                    <div class="col-8">
                    <form action="post" method="post">
                    	<label for="uname">title</label>
                        <input type="text" name="title" class="form-control" id="uname" placeholder="">
                        <label for="comment">blog</label>
                        <textarea name = "blog" class="form-control" rows="2" ></textarea>
                        <div>
                            <button type="submit" class="btn btn-primary">Post</button>
                        </div>
                    </form>
                        </div>
                        <div class="col-2">
                    </div>   
                    </div>
                    
         
               
                
               
   					<!--blogs-->
   					<c:forEach items="${blogs}" var="blog">
   					
                <div class="row" style="margin-top: 50px">
                    <div class="col-3">
                    </div>
                    <div class="col-6">
                        <div style="display: block;">
                            <h2 style=" font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;"><c:out value="${blog.blogger.name}"></c:out></h2>
                         </div>
                         <div style="display: block;">
                         	<h3 style="font-weight: 800; font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;"> <c:out value="${blog.title}"></c:out> </h3>
                         </div>   
                        
                       <div style="display: block;">
                            <p style=" font-size: x-large;" style="font-size: x-large;"><c:out value="${blog.blog}"></c:out></p>
                        </div>
                        <button type="submit" class="btn btn-alert" style="float: right">delete</button>
                    </div>
                    <div class="col-3">
                    </div>
                </div>
               
               
				<!--comment box
                <div class="row">
                    <div class="col-4">
                    </div>
                    <div class="col-5">
                        <div class="form-group">
                        <form action = "comment" method = "post">
                        	<input type="hidden" name ="blogger_id" value = "${sessionScope.blogger.id}" >
                        	<input type="hidden" name ="blog_id" value = "${blog.id}" >
                        	<textarea name = "comment" class="form-control" rows="1" id="comment" placeholder="comment here ..."></textarea>
                            <button type="submit" class="btn btn-success">post</button>
                            
                        </form>
                          </div> 
                    </div>
                    <div class="col-3">
                    </div>
                </div> -->

                <!--Comment section-->
                <c:forEach items="${blog.comments}" var="comment">
                	 <div class="row">
                    <div class="col-4">
                    </div>
                    <div class="col-5">
                        <h4 style="float: left;"><c:out value="${comment.blogger.name}"></c:out></h3><p style="float: left; font-size: large;margin-left: 10px;"><c:out value="${comment.comment}"></c:out> </p>
						<form action="deleteComment" method = "post">
							<input type="hidden" name = "comment_id" value ="${comment.id}" >
							<button type="submit" class="btn btn-alert" style="float: right">delete</button>
						</form>
                    </div>
                    <div class="col-3">
                    </div>
                </div>
                </c:forEach>
               
                
                
 </c:forEach>

              </div>
            </div>  
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    </body>
</html>