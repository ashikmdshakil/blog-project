<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
    
<!DOCTYPE html>
<html>
    <head>
        <title>TourBlogs</title>
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
                margin-left: 450px;
            }
            .menu > li{
                display: inline;
                color: cornsilk;
                font-size: 25px;
                padding-left: 30px;
                padding-right: 30px;
            }
            .info{
                height: 400px;
                width: 550px;
                background-color: peru;
                margin-top: 50px;
                margin-left: 50px;
            }
            .info > h1{
                color: seashell;
                font-size: xx-large;
                font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
                text-align: center;
            }
            form > p{
                font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
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
                        </div>
                    </div>
                </div>

<!--signup and login-->
                <div class="row">
                    <div class="col-12">
                      <!--top bar-->
                      <div class="row"> 
                        <div class="col-6">
                              <div class="info">
                                  <h1>Sign Up</h1>
                                <form action="signup" method="post" style="margin-left: 150px; position: relative; top: 30px;">
                                    <p>Give email adress</p>
                                    <input type="email" name="mail">
                                    <p>Give user name</p>
                                    <input type="text" name="name">
                                    <p>Give user password</p>
                                    <input type="password" name="password"><br>
                                    <input type="submit" value="Sign Up" style="position: relative; top: 20px;left: 50px;">
                                </form>
                              </div>
                        </div>
                        <div class="col-6">
                            <div class="info">
                                <h1>Log In</h1>
                                <form action="login" method = "post" style="margin-left: 150px; position: relative; top: 30px;">
                                    <p>Give email adress</p>
                                    <input type="email" name="mail">
                                    <p>Give user password</p>
                                    <input type="password" name="password"><br>
                                    <input type="submit" value="Log In" style="position: relative; top: 20px;left: 50px;">
                                </form>

                            </div>
                        </div>
                      </div>




               </div>
            </div>   
        </div>    
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    </body>
</html>