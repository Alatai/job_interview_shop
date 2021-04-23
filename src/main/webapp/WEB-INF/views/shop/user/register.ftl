<#include "../../common/shop/header.ftl">
<#include "../../common/shop/navbar.ftl">

<div class="ji-register">
    <div class="">
        <form action="register.do" method="post">
            <div style="margin-top: 50px" class="jir-msg">设置用户登录命</div>
            <div>
                <label for="name">设置用户名</label>
                <input id="name" name="name" type="text" placeholder="会员名一旦设置无法更改">
            </div>

            <div class="jir-msg">
                <span>设置登录密码</span>
                <span>登录时验证，保证账号信息</span>
            </div>

            <div>
                <label for="password">登录密码</label>
                <input id="password" name="password" type="text" placeholder="设置你的密码">
            </div>

            <div>
                <label for="pw-confirm">密码确认</label>
                <input id="pw-confirm" name="p-confirm" type="text" placeholder="请再次输入你的密码">
            </div>

            <div>
                <button>提　　交</button>
            </div>
        </form>
    </div>
</div>