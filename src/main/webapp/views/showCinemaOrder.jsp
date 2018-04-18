<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="j2ee.eTicket.entity.Order" %>
<%@ page import="j2ee.eTicket.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="base/title.jsp"%>

<%--<jsp:useBean id="user" scope="session" class="j2ee.eTicket.entity.User"/>--%>
<jsp:useBean id="shop" scope="session" class="j2ee.eTicket.entity.Shop"/>

<body style="background-color: #9fcdff">
<%@include file="base/headerAfterLogin.jsp"%>

<div class="container">
    <table width="100%" class="table table-hover">
        <thead>
        <tr>
            <th width="10%">订单号</th>
            <th width="10%">时间</th>
            <th width="5%">单价</th>
            <th width="5%">人数</th>
            <th width="10%">电影名</th>
            <th width="10%">用户名</th>
            <th width="10%">联系方式</th>
            <th width="5%">折扣</th>
            <th width="5%">票价</th>
            <th width="5%">打分</th>
            <th width="15%">评价</th>
            <th width="5%">备注</th>
        </tr>
        </thead>
        <tbody>
        <%
            ArrayList<Order> orders = (ArrayList<Order>) request.getAttribute("orders");
            for(Order order: orders){
                User user = order.getUser();
        %>
        <tr>
            <td><c:out value="<%=order.getId()%>"/></td>
            <td><c:out value="<%=order.getCreateTime()%>"/></td>
            <td><c:out value="<%=order.getPrice()%>"/></td>
            <td><c:out value="<%=order.getNum()%>"/></td>
            <td><c:out value="<%=order.getShowContent()%>"/></td>
            <td><c:out value="<%=user.getName()%>"/></td>
            <td><c:out value="<%=user.getEmail()%>"/></td>
            <td><c:out value="<%=order.getDiscount()+\"%\"%>"/></td>
            <td><c:out value="<%=order.getNum()*order.getPrice()%>"/></td>
            <td><c:out value="<%=order.getScore()%>"/></td>
            <td><c:out value="<%=order.getEvaluation()%>"/></td>
            <td width="100">
                <%--<mvc:form method="get"  name="enter" action = "editEvaluation/${order.id}">--%>
                <%--<input type="submit" class="btn btn-default" value="修改评论" >--%>
                <%--</mvc:form>--%>
            </td>
        </tr>
        <%
            }
        %>
        <%--<c:forEach var="order" items="${orders}">--%>
        <%--<tr>--%>
            <%--<td><c:out value="${order.id}"/></td>--%>
            <%--<td><c:out value="${order.createTime}"/></td>--%>
            <%--<td><c:out value="${order.price}"/></td>--%>
            <%--<td><c:out value="${order.num}"/></td>--%>
            <%--<td><c:out value="${order.showContent}"/></td>--%>
            <%--<td><c:out value="${order.user.name}"/></td>--%>
            <%--<td><c:out value="${order.user.email}"/></td>--%>
            <%--<td><c:out value="${order.discount}"/></td>--%>
            <%--<td><c:out value="${order.price}*${order.num}"/></td>--%>
            <%--<td><c:out value="${order.score}"/></td>--%>
            <%--<td><c:out value="${order.evaluation}"/></td>--%>
            <%--<td width="100">--%>
                <%--<mvc:form method="get"  name="enter" action = "editEvaluation/${order.id}">--%>
                    <%--<input type="submit" class="btn btn-default" value="修改评论" >--%>
                <%--</mvc:form>--%>
            <%--</td>--%>
        <%--</tr>--%>
        <%--</c:forEach>--%>
    </table>
</div>
</body>
</html>
