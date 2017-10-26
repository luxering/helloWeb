<%--
  Created by IntelliJ IDEA.
  User: luxer
  Date: 10/8/2017
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/pages/templet/header.html"%>
    <div class="info">
        <%--<p>Login failure!</p>--%>
        <p>${requestScope.msg}</p>
    </div>
<c:if test="${requestScope.msg!='user not found!'}">
    <%@include file="/WEB-INF/pages/templet/goBackToIndex.html"%>
</c:if>
</body>
</html>
