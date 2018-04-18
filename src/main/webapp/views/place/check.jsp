<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="j2ee.eTicket.entity.Order" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../base/title.jsp"%>

<body style="background-color: #9fcdff">
<%@include file="../base/headerAfterLogin.jsp"%>

<div class="container">
    <table width="100%" class="table table-hover">
        <thead>
        <tr>
            <th width="10%">订单号</th>
            <th width="10%">时间</th>
            <th width="5%">单价</th>
            <th width="5%">人数</th>
            <th width="10%">电影名</th>
            <th width="20%">地点</th>
            <th width="10%">座位</th>
            <th width="5%">折扣</th>
            <th width="5%">票价</th>
            <th width="5%">状态</th>
            <th width="5%">打分</th>
            <th width="15%">评价</th>
            <th width="5%">修改</th>
        </tr>
        </thead>
        <tbody>
            <%
            ArrayList<Order> orders = (ArrayList<Order>) session.getAttribute("orders");
            for (Order order: orders){
        %>
        <%--<c:forEach var="order" items="${orders}">--%>
        <tr>
            <%--<td><c:out value="${order.id}"/></td>--%>
            <%--<td><c:out value="${order.createTime}"/></td>--%>
            <%--<td><c:out value="${order.price}"/></td>--%>
            <%--<td><c:out value="${order.num}"/></td>--%>
            <%--<td><c:out value="${order.showContent}"/></td>--%>
            <%--<td><c:out value="${order.shopLocation}"/></td>--%>
            <%--<td><c:out value="${order.seats}"/></td>--%>
            <%--<td><c:out value="${order.discount}"/></td>--%>
            <%--<td><c:out value="${order.price}*${order.num}"/></td>--%>
            <%--<td><c:out value="${order.state}"/> </td>--%>
            <%--<td><c:out value="${order.score}"/></td>--%>
            <%--<td><c:out value="${order.evaluation}"/></td>--%>

            <td><%=order.getId()%></td>
            <td><%=order.getCreateTime()%></td>
            <td><%=order.getPrice()%></td>
            <td><%=order.getNum()%></td>
            <td><%=order.getShowContent()%></td>
            <td><%=order.getShopLocation()%></td>
            <td><%=order.getSeats()%></td>
            <td><%=order.getDiscount()%></td>
            <td><%=order.getPrice()*order.getNum()%></td>
            <td><%=order.getState()%> </td>
            <td><%=order.getScore()%></td>
            <td><%=order.getEvaluation()%></td>
            <td width="100">
                <%
                    if(order.getState().equals("已支付")){
                %>
                <mvc:form method="post"  name="enter" action = "/eTicket/check">
                    <input type="hidden" name="orderId" value="<%=order.getId()%>">
                    <input type="submit" class="btn btn-default" value="检票" >
                </mvc:form>
                <%
                }else if (order.getState().equals("支付中")){
                %>
                <mvc:form method="post"  name="enter" action = "/eTicket/payOrder">
                    <input type="hidden" name="orderId" value="<%=order.getId()%>">
                    <%--<input type="submit" class="btn btn-default" value="支付" >--%>
                </mvc:form>
                <%
                    }
                %>
            </td>
        </tr>
            <%
            }
        %>
    </table>
</div>
</body>
</html>
