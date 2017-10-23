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
    .loginForm{width:300px;background:#bbcab9 !important;position:fixed;top:50px;left:50%;margin-left:-150px;color:#0a0a0a;border-radius:5px;}
    input{outline:none;border:none;font-family:"微软雅黑";}
    .l_formTop{line-height:50px;background:#ccc;}
    .l_href{float:right;padding-right:10px;color:#656565;}
    .l_href:hover{color:#f7f7f7;}
    .l_title{padding-left: 25px;font-size: 20px;color: #38b95a;font-weight: 600;}
    .l_pline{height:50px;}
    .l_pline.center{text-align:center;}
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
<%--<form method="post" action="signUp" class="loginForm">
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
</form>--%>
<form method="post" action="${pageContext.request.contextPath}/register" class="loginForm" name="loginForm">
    <%--<div class="loginForm">--%>
    <div class="l_formTop">
        <a href="${pageContext.request.contextPath}/login" title="登录" class="l_href">已有帐号？点击登录</a>
        <h3 class="l_title">注 册</h3>
    </div>
    <p class="l_pline"><span class="lp_text">用户名：</span><input type="text" name="username" maxlength="20" class="l_username l_inputInfo">
        <span class="l_inputTip">hello</span>
    </p>
    <p class="l_pline"><span class="lp_text">密 码：</span><input type="password" name="password" maxlength="20" class="l_password l_inputInfo">
        <span class="l_inputTip">world</span>
    </p>
    <p class="l_pline"><span class="lp_text">确认密码：</span><input type="password" name="password_1" maxlength="20" class="l_password_1 l_inputInfo">
        <span class="l_inputTip">world</span>
    </p>
    <%--<p class="l_pline"><input type="button" value="提 交" class="l_submitBtn" title="提 交"></p>--%>
    <p class="l_pline center"><input type="submit" value="提 交" class="l_submitBtn" title="提 交"></p>
</form>
<script>
    window.onload = function () {

        let loginSubmitBtnDom = document.querySelector(".loginForm .l_submitBtn");
        let usernameInputDom = document.querySelector(".loginForm .l_username");
        let passwordInputDom = document.querySelector(".loginForm .l_password");
        let passwordInputDom1 = document.querySelector(".loginForm .l_password_1");
        my.$login.clearLoginTipClass = function (dom) {
            let classList = dom.nextElementSibling.classList;
            classList.remove("bad");
            classList.remove("good");
        }
        usernameInputDom.onmousedown = passwordInputDom.onmousedown = function () {
            my.$login.clearLoginTipClass(this);
        }
        usernameInputDom.onblur = passwordInputDom.onblur = function () {
            my.$login.validate(this);
        }
        loginSubmitBtnDom.onclick = function () {
            return my.$login.validate(usernameInputDom) && my.$login.validate(passwordInputDom);
        }
    };
    // 函数命名区间
    var my = my || {};

    //登录相关的函数
    my.$login = my.$login || {};
    /**
     * 账号，密码验证是否为空。或是少于6 位字符。
     * */
    my.$login.validate = function (dom) {
        console.log(dom.name);
        let value = dom.value;
        let name = dom.name;
        let tipDom = dom.nextElementSibling;
        if (!value) {
            tipDom.classList.add("bad");
            tipDom.innerHTML = "请输入" + (name === "username" ? "用户名！" : "密码！");
            return false;
        } else if (value.length < 6) {
            tipDom.classList.add("bad");
            tipDom.innerHTML = (name === "username" ? "用户名" : "密码") + "长度不得小于6个字符！";
            return false;
        } else {
            tipDom.classList.add("good");
            tipDom.innerHTML = "";
            return true;
        }
        return false;
    }
</script>
</body>
</html>
