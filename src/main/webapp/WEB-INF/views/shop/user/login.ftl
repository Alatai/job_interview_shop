<#include "../../common/shop/header.ftl">
<#include "../../common/shop/navbar.ftl">


<div class="ji-login">
    <div class="jil-panel">
        <form action="login.do" method="post">
            <#if msg??>
                <div class="red-color">${msg}</div>
            </#if>

            <div style="text-align: center;">ユーザ登録</div>

            <div>
                <label for="name"><i class="fas fa-user"></i></label>
                <input id="name" name="name" type="text" placeholder="ユーザネーム" required>
            </div>

            <div>
                <label for="password"><i class="fas fa-unlock-alt"></i></label>
                <input id="password" name="password" type="text" placeholder="パスワード" required>
            </div>

            <div>
                <a class="jil-tip" href="javascript:">パスワード忘れ</a>
                <a class="jil-tip float-right" href="javascript:">無料登録</a>
            </div>

            <div>
                <button>登録</button>
            </div>
        </form>
    </div>
</div>


<#include "../../common/shop/footer.ftl">