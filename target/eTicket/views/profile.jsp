<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="base/title.jsp"%>
<jsp:useBean id="user" scope="session" class="j2ee.eTicket.entity.User"></jsp:useBean>
<body style="background-color: #9fcdff">

<%
    if(null == user){
%>
<%@include file="base/headerBeforeLogin.jsp"%>
<a href="login">返回</a>
<%
    }else{
%>
<%@include file="base/headerAfterLogin.jsp"%>

    <div class="container">
        <div>
            <div>
                <img src="../img/default.jpg" width="15%" height="25%"/>
            </div>
            <div><h3>姓名：<%=user.getName()%></h3></div>
            <div><h3>邮箱：<%=user.getEmail()%></h3></div>
            <div>
                <%
                    if (user.getCredit() >= 500 && user.getIdentity().equals("普通用户")){
                %>
                    <h3>身份：<%=user.getIdentity()%></h3>
                    <form action="update" method="get">
                        <input type="submit" value="升级用户！">
                    </form>

                <%
                    }else if (user.getIdentity().equals("商店经理")){
                %>
                <h3>身份：<%=user.getIdentity()%></h3>
                    <form action="shopProfile" method="get">
                        <input type="submit" value="前往我的店">
                    </form>
                    <a href="place/signUp">场馆注册</a>
                <%
                }else if (user.getIdentity().equals("普通会员")){
                %>
                    <h3>身份：<%=user.getIdentity()%></h3>
                    <form action="cancel" method="get">
                        <input type="submit" value="取消会员">
                    </form>
                <%
                    }else{
                %>
                    <h3>身份：普通用户</h3>
                <%
                    }
                %>
            </div>
            <div><h3>生日：<%=user.getBirthday()%></h3></div>
            <div><h3>信用：<%=user.getCredit()%></h3></div>
            <div>
                <h3>余额：<%=user.getMoney()%></h3>
                <form role="form" action="recharge" method="get">
                    <input type="submit" value="充值">
                </form>
            </div>
        </div>
    </div>
<%}%>
</body>
</html>
