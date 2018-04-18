<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="j2ee.eTicket.entity.Room" %>
<%@ page import="j2ee.eTicket.entity.Shop" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="base/title.jsp"%>
<body style="background-color: #9fcdff">
<%@include file="base/headerAfterLogin.jsp"%>

<%
    Room room = (Room)request.getAttribute("room");
%>
<button value="点此选座" class="btn btn-primary btn-lg" data-toggle="modal" data-target="<%="#seats"+room.getName()%>"></button>
<form role="form" class="form-group" method="post" action="book">
    <div class="modal fade" id="<%="seats"+room.getName()%>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">选择您的座位</h4>
                </div>
                <div class="modal-body">
                        <input type="hidden" name="roomId" value="<%=room.getId()%>">
                    <%
                        String []seats = room.getSeat().split(";");
                        if(null == room.getUnavailable()){
                            room.setUnavailable("");
                        }
                        String []unavailale = room.getUnavailable().split(";");
                        for(int i = 0; i < seats.length; i++){
                            String str = seats[i];
                            int index = seats[i].lastIndexOf(",")+1;
                            int lastindex = seats[i].lastIndexOf(")");
                            System.out.println(str+index+lastindex);
                            String temp = seats[i].substring(index,lastindex);
                            int max = Integer.parseInt(temp);
                            for(int j = 0; j <= max; j++){
                                for(String una : unavailale){
                                    if(!una.equals("") && una.equals("(" + i + "," + j + ")")){
                    %>
                    <label>
                        <input type="checkbox" name="seats" value="(<%=i%>,<%=j%>)" checked readonly>
                    </label>
                    <%
                                    }else{
                    %>
                    <label><%="("+i+","+j+")"%>
                        <input type="checkbox" name="seats" value="(<%=i%>,<%=j%>)">
                    </label>
                    <%
                                }
                            }
                        }
                    %>
                </div>
                <input type="hidden" name="shopId" value="<%=room.getShop().getId()%>">
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="submit" class="btn btn-primary">提交</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
        <%
            }
        %>
    </div>
</form>
</body>
</html>
