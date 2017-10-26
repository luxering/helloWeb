<%--
  Created by IntelliJ IDEA.
  User: luxer
  Date: 10/13/2017
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%--<%@ page errorPage="/WEB-INF/pages/fail.jsp"%>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/pages/templet/header.html" %>
<style>
    .mider {background: #3fc;}
    .m_top{height:100px;background:#0f0;}
    .m_wrap {margin: 0 auto;width: 500px;min-height: 300px;background: #696;}
    .mr_userImg{}
</style>
<div class="mider">
    <div class="m_top"></div>
    <div class="m_wrap">
        <c:if test="${requestScope.user.user_id==sessionScope.user.user_id}">
            <a href="${pageContext.request.servletPath}/edit" class="">编辑资料</a>
        </c:if>
        <div class="mr_userImg"><img src="${requestScope.user.user_avatar_url}" width="184" height="184" alt="user_image"></div>
        <div class="mr_userInfo">
            <ul>
                <li class="">user id:${requestScope.user.user_id}</li>
                <li>username:${requestScope.user.username}</li>
                <li class="">sign up date:<span class="user_sign_up_date">${requestScope.user.register_date}</span></li>
            </ul>
        </div>
    </div>
    <script>
        /*{
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
                let date = new Date(${user.register_date});
                console.log(date);
                document.querySelector(".mider .user_sign_up_date").innerHTML = date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate() + " , " + changeTimeFormat(date);
            })()
        }*/
    </script>
</div>
</body>
</html>
