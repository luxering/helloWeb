<%--
  Created by IntelliJ IDEA.
  User: luxer
  Date: 10/8/2017
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <title>$Title$</title>
  </head>
  <body>
  <style>
      *{margin:0;padding:0;}
      body{font-size:14px;font-family:"微软雅黑";}
      a{text-decoration:none;}
      a:hover{text-decoration:underline;color:#ff5722;}
      .header{height:30px;line-height:30px;background:#ccc;padding:0 50px;}
      .h_rightBox{float:right;font-size:12px;}
      .hr_btn{display:inline-block;}
      .hr_midSpan{padding:0 5px;}

      .hl_title{font-weight:400;font-size:18px;}
  </style>
  <header class="header">
      <div class="h_rightBox">
          <div class="hr_btn"><a href="javascript:void(0);" class="hr_logInBtn">登录</a></div><span class="hr_midSpan">|</span><div class="hr_btn"><a href="javascript:void(0);" class="hr_signUpBtn">注册</a> </div>
      </div>
      <div class="h_leftBox">
          <h3 class="hl_title">HelloWeb</h3>
      </div>
  </header>
  <style type="text/css">
      .loginForm{display:none;}
  </style>
  <form method="post" action="login" class="loginForm" name="loginForm">
      <p class="pline"><label>用户名：<input type="text" name="username"> </label></p>
      <p class="pline"><label>密码：<input type="password" name="password"></label></p>
      <p class="pline"><input type="submit" value="提交"> </p>
  </form>
  <script type="text/javascript">
      window.onload = function(){
          let logInFormDom = document.forms[0];
          let logInBtnDom = document.querySelector("header .hr_logInBtn");
          logInBtnDom.onclick = function () {
              logInFormDom.style.display = "block";
          }
      }
  </script>
  </body>
</html>
