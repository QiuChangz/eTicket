<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%--<div class="row" margin="0 auto">--%>
        <%--<img class="col-12" src="img/welcome.jpg" width="100%" height="20%">--%>
    <%--</div>--%>
    <div class="row">
        <nav class="navbar-inverse visible-lg visible-md" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <img src="img/default.jpg" width="10%" height="5%"/>
                    <a class="navbar-brand" href="#">首页</a>
                </div>
                <div>
                    <ul class="nav navbar-nav">
                        <li>
                            <label for="search">Search:</label>
                        </li>
                        <li>
                            <mvc:form action="search" method="post" role="form" name="search">
                                <input id="search" name="shopInfo" class="form-control" type="text" style="background-color: grey" placeholder="Search eTicket"/>
                            </mvc:form>
                        </li>
                        <li><a href="/eTicket/signUp">注册</a></li>
                        <li><a href="/eTicket/login">登陆</a></li>

                    </ul>
                </div>
            </div>
        </nav>
    </div>

