<%--
  Created by IntelliJ IDEA.
  User: luxer
  Date: 10/8/2017
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@include file="WEB-INF/pages/templet/header.html"%>
<style>
    .main{width:80%;min-width:800px;min-height:800px;margin:0 auto;background:#ff0;}
    .m_ulbox{overflow:hidden;}
    .m_list{width:150px;height:200px;background:#333;margin-right:20px;float:left;}
    .m_cov:after,.m_ulbox:after{content:"";clear:both;}
</style>
<div class="main">
    <div class="m_cov">
        <ul class="m_ulbox">
            <li class="m_list">hello java</li>
            <li class="m_list">hello html</li>
            <li class="m_list">hello javascript</li>
            <li class="m_list">hello servlet</li>
            <li class="m_list">hello jsp</li>
        </ul>
    </div>
</div>
<style>
    footer{height:100px;background:#7f3;}
</style>
<footer>
            <c:out value="${cookie.user_id.value}"/>
    <div class="f_left">
        <p>this is the end</p>
    </div>
</footer>
</body>
</html>
