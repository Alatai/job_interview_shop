<#include "../../common/shop/header.ftl">
<#include "../../common/shop/navbar.ftl">


<script type="text/javascript">

</script>

<div class="ji-order">
    <form id="orderForm" action="createOrder" method="post" onsubmit="return doSubmit()">
        <div class="ji-address">
            <div class="ja-tip">住所を入力して下さい</div>

            <div class="ja-detail">
                <div>
                    <label for="address">住所<span>*</span></label>
                    <textarea id="address" name="address" required></textarea>
                </div>

                <div>
                    <label for="postCode">郵便番号<span>*</span></label>
                    <input id="postCode" name="postCode" type="text" required>
                </div>

                <div>
                    <label for="receiver">受取人<span>*</span></label>
                    <input id="receiver" name="receiver" type="text" required>
                </div>

                <div>
                    <label for="phoneNumber">電話番号<span>*</span></label>
                    <input id="phoneNumber" name="phoneNumber" type="text" required>
                </div>

                <div>
                    <label for="remark">備考欄</label>
                    <textarea id="remark" name="remark"></textarea>
                </div>
            </div>
        </div>

        <div class="ja-confirm" style="margin-top: 50px;">
            <div class="ja-tip">オーダー確認</div>

            <table>
                <thead>
                <tr>
                    <th colspan="2">JI SHOP</th>
                    <th>単価</th>
                    <th>数</th>
                    <th>金額</th>
                    <th>配達方法</th>
                </tr>
                <tr class="ja-row">
                    <td colspan="2"></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                </thead>
                <tbody>
                <#list orderItems as orderItem>
                    <tr class="jo-item">
                        <td>
                            <img style="width:50px;"
                                 src="../image/single/<#if orderItem.product.productImages[0].type =='type_single'>${orderItem.product.productImages[0].name}</#if>"
                                 alt="暂无">
                        </td>
                        <td class="ad-info">
                            <a href="../product/detail?id=${orderItem.product.id}">${orderItem.product.name}</a>
                            <img title="クレジットカード" src="../image/site/creditcard.png">
                        </td>
                        <td class="ji-column">
                            <span>￥${orderItem.product.promotePrice?string("0.00")}</span>
                        </td>
                        <td class="ji-column">
                            <span>${orderItem.number}</span>
                        </td>
                        <td class="ji-column">
                            <span>￥${(orderItem.product.promotePrice * orderItem.number)?string("0.00")}</span>
                        </td>
                        <td style="text-align: center;">
                            <label for="deliverType" class=""></label>
                            <input id="deliverType" type="radio" checked="checked" value="">
                            普通
                            <select class="">
                                <option>普通 無料</option>
                            </select>
                        </td>
                    </tr>
                </#list>
                </tbody>
            </table>

            <div class="jo-sum clear-fix">
                <span class="float-right">合計  （運賃除く）: ￥${amount?string("0.00")}</span>
            </div>

            <div class="jo-total clear-fix">
                <div class="float-right">
                    <span>金額：</span>
                    <span class="total">￥${amount?string("0.00")}</span>
                </div>
            </div>

            <div class="">
                <input type="submit" class="float-right" value="オーダー提出"/>
            </div>
        </div>
    </form>
</div>


<#include "../../common/shop/footer.ftl">