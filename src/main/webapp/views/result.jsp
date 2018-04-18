<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="base/title.jsp"%>
<jsp:useBean id="user" scope="session" class="j2ee.eTicket.entity.User"></jsp:useBean>
<body style="background-color: #9fcdff">

<%
    if(user.equals(null)){
%>
<%@include file="base/headerBeforeLogin.jsp"%>
<a href="login">返回</a>
<%
}else{
%>
<%@include file="base/headerAfterLogin.jsp"%>

<div class="container">
<table width="100%" class="table table-hover">
    <thead>
    <tr>
        <th width="10%">商店名</th>
        <th width="20%">商店地址</th>
        <th width="20%">影片</th>
        <th width="10%">评分</th>
        <th width="20%">联系方式</th>
        <th>购票</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="shop" items="${shops}">
        <tr>
            <td><c:out value="${shop.getName()}"/></td>
            <td><c:out value="${shop.getLocation()}"/></td>
            <td>《<c:out value="${shop.getShowContent()}"/>》</td>
            <td><c:out value="${shop.getScore()}"/></td>
            <td><c:out value="${shop.getPhone()}"/></td>
            <td width="100">
                <mvc:form method="post"  name="enter" id="enter" action = "shopProfile">
                    <input type="hidden" name="userId" id="check" value="${user.id}">
                    <input type="hidden" name="shopId" value="${shop.getId()}">
                    <input type="submit" class="btn btn-default" value="进入">
                </mvc:form>
            </td>
        </tr>
    </c:forEach>
</table>
</div>
<%
    }
%>
</body>
</html>
