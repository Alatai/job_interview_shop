<#include "../../common/shop/header.ftl">
<#include "../../common/shop/navbar.ftl">


<div class="ji-account">
    <div class="ji-address">
        <div class="ja-tip">输入收获地址</div>

        <div class="ja-detail">
            <div>
                <label for="address">详细地址<span>*</span></label>
                <textarea id="address" name="address"></textarea>
            </div>

            <div>
                <label for="postCode">邮政编码<span>*</span></label>
                <input id="postCode" name="postCode" type="text">
            </div>

            <div>
                <label for="receiver">收货人姓名<span>*</span></label>
                <input id="receiver" name="receiver" type="text">
            </div>

            <div>
                <label for="phoneNumber">手机号码<span>*</span></label>
                <input id="phoneNumber" name="phoneNumber" type="text">
            </div>
        </div>
    </div>

    <div class="ja-confirm" style="margin-top: 50px;">
        <div class="ja-tip">确认订单信息</div>

        <table>
            <thead>
            <tr>
                <th colspan="2">JI SHOP</th>
                <th>单价</th>
                <th>数量</th>
                <th>小计</th>
                <th>配送方式</th>
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
                        <img style="width:50px;" src="http://localhost:8080/jishop/image/single/<#if orderItem.product.productImages[0].type =='type_single'>${orderItem.product.productImages[0].name}</#if>" alt="暂无">
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
                        <label class=""></label>
                        <input type="radio" checked="checked" value="">
                        普通配送
                        <select class="">
                            <option>快递 免邮费</option>
                        </select>
                    </td>
                </tr>
            </#list>
            </tbody>
        </table>

        <div class="jo-sum clear-fix">
            <span class="float-right">店铺合计(含运费): ￥${amount}</span>
        </div>

        <div class="jo-total clear-fix">
            <div class="float-right">
                <span>实付款：</span>
                <span class="total">￥${amount?string("0.00")}</span>
            </div>
        </div>

        <div class="clear-fix">
            <button class="float-right">提交订单</button>
        </div>
    </div>
</div>


<#include "../../common/shop/footer.ftl">