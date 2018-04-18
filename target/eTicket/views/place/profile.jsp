<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../base/title.jsp"%>
<jsp:useBean id="room" scope="session" class="j2ee.eTicket.entity.Room"/>
<body style="background-color: #9fcdff">

<%@include file="../base/headerAfterLogin.jsp"%>

<%--<jsp:useBean id="user" scope="session" class="j2ee.eTicket.entity.User"></jsp:useBean>--%>
<%--<div class="row" margin="0 auto">--%>
<%--<img class="col-12" src="img/welcome.jpg" width="100%" height="20%">--%>
<%--</div>--%>


<div class="container">
    <form>
        <div><h3>场馆名：<%=room.getName()%></h3></div>
        <div>
            <label>
                <h3>座位信息：</h3>
                <input type="text" name="seats" value="<%=room.getSeat()%>">
            </label>
        </div>
        <div><h3>放映内容：<%=room.getShowContent()%></h3></div>
        <div><h3>放映时间：<%=room.getSeat()%></h3></div>
    </form>
</div>
</body>
</html>
