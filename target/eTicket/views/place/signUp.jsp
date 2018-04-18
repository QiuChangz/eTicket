<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../base/title.jsp"%>

<body style="background-color: #9fcdff">

<%@include file="../base/headerBeforeLogin.jsp"%>

<div class="container" display="block">
    <div class="row col-md-12" content=""></div>
    <div class="row col-md-4"content=""></div>
    <div class="row col-md-4">
        <div>
            <form method="post" action="signUp" class="form-group">
                <label for="name"> Name:</label>
                <br/>
                <input type="text" id="name" name="name" size="20px" class="form-control" autocomplete="off">
                <br/>
                <label for="seats">Seats:</label>
                <br/>
                <input type="text" id="seats" name="seats" size="20px" class="form-control" autocomplete="off">
                <div>
                    <input type="submit" value="SignUp" class="form-control">
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
