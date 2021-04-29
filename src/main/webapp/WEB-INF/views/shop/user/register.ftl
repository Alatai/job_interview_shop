<#include "../../common/shop/header.ftl">
<#include "../../common/shop/navbar.ftl">


<script type="text/javascript">
    $(function () {
        $('#registerForm').validate({
            rules: {
                passwordConfirm: {
                    equalTo: '#password'
                }
            }
        });
    });
</script>

<div class="ji-register">
    <div class="">
        <form id="registerForm" action="register.do" method="post">
            <#if msg??>
                <div style="text-align: center;padding-top: 50px;" class="red-color">${msg}</div>
            </#if>

            <div style="margin-top: 50px" class="jir-msg">
                ユーザネーム設定
            </div>
            <div>
                <label for="name">ユーザネーム</label>
                <input id="name" name="name" type="text" placeholder="ユーザネーム変更できない" required>
            </div>

            <div class="jir-msg">
                <span>パスワード設定</span>
                <span>登録検査</span>
            </div>

            <div>
                <label for="password">パスワード</label>
                <input id="password" name="password" type="text" placeholder="パスワード" required>
            </div>

            <div>
                <label for="passwordConfirm">パスワード確認</label>
                <input id="passwordConfirm" name="passwordConfirm" type="text" placeholder="パスワード確認">
            </div>

            <div>
                <button>堤　　出</button>
            </div>
        </form>
    </div>
</div>


<#include "../../common/shop/footer.ftl">