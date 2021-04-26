<#include "../../common/shop/header.ftl">
<#include "../../common/shop/navbar.ftl">


<div class="ji-container ji-pay">
    <form action="#">
        <div>
            <span>应付金额：</span>
            <span class="jip-amount">￥${order.amount?string("0.00")}</span>
        </div>

        <div>
            <label for="amount">付款：</label>
            <input id="amount" type="text">
        </div>

        <div>
            <a href="#">
                <button>确认支付</button>
            </a>
        </div>
    </form>
</div>


<#include "../../common/shop/footer.ftl">