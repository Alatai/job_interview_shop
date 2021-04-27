<#include "../../common/shop/header.ftl">
<#include "../../common/shop/navbar.ftl">


<script type="text/javascript">
    $(function () {
        // オーダーの状態を基にコントロール
        $('a[data-status]').click(function () {
            let status = $(this).data('status');

            if (status === 'all') {
                $('table[data-status]').show();
            } else {
                $('table[data-status]').hide();
                $('table[data-status="' + status + '"]').show();
            }
        });


    });
</script>

<div class="ji-orders">
    <div class="jio-type clear-fix">
        <div class="jio-active"><a data-status="all" href="#">すべて</a></div>
        <div><a data-status="waitPay" href="#">支払い待ち</a></div>
        <div><a data-status="waitDelivery" href="#">出荷待ち</a></div>
        <div><a data-status="waitConfirm" href="#">受け取り待ち</a></div>
        <div><a data-status="waitReview" href="#">評価待ち</a></div>
        <div class="jio-last"></div>
    </div>

    <div class="jio-list">
        <table class="jil-title">
            <tbody>
            <tr>
                <td>商品</td>
                <td style="width: 100px;">単価</td>
                <td style="width: 100px;">数</td>
                <td style="width: 120px;">金額</td>
                <td style="width: 100px;">状態</td>
                <td style="width: 100px;">操作</td>
            </tr>
            </tbody>
        </table>
    </div>

    <div class="jio-item">
        <#list orders as order >
            <table class="jio-table" data-status="${order.status}">
                <tbody>
                <tr class="jio-first">
                    <td colspan="2">
                        <span>${order.createdDate?string("yyyy-MM-dd HH:mm:ss")}</span>
                        <span>オーダーコード: ${order.orderCode}</span>
                    </td>
                    <td colspan="2"></td>
                    <td></td>
                    <td></td>
                    <td class="jio-delete">
                        <a href="#"><i class="fas fa-trash-alt"></i></a>
                    </td>
                </tr>

                <tr class="jio-info">
                    <#list order.orderItems as orderItem>
                        <td class="info-td">
                            <img style="width: 80px; height: 80px;"
                                 src="../image/single/<#if orderItem.product.productImages[0].type =='type_single'>${orderItem.product.productImages[0].name}</#if>"
                                 alt="写真なし">
                        </td>
                        <td class="info-td">
                            <div class="jio-link">
                                <a href="#">${orderItem.product.name}</a>
                                <img title="クレジットカード支払い" src="../image/site/creditcard.png">
                            </div>
                        </td>
                        <td style="width: 100px;" class="info-td">
                            <div class="jio-op">￥${orderItem.product.originalPrice?string("0.00")}</div>
                            <div class="jio-pp">￥${orderItem.product.promotePrice?string("0.00")}</div>
                        </td>
                    </#list>
                    <td style="width: 100px;" class="info-td info-part" rowspan="1">
                        <span class="jio-num">${order.number}</span>
                    </td>
                    <td style="width: 120px;" class="info-td info-part" rowspan="1">
                        <div class="">￥${order.amount}</div>
                    </td>
                    <td style="width: 100px;" class="info-td info-part">
                        ${order.statusDesc}
                    </td>
                    <td style="width: 100px;" class="info-td info-part">
                        <#if order.status == "waitReview" >
                            <a href="../review/">
                                <button>評価</button>
                            </a>
                        </#if>

                        <#if order.status == "waitPay" >
                            <a href="pay?id=${order.id}&amount=${order.amount}">
                                <button>支払い</button>
                            </a>
                        </#if>

                        <#if order.status == "waitConfirm" >
                            <a href="confirmOrder?id=${order.id}">
                                <button>確認</button>
                            </a>
                        </#if>
                    </td>
                </tr>
                </tbody>
            </table>
        </#list>
    </div>
</div>


<#include "../../common/shop/footer.ftl">