<%--
  Created by IntelliJ IDEA.
  User: luxer
  Date: 10/8/2017
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success!</title>
    <style>
        .infoText{color:#f00;padding:0 5px;}
    </style>
</head>
<body>
    <div class="main">
        <p>Success!</p>
        <p>
            <span class="infoText">3</span><span>秒后返回主页...</span>
        </p>
    </div>
    <script>
        {
            let infoTextDom = document.querySelector(".infoText");
            let countdown = 3;
            let countdownTimer = setInterval(function () {
                countdown --;
                infoTextDom.innerHTML = countdown;
                if(countdown<=0){
                    countdownTimer = null;
                    window.location.href = "/helloweb/";
                }
            },1000);
        }
    </script>
</body>
</html>
