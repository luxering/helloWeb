<%--
  Created by IntelliJ IDEA.
  User: luxer
  Date: 10/13/2017
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/pages/templet/header.html"%>
<style type="text/css">
    .loginForm{width:300px;background:#bbcab9 !important;position:fixed;top:100px;left:50%;margin-left:-150px;padding-top:50px;color:#0a0a0a;}
    input{outline:none;border:none;font-family:"微软雅黑";}
    .l_pline{height:50px;}
    .l_pline.last{text-align:center;}
    .lp_text{display:inline-block;width:80px;text-align:right;}
    .l_inputInfo{width:140px;padding:5px;}
    .l_inputTip{padding-left:80px;color:#f00;font-size:10px;display:none;}
    .l_inputTip.bad{color:#f00;display:block;}
    .l_inputTip.good{color:#0f0;}
    .l_submitBtn{width:100px;height:30px;background:#f1f1f1;color:#333;cursor:pointer;}
    .l_submitBtn:hover{background:#669e66;color:#fff;}
    .l_close{position:absolute;right:0;top:0;width:20px;height:20px;background:#f00;color:#fff;line-height:20px;text-align:center;cursor:pointer;font-size:10px;}
    .l_close:hover{background:#e40505;}
</style>
<%--<header><h1><a href="${pageContext.request.contextPath}" title="homepage">helloweb</a></h1></header>--%>
<form method="post" action="signUp" class="loginForm">
    <p class="l_pline"><span class="lp_text">用户名：</span><input type="text" name="username" maxlength="20" class="l_username l_inputInfo">
        <span class="l_inputTip">hello</span>
    </p>
    <p class="l_pline"><span class="lp_text">密 码：</span><input type="password" name="password" maxlength="20" class="l_password1 l_inputInfo">
        <span class="l_inputTip">world</span>
    </p>
    <p class="l_pline"><span class="lp_text">确认密码：</span><input type="password" name="password" maxlength="20" class="l_password2 l_inputInfo">
        <span class="l_inputTip">world</span>
    </p>
    <p class="l_pline last"><input type="submit" value="提 交" class="l_submitBtn" title="提 交"></p>
</form>
<script>
    {
        let usernameInputDom = document.querySelector(".loginForm .l_username");
        let passwordInputDom1 = document.querySelector(".loginForm .l_password1");
        let passwordInputDom2 = document.querySelector(".loginForm .l_password2");
        document.querySelector(".loginForm .l_submitBtn").onclick = function () {
            let username = usernameInputDom.value;
            let password1 = passwordInputDom1.value;
            let password2 = passwordInputDom2.value;
            //validate

            //
        }
    }
</script>
</body>
</html>
