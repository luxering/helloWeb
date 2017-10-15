<%--
  Created by IntelliJ IDEA.
  User: luxer
  Date: 10/10/2017
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/pages/templet/header.html"%>
    <%--<div class="main">
        <p>logOut Success!</p>
        <p>将自动跳转至主页...</p>
        <p><span class="infoText">3</span>秒...</p>
    </div>
    <script>
        // window.location.href = "/helloweb;/"
        (function () {
            let start = 3;
            let infoDom = document.querySelector(".infoText");
            let timer = setInterval(function(){
                if(start<=0){
                    clearInterval(timer);
                    window.location.href = "/helloweb/";
                    return;
                }
                start --;
                infoDom.innerHTML = start;
            },1000);
        })()
    </script>--%>
<style type="text/css">
    .loginForm{width:300px;height:150px;background:#bbcab9 !important;position:fixed;top:50px;left:50%;margin-left:-150px;padding-top:50px;color:#0a0a0a;}
    input{outline:none;border:none;font-family:"微软雅黑";}
    .l_pline{height:50px;}
    .l_pline:nth-child(3){text-align:center;}
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
<form method="post" action="login" class="loginForm" name="loginForm">
<%--<div class="loginForm">--%>
    <p class="l_pline"><span class="lp_text">用户名：</span><input type="text" name="username" maxlength="20" class="l_username l_inputInfo">
        <span class="l_inputTip">hello</span>
    </p>
    <p class="l_pline"><span class="lp_text">密 码：</span><input type="password" name="password" maxlength="20" class="l_password l_inputInfo">
        <span class="l_inputTip">world</span>
    </p>
    <%--<p class="l_pline"><input type="button" value="提 交" class="l_submitBtn" title="提 交"></p>--%>
    <p class="l_pline"><input type="submit" value="提 交" class="l_submitBtn" title="提 交"></p>
    <div class="l_close" title="关闭">X</div>
</form>
<%--</div>--%>
<script type="text/javascript">
    window.onload = function () {
        {
            let cookie = document.cookie;
            console.log("cookie at window.onload===" + cookie);
            let cookieArr = cookie.split(";");
            let username,user_id = 0;
            for (let i = 0, len = cookieArr.length; i < len; i++) {
                console.log("cookieArr[i]=="+cookieArr[i].trim());
                if (cookieArr[i].indexOf("username") !== -1) {
                    username = cookieArr[i].trim().substring("username".length + 1);
                }else if(cookieArr[i].indexOf("user_id")!==-1){
                    user_id = cookieArr[i].trim().substring("user_id".length + 1);
                }
            }
            let rightHeaderDom = document.querySelector("header .h_rightBox");

            // return;
            function logInConfig() {
                let defaultHtml = "<div class=\'hr_btn\'><a href=\'login\' class=\'hr_logInBtn\' title=\'登录\'>登录</a></div><span class=\'hr_midSpan\'>|</span><div class=\'hr_btn\'><a href=\'register\' class=\'hr_signUpBtn\' title=\'注册\'>注册</a></div>";
                rightHeaderDom.innerHTML = defaultHtml;
                let logInBtnDom = document.querySelector("header .hr_logInBtn");
                if (logInBtnDom) logInBtnDom.onclick = function () {
                    logInFormDom.style.display = "block";
                    usernameInputDom.focus();
                };
            }

            function logInUserConfig(uName,uId) {
                console.log("uName==="+uName);
                rightHeaderDom.innerHTML = "<a href='profile/"+uId+"' class=\'hr_userImg\'><img src=\'https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/5c/5ce363a572151e8d34b30851f8f8eecc12fabe6d_full.jpg\' alt=\'img\' width=\'20\' height=\'20\'>\n" +
                    "          </a><div class=\'hr_userInfo\'>\n" +
                    "              <p class=\'hr_username\'>" + uName + "</p>\n" +
                    "              <ul class=\'hr_ulbox\'>\n" +
                    "                  <li class=\'hr_logOut\' title=\'退出\'>退出</li>\n" +
                    "              </ul>\n" +
                    "          </div>";
                let userImgDom = document.querySelector("header .hr_userImg");
                //click for test
                if (userImgDom) userImgDom.onclick = function () {
                    console.log("uName=="+uName,"uId=="+uId);
                }
                let logOutDom = document.querySelector("header .hr_logOut");
                if (logOutDom) logOutDom.onclick = function () {
                    //退出，显示“登录”
                    logInConfig();
                    let xhr = new XMLHttpRequest();
                    xhr.open("get", "logOut", true);
                    xhr.onreadystatechange = function () {
                        if (this.readyState === 4 && this.status === 200) {
                            let text = this.responseText;
                            console.log("response===" + text);
                            console.log("cookie in xhr====" + document.cookie);
                            // window.location.href = text;
                            // window.location.reload();
                        }
                    }
                    xhr.send();
                    console.log("cookie after xhr===" + document.cookie);
                }
            }

            if (!username) {
                //显示“登录”
                logInConfig();
            } else {
                //显示用户
                logInUserConfig(username,user_id);
            }
        }
        let dateInfoDom = document.querySelector("header .hl_dateInfo");
        let logInFormDom = document.querySelector(".loginForm");
        let closeLogInDom = document.querySelector(".loginForm .l_close");
        let loginSubmitBtnDom = document.querySelector(".loginForm .l_submitBtn");
        let usernameInputDom = document.querySelector(".loginForm .l_username");
        let passwordInputDom = document.querySelector(".loginForm .l_password");
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
        closeLogInDom.onclick = function () {
            logInFormDom.style.display = "none";
            usernameInputDom.value = null;
            passwordInputDom.value = null;
            usernameInputDom.nextElementSibling.innerHTML = passwordInputDom.nextElementSibling.innerHTML = null;
            my.$login.clearLoginTipClass(usernameInputDom);
            my.$login.clearLoginTipClass(passwordInputDom);
        };
        loginSubmitBtnDom.onclick = function () {
            // alert(1);
            // return false;
            // for(let key in document){console.log(key+"==="+document[key]);}
            return my.$login.validate(usernameInputDom) && my.$login.validate(passwordInputDom);
            /*if (my.$login.validate(usernameInputDom) && my.$login.validate(passwordInputDom)) {
                let username = usernameInputDom.value;
                let password = passwordInputDom.value;
                let data = "username=" + username + "&password=" + password;
                console.log("date==" + data);
                let xhr = new XMLHttpRequest();
                xhr.open("post", "login", true);
                xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                xhr.onreadystatechange = function () {
                    if (this.readyState === 4 && this.status === 200) {
                        let text = this.responseText;
                        console.log("text==" + text);
                        if(text.indexOf("fail")!==-1){
                            console.log("fail...");
                            passwordInputDom.value = null;
                            let passwordTipDom = passwordInputDom.nextElementSibling;
                            passwordTipDom.classList.remove("good");
                            passwordTipDom.innerHTML = "账号或密码错误！";
                            passwordTipDom.classList.add("bad");
                        }else {
                            console.log("success....");
                            logInFormDom.style.display = "none";
                            // let user_id = JSON.parse(text).user_id;
                            let user_id = text;
                            //显示用户
                            logInUserConfig(username,user_id);
                        }
                    }
                }
                xhr.send(data);
            }*/
        }
        my.$date.getFullTime(dateInfoDom);
        let dateTimer = setInterval(function () {
            my.$date.getFullTime(dateInfoDom);
        }, 1000);
    };
    // 函数命名区间
    let my = {};
    //date相关的函数
    my.$date = {};
    my.$date.weekArr = ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'];
    my.$date.getFullTime = function (dom) {
        let date = new Date();
        let year = date.getFullYear();
        let month = date.getMonth() + 1;
        let day = date.getDate();
        let weekday = date.getDay();
        let hour = date.getHours();
        let minute = date.getMinutes();
        let second = date.getSeconds();
        dom.innerHTML = year + "年" + month + "月" + day + "日，" + this.weekArr[weekday] + "，" + this.formatClockTime(hour, minute, second);
    };
    my.$date.formatClockTime = function (hour, minute, second) {
        let h = hour < 10 ? "0" + hour : hour;
        let m = minute < 10 ? "0" + minute : minute;
        let s = second < 10 ? "0" + second : second;
        return h + ":" + m + ":" + s;
    }

    //登录相关的函数
    my.$login = {};
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
