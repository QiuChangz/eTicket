<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<jsp:useBean id="user" scope="session" class="j2ee.eTicket.entity.User"></jsp:useBean>--%>
<%--<div class="row" margin="0 auto">--%>
<%--<img class="col-12" src="img/welcome.jpg" width="100%" height="20%">--%>
<%--</div>--%>
<div class="row">
    <nav class="navbar-inverse visible-lg visible-md" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">首页</a>
            </div>
            <div>
                <ul class="nav navbar-nav">
                    <li><a href="/eTicket/profile">个人资料</a></li>
                    <li>
                        <label for="search" class="center-pill">Search:</label>
                    </li>
                    <li>
                        <mvc:form action= "/eTicket/search" method="post" role="form" name="search">
                            <input id="search" name="shopInfo" class="form-control" type="text" style="background-color: grey" placeholder="Search eTicket"/>
                        </mvc:form>
                    </li>
                    <li><a href="/eTicket/showOrder">我的订单</a></li>
                    <li><a href="/eTicket/editUserInfo">修改资料</a></li>
                    <li><a href="/eTicket/logout">登出</a></li>

                </ul>
            </div>
        </div>
    </nav>
</div>

