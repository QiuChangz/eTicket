<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="shop" scope="request" class="j2ee.eTicket.entity.Shop"></jsp:useBean>
<jsp:useBean id="user" scope="session" class="j2ee.eTicket.entity.User"></jsp:useBean>

<%@include file="base/title.jsp"%>

<body style="background-color: #9fcdff">

<%
    if(user.equals(null)){
%>
<%--<%@include file="base/headerBeforeLogin.jsp"%>--%>
<%--<a href="login">返回</a>--%>
<jsp:forward page="/login"></jsp:forward>
<%
}else{
%>
<%@include file="base/headerAfterLogin.jsp"%>

<div class="container">
    <div>
        <div>
            <img src="../img/cinema.jpg" width="75%" height="50%"/>
        </div>
        <div><h3>商店名：${shop.name}</h3></div>
        <div><h3>联系方式：${shop.phone}</h3></div>
        <div><h3>创建时间：${shop.createTime}</h3></div>
        <div>
            <h3>上映影片：</h3>
            <%
                String []showContents = shop.getShowContent().split(";");
                for(String onShow : showContents){
            %>
            <h4>《<%=onShow%>》</h4>
            <%}%>
        </div>
        <div><h3>评分：${shop.score}</h3></div>
        <div><h3>地址：${shop.location}</h3></div>
        <%
            if(user.getId() == shop.getManagerId()){
        %>
        <form role="form" method="get" action="${pageContext.request.contextPath}/showCinemaOrder">
            <input type="submit" class="form-control" value="查看订单信息">
        </form>
        <form role="form" method="get" action="${pageContext.request.contextPath}/addMovie">
            <input type="submit" class="form-control" value="添加计划">
        </form>
        <form role="form" method="get" action="${pageContext.request.contextPath}/checkSelect">
            <input type="submit" class="form-control" value="检票">
        </form>
        <%
            }else{
        %>
        <form role="form" method="get" action="/eTicket/buy/${shop.id}">
            <input type="submit" class="form-control" value="购票">
        </form>
        <%
            }
        %>
        <%--<c:choose>--%>
        <%--<c:when test="${user.id} == ${shop.managerId}">--%>
            <%--<form role="form" method="post" action="/eTicket/showCinemaOrder">--%>
                <%--<input type="hidden" name="shopId" value="${shop.id}">--%>
                <%--<input type="hidden" name="managerId" value="${user.id}">--%>
                <%--<input type="submit" class="form-control" value="查看信息">--%>
            <%--</form>--%>
            <%--<form role="form" method="post" action="/eTicket/addMovie">--%>
                <%--<input type="hidden" name="shopId" value="${shop.id}">--%>
                <%--<input type="hidden" name="managerId" value="${user.id}">--%>
                <%--<input type="hidden" name="managerId" value="${user.id}">--%>
                <%--<input type="submit" class="form-control" value="添加计划">--%>
            <%--</form>--%>
        <%--</c:when>--%>
        <%--<c:otherwise>--%>
            <%--<form role="form" method="get" action="/eTicket/buy/${shop.id}">--%>
                <%--<input type="submit" class="form-control" value="购票">--%>
            <%--</form>--%>
        <%--</c:otherwise>--%>
        <%--</c:choose>--%>
        <input type="button" class="form-control" value="返回" onclick="history.back();">
    </div>
</div>
<%
    }
%>
</body>
</html>
