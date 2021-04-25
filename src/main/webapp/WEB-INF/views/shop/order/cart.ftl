<#include "../../common/shop/header.ftl">
<#include "../../common/shop/navbar.ftl">


<div class="ji-cart ji-container">
    <div class="float-right clear-fix jic-title">
        <span>已选商品  （不含运费）</span>
        <span class="jic-price">￥0.00</span>
        <button class="jic-btn">结 算</button>
    </div>

    <div class="jic-list">
        <table>
            <thead>
            <tr>
                <th>
                    <input id="ji-selectAll-1" type="checkbox">
                    <label for="ji-selectAll-1">全选</label>
                </th>
                <th>商品信息</th>
                <th>单价</th>
                <th>数量</th>
                <th>金额</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <#list orderItems as orderItem>
                <tr>
                    <td>
                        <input id="" type="checkbox">
                        <img style="width: 40px;" src="http://localhost:8080/jishop/image/single/<#if orderItem.product.productImages[0].type =='type_single'>${orderItem.product.productImages[0].name}</#if>" alt="暂无图片">
                    </td>
                    <td class="jic-info">
                        <a href="../product/detail?id=${orderItem.product.id}">${orderItem.product.name}</a>
                        <img title="支持信用卡支付" src="../image/site/creditcard.png">
                    </td>
                    <td>
                        <span class="jic-op">￥${orderItem.product.originalPrice?string("0.00")}</span>
                        <span class="jic-pp">￥${orderItem.product.promotePrice?string("0.00")}</span>
                    </td>
                    <td class="jic-num">
                        <a href="#">-</a>
                        <input type="text" value="${orderItem.number}">
                        <a href="#">+</a>
                    </td>
                    <td>
                        <span class="jic-pp">￥${(orderItem.product.promotePrice * orderItem.number)?string("0.00")}</span>
                    </td>
                    <td>
                        <a href="#"><i class="fas fa-trash-alt"></i></a>
                    </td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>

    <div class="jic-footer">
        <div class="jic-checkbox">
            <input id="ji-selectAll-2" type="checkbox">
            <label for="ji-selectAll-2">全选</label>
        </div>

        <div class="float-right clear-fix">
            <span>已选商品 <span>0</span> 件</span>
            <span>合计  （不含运费）</span>
            <span class="jic-price">￥0.00</span>
            <button class="jic-btn jic-downBtn">结 算</button>
        </div>
    </div>
</div>


<#include "../../common/shop/footer.ftl">
