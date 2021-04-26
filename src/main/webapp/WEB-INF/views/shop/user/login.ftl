<#include "../../common/shop/header.ftl">
<#include "../../common/shop/navbar.ftl">


<div class="ji-login">
    <div class="jil-panel">
        <form action="login.do" method="post">
            <div style="text-align: center;">ユーザ登録</div>

            <div>
                <label for="name"><i class="fas fa-user"></i></label>
                <input id="name" name="name" type="text" placeholder="ユーザネーム">
            </div>

            <div>
                <label for="password"><i class="fas fa-unlock-alt"></i></label>
                <input id="password" name="password" type="text" placeholder="パスワード">
            </div>

            <div>
                <a class="jil-tip" href="#">パスワード忘れ</a>
                <a class="jil-tip float-right" href="#">無料登録</a>
            </div>

            <div>
                <button>登録</button>
            </div>
        </form>
    </div>
</div>