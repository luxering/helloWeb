<%--
  Created by IntelliJ IDEA.
  User: luxer
  Date: 10/8/2017
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/pages/templet/header.html"%>
    <div class="main">
        <p>Success!</p>
        <%@include file="/WEB-INF/pages/templet/goBackToIndex.html"%>
        <%--<p>
            <span class="infoText">3</span><span>秒后返回主页...</span>
        </p>
        <script>
            {
                let infoTextDom = document.querySelector(".infoText");
                let countdown = 3;
                let countdownTimer = setInterval(function () {
                    countdown --;
                    infoTextDom.innerHTML = countdown;
                    if(countdown<=0){
                        clearInterval(countdownTimer);
                        countdownTimer = null;
                        window.location.href = "${pageContext.request.contextPath}";
                    }
                },1000);
            }
        </script>--%>
    </div>
</body>
</html>
