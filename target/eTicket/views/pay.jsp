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
            <td><c:out value="${shop.name}"/></td>
            <td><c:out value="${shop.location}"/></td>
            <td><c:out value="${room.name}"/></td>
            <td>《<c:out value="${room.showContent}"/>》</td>
            <td><c:out value="${seats}"/></td>
            <td><c:out value="${room.showTime}"/></td>
            <td width="100">
                <mvc:form method="post"  action = "pay">
                    <input type="hidden" name="user_id" id="check" value="${user.id}">
                    <input type="hidden" name="id" value="<%=(int)Math.random()*10000%>">
                    <input type="hidden" name="price" value="${room.price}">
                    <%
                        String[] seats = (String[]) request.getAttribute("seats");
                        String result = "";
                        for(String seat:seats){
                            result += seat + ";";
                        }
                    %>
                    %>
                    <input type="hidden" name="state" value="支付中">
                    <input type="hidden" name="num" value="<%=seats.length%>">
                    <input type="hidden" name="shop_id" value="${shop.location}">
                    <input type="hidden" name="discount" value="1">
                    <input type="hidden" name="seats" value="<%=result%>">
                    <input type="hidden" name="show_content" value="${room.showContent}">
                    <input type="submit" class="btn btn-default" value="确认支付">
                </mvc:form>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
