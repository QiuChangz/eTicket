<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="base/title.jsp"%>

<body style="background-color: #9fcdff">

    <%@include file="base/headerBeforeLogin.jsp"%>

    <div class="container">
        <div class="row col-md-4">
            <img src="img/movie.jpg" height="50%" width="75%">
        </div>
        <div class="row col-md-4"content=""></div>
        <div class="row col-md-4">
            <div>
                <form method="post" action="login">
                    <label for="email"> Email:
                        <br/>
                        <input type="text" id="email" name="email" class="form-control" autocomplete="off">
                    </label>
                    <br/>
                    <label for="password">Password:
                        <br/>
                        <input type="password" id="password" name="password" class="form-control" autocomplete="off">
                    </label>
                    <br/>
                    <label>
                        <br/>
                        <input type="submit" class="form-control" autocomplete="off" value="登陆">
                    </label>
                </form>
            </div>
        </div>
    </div>

</body>
</html>
