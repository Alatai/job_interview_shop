<#include "../../common/shop/header.ftl">
<#include "../../common/shop/navbar.ftl">

<div class="ji-register">
    <div class="">
        <form action="register.do" method="post">
            <div style="margin-top: 50px" class="jir-msg">ユーザネーム設定</div>
            <div>
                <label for="name">ユーザネーム</label>
                <input id="name" name="name" type="text" placeholder="ユーザネーム変更できない">
            </div>

            <div class="jir-msg">
                <span>パスワード設定</span>
                <span>登録検査</span>
            </div>

            <div>
                <label for="password">パスワード</label>
                <input id="password" name="password" type="text" placeholder="パスワード">
            </div>

            <div>
                <label for="pw-confirm">密码确认</label>
                <input id="pw-confirm" name="p-confirm" type="text" placeholder="パスワード確認">
            </div>

            <div>
                <button>堤　　出</button>
            </div>
        </form>
    </div>
</div>


<#include "../../common/shop/footer.ftl">