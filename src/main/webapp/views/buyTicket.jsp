<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="j2ee.eTicket.entity.Room" %>
<%@ page import="j2ee.eTicket.entity.Shop" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="base/title.jsp"%>
<body style="background-color: #9fcdff">
<%@include file="base/headerAfterLogin.jsp"%>

<div class="container">
    <table width="100%" class="table table-hover">
        <thead>
        <tr>
            <th width="10%">房间名</th>
            <th width="10%">放映内容</th>
            <th width="50%">影片介绍</th>
            <th width="5%">单价</th>
            <th width="5%">座位</th>
        </tr>
        </thead>
        <tbody>
        <%
//            Shop shop = null;
            ArrayList<Room> rooms = (ArrayList<Room>)request.getAttribute("rooms");
//            int rowNum = 0;
            for(Room room: rooms){
        %>
        <%--<c:forEach var="room" items="${rooms}">--%>
        <tr>
            <td><c:out value="<%=room.getName()%>"/></td>
            <td><c:out value="<%=room.getShowContent()%>"/></td>
            <td><c:out value="<%=room.getContent()%>"/></td>
            <td><c:out value="<%=room.getPrice()%>"/></td>
            <td>
                <form action="/eTicket/select" method="post">
                    <input type="hidden" name="roomId" value="<%=room.getId()%>">
                    <input type="submit" value="选择">
                </form>
            </td>
        </tr>
        <%}%>
    </table>
</div>
</body>
</html>
