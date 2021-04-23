<#include "../../common/shop/header.ftl">
<#include "../../common/shop/navbar.ftl">


<div class="ji-login">
    <div class="jil-panel">
        <form action="login.do">
            <div style="text-align: center;">账户登录</div>

            <div>
                <label for="name"><i class="fas fa-user"></i></label>
                <input id="name" name="name" type="text" placeholder="登录账户名">
            </div>

            <div>
                <label for="password"><i class="fas fa-unlock-alt"></i></label>
                <input id="password" name="password" type="text" placeholder="密码">
            </div>

            <div>
                <a class="jil-tip" href="#">忘记密码</a>
                <a class="jil-tip float-right" href="#">免费注册</a>
            </div>

            <div>
                <button>登录</button>
            </div>
        </form>
    </div>
</div>