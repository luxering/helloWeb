<%--
  Created by IntelliJ IDEA.
  User: luxer
  Date: 10/13/2017
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/pages/templet/header.html" %>
<%--<style>
    *{margin:0;padding:0;}
    ul,or,li{list-style:none;}
    header{background:#0f0;height:30px;padding:20px 0;}
    header .h_rightBox{float:right;}
</style>--%>
<%--<header class="header">
    <div class="h_rightBox">
        <a href=""></a><div>test</div>
    </div>
    <div class="h_leftBox">
        <a href="${pageContext.request.contextPath}" title="homepage"><h3 class="h_title">HelloWeb</h3></a>
    </div>
</header>--%>
<style>
    .mider {background: #3fc;}
    .m_wrap {margin: 0 auto;width: 500px;min-height: 300px;background: #696;}
</style>
<div class="mider">
    <div class="m_wrap">
        <div class="mr_userImg"><img src="${user.user_img_url}" width="184" height="184" alt="user_image"></div>
        <div class="mr_userInfo">
            <ul>
                <li>username:${user.username}</li>
                <li class="">user id:${user.user_id}</li>
                <li class="">sign up date:<span class="user_sign_up_date">2011-11-11</span></li>
            </ul>
        </div>
    </div>
    <script>
        {
            let beautifulTime = function (time) {
                return time < 10 ? "0" + time : time;
            }
            let changeTimeFormat = function (date) {
                    let hour = date.getHours();
                    let minute = date.getMinutes();
                    let second = date.getSeconds();
                    return beautifulTime(hour) + ":" + beautifulTime(minute) + ":" + beautifulTime(second);
                }
            ;(function () {
                let date = new Date(${user.sign_up_date});
                console.log(date);
                document.querySelector(".mider .user_sign_up_date").innerHTML = date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate() + " , " + changeTimeFormat(date);
            })()
        }
    </script>
</div>
</body>
</html>
