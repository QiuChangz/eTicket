<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="base/title.jsp"%>

<body style="background-color: #9fcdff">

<%@include file="base/headerBeforeLogin.jsp"%>

<div class="container" display="block">
    <div class="row col-md-12" content=""></div>
    <div class="row col-md-4">
        <img src="img/movie.jpg" height="50%" width="75%">
    </div>
    <div class="row col-md-4"content=""></div>
    <div class="row col-md-4">
        <div>
            <form method="post" action="signUp" class="form-group">
                <label for="name"> Name:</label>
                <br/>
                <input type="text" id="name" name="name" size="20px" class="form-control" autocomplete="off">
                <br/>
                <label for="email"> Email:</label>
                <br/>
                    <input type="text" id="email" name="email" size="20px" class="form-control" autocomplete="off">
                <br/>
                <label for="password">Password:</label>
                <br/>
                    <input type="password" id="password" name="password" size="20px" class="form-control" autocomplete="off">
                <br/>
                <label for="birthday">Birthday:</label>
                <br/>
                    <input id="birthday" type="date" name="birthday" class="form-control">
                <div class="radio">
                    <div class="radio">
                        <label><input type="radio" name="identity" id="generalUser" value="普通用户" checked>普通用户</label>
                    </div>
                    <div class="radio">
                        <label><input type="radio" name="identity" value="商店经理" id="manager">商店经理</label>
                    </div>
                </div>
                <div>
                    <input type="submit" value="SignUp" class="form-control">
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
