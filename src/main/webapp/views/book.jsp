<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="base/title.jsp"%>
<body style="background-color: #9fcdff">
<%@include file="base/headerBeforeLogin.jsp"%>
<div class="container">
    <table width="100%" class="table table-hover">
        <thead>
        <tr>
            <th width="10%">商店名</th>
            <th width="20%">商店地址</th>
            <th width="20%">放映室</th>
            <th width="20%">影片</th>
            <th width="10%">座位</th>
            <th width="20%">放映时间</th>
            <th>购票</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <%
                String[] seats = (String[]) request.getAttribute("seats");
                String result = "";
                for(String seat:seats){
                    result += seat + ";";
                }
            %>
            <td><c:out value="${shop.name}"/></td>
            <td><c:out value="${shop.location}"/></td>
            <td><c:out value="${room.name}"/></td>
            <td>《<c:out value="${room.showContent}"/>》</td>
            <td><c:out value="<%=result%>"/></td>
            <td><c:out value="${room.showTime}"/></td>
            <td width="100">
                <mvc:form method="post"  action = "pay">
                    <input type="hidden" name="userId" id="check" value="1">
                    <input type="hidden" name="price" value="${room.price}">
                    <input type="hidden" name="state" value="支付中">
                    <input type="hidden" name="roomId" value="${room.id}">
                    <input type="hidden" name="shopId" value="${shop.id}">
                    <input type="hidden" name="shopLocation" value="${shop.location}">
                    <input type="hidden" name="seats" value="<%=result%>">
                    <input type="hidden" name="showContent" value="${room.showContent}">
                    <input type="submit" class="btn btn-default" value="确认">
                </mvc:form>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
