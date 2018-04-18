<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="j2ee.eTicket.entity.Room" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="user" class="j2ee.eTicket.entity.User" scope="session"/>
<jsp:useBean id="shop" class="j2ee.eTicket.entity.Shop" scope="session"/>

<%@include file="../base/title.jsp"%>
<body style="background-color: #9fcdff">
<%@include file="../base/headerAfterLogin.jsp"%>

<%
    ArrayList<Room> rooms = (ArrayList<Room>) request.getAttribute("rooms");

     for(Room room: rooms){
%>
<button value="添加电影" class="btn btn-primary btn-lg" data-toggle="modal" data-target="<%="#seats"+room.getName()%>"></button>
<form role="form" class="form-group" method="post" action="${pageContext.request.contextPath}/addMovie">
    <div class="modal fade" id="<%="seats"+room.getName()%>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">修改放映信息</h4>
                </div>
                <div class="modal-body">
                    <input type="hidden" name="roomId" value="<%=room.getId()%>">
                    <div>
                        <label>
                        商店名：<%=shop.getName()%>
                            <%--<input type="text" readonly value="<%=shop.getName()%>">--%>
                        </label>
                    </div>
                    <div>
                        <label>
                        房间名：<%=room.getName()%>
                            <%--<input type="text" readonly value="<%=room.getName()%>">--%>
                        </label>
                    </div>
                    <div>
                        <label>
                        地点：<%=shop.getLocation()%>
                            <%--<input type="text" readonly value="<%=shop.getLocation()%>">--%>
                        </label>
                    </div>
                    <div>
                        <label>
                        上映内容：
                            <input type="text" name="showContent" value="<%=room.getShowContent()%>">
                        </label>
                    </div>
                    <div>
                        <label>
                        座位信息：<%=room.getSeat()%>
                            <%--<input type="text" readonly value="<%=room.getSeat()%>">--%>
                        </label>
                    </div>
                    <div>
                        <label>
                        上映时间：
                            <input type="text" name="showTime" value="<%=room.getShowTime()%>">
                        </label>
                    </div>
                    <div>
                        <label>
                        票价：
                            <input type="text" name="price" value="<%=room.getPrice()%>">
                        </label>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="submit" class="btn btn-primary">保存</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
</form>
<%
    }
%>

</body>
</html>
