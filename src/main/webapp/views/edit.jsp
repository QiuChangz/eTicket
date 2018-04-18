<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="base/title.jsp"%>
<jsp:useBean id="user" scope="session" class="j2ee.eTicket.entity.User"></jsp:useBean>
<body style="background-color: #9fcdff">

<%
    if(!user.equals(null)){
%>
<%@include file="base/headerAfterLogin.jsp"%>
<%
    }else{
%>
<%@include file="base/headerBeforeLogin.jsp"%>
<%
    }
%>


<div class="container">
    <form role="form" method="post" action="/eTicket/editUserInfo">
        <div>
            <div>
                <img src="../img/default.jpg" width="15%" height="25%"/>
            </div>
            <div>
                <input type="hidden" name="userId" value="<%=user.getId()%>">
                <label>
                    <h3>姓名：
                        <input type="text" class="form-control" name="userName" value="<%=user.getName()%>">
                    </h3>
                </label>
            </div>
            <div>
                <label>
                    <h3>邮箱：
                        <input type="text" class="form-control" name="email" value="<%=user.getEmail()%>">
                    </h3>
                </label>
            </div>
            <div>
                <h3>身份：<%=user.getIdentity()%></h3>
            </div>
            <div><label>
                <h3>出生日期：
                    <input type="date" class="form-control" name="birthday" value="<%=user.getBirthday()%>">
                </h3>
            </label></div>
            <div><h3>信用：<%=user.getCredit()%></h3></div>
            <input type="submit" value="确认">
        </div>

    </form>
</div>
</body>
</html>
