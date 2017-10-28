<%--
  Created by IntelliJ IDEA.
  User: luxer
  Date: 10/26/2017
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/pages/templet/header.html"%>
<style>
    .main{width:200px;margin:50px auto;background:#434;padding:20px;color:#fff;}

    .mw_top{margin-bottom:40px;}
    .mw_top h3{margin-bottom:20px;font-size:18px;}
    .mw_t_uploadAvatar{background:#1c997a;cursor:pointer;display:inline-block;padding:0 5px;}
    .mw_bottom{text-align:right;}
    .mw_b_btn{display:inline-block;padding:5px 10px;background:#de1010;color:#fff;margin-left:20px;}
    .mw_b_btn.cancle{background:#322944;}
    .mw_b_btn.cancle:hover{background:#66538c;}
    .mw_b_btn.save{background:#0f0;}
</style>
<div class="main">
    <div class="m_wrap">
        <div class="mw_top">
            <h3>我的资料</h3>
            <div class="">
                <p class="">头像</p>
                <img src="${sessionScope.user.user_avatar_url}" width="194" height="194" alt="avatar">
            </div>
            <input type="file" class="mw_t_fileInput" style="display:none;">
            <p class="">
                更改头像，点击<span class="mw_t_uploadAvatar">上传头像</span>
            </p>
        </div>
        <div class="mw_bottom">
            <a href="${requestScope.url}" title="取消" class="mw_b_btn cancle">取 消</a><a href="" title="保存" class="mw_b_btn save">保 存</a>
        </div>
    </div>
</div>
<script>
    (function () {
        let uploadAvatarDom = document.querySelector(".mw_t_uploadAvatar");
        let fileInputDom = document.querySelector(".mw_t_fileInput");
        uploadAvatarDom.onclick = function () {
            fileInputDom.click();
        }
        fileInputDom.onchange = function () {
            console.log(this.value);
        }
    })();
</script>
</body>
</html>
