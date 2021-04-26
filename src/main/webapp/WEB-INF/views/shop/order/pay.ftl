<#include "../../common/shop/header.ftl">
<#include "../../common/shop/navbar.ftl">


<div class="ji-container ji-pay">
    <div>
        <div>
            <span>未払い金額：</span>
            <span class="jip-amount">￥${order.amount?string("0.00")}</span>
        </div>

        <div>
            <label for="amount">金額：</label>
            <input id="amount" type="text">
        </div>

        <div>
            <a href="hasPaid?id=${order.id}">
                <button>支払い確認</button>
            </a>
        </div>
    </div>
</div>


<#include "../../common/shop/footer.ftl">