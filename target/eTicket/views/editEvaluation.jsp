<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="base/title.jsp"%>

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
            <th width="20%">地点</th>
            <th width="10%">座位</th>
            <th width="5%">折扣</th>
            <th width="5%">票价</th>
            <th width="5%">打分</th>
            <th width="15%">评价</th>
            <th width="5%">确认</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <form method="post" action = "/eTicket/editEvaluation">

            <%--<input type="hidden" name="show_time" value="${order.showTime}">--%>
            <%--<input type="hidden" name="user" value="${order.user}">--%>
            <%--<input type="hidden" name="shop" value="${order.shop}">--%>
            <%--<input type="hidden" name="state" value="${order.state}">--%>
            <td><input type="text" name="orderId" class="form-control" readonly value="${order.id}"/></td>
            <td><input type="text" name="create_time" class="form-control" readonly value="${order.createTime}"/></td>
            <td><input type="text" name="price" class="form-control" readonly value="${order.price}"/></td>
            <td><input type="text" name="num" class="form-control" readonly value="${order.num}"/></td>
            <td><input type="text" name="show_content" class="form-control" readonly value="${order.showContent}"/></td>
            <td><input type="text" name="shop_location" class="form-control" readonly value="${order.shopLocation}"/></td>
            <td><input type="text" name="seats" class="form-control" readonly value="${order.seats}"/></td>
            <td><input type="text" name="discount" class="form-control" readonly value="${order.discount}"/></td>
            <td><input type="text" class="form-control" readonly value="${order.price}*${order.num}"/></td>
            <td><input name="score" type="number" value="${order.score}"></td>
            <td><input name="evaluation" type="text" value="${order.evaluation}"></td>
            <td width="100">
                <input type="submit" class="btn btn-default" value="确认" >
            </td>
            </form>
        </tr>
    </table>
</div>
</body>
</html>
