<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="base/title.jsp"%>
<jsp:useBean id="user" scope="session" class="j2ee.eTicket.entity.User"></jsp:useBean>
<body style="background-color: #9fcdff">

<%
    if(null != user){
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
    <form role="form" method="post" action="recharge">
        <input type="number" value="50" name="num">
        <input type="submit" value="确认充值">
    </form>
</div>
</body>
</html>
