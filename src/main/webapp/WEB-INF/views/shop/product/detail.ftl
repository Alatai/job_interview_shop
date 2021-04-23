<#include "../../common/shop/header.ftl">
<#include "../../common/shop/navbar.ftl">


<div class="product-panel">
    <div class="ji-product">
        <div class="pd-img clear-fix">
            <img style="width: 400px;"
                 src="http://localhost:8080/jishop/image/single/<#if product.productImages[0].type =='type_single'>${product.productImages[0].name}</#if>"
                 alt="暂无图片">
        </div>

        <div class="pd-info">
            <div class="pd-title">${product.name}</div>
            <div class="pd-subtitle">${product.subtitle}</div>

            <div class="pd-price">
                <div class="price-panel">
                    <div class="op-price">
                        <span class="op-desc">价格</span>
                        <span class="op-symbol">￥</span>
                        <span class="op-num">${product.originalPrice}</span>
                    </div>

                    <div class="pro-price">
                        <span class="pro-desc">促销价</span>
                        <span class="pro-symbol">￥</span>
                        <span class="pro-num">${product.promotePrice}</span>
                    </div>
                </div>

                <div class="sale-review">
                    <div>销量 <span> 50</span></div>
                    <div>累计评价 <span> 19</span></div>
                </div>

                <div class="pd-num">
                    <span>数量</span>
                    <span>
                    <span class="pn-setting">
                        <input type="text" placeholder="1">
                    </span>
                    <span class="arrow">
                        <a class="pn-inc" href="#">
                            <span class="up-down"><img src="../image/site/increase.png" alt=""></span>
                        </a>

                        <span class="ud-middle"></span>

                        <a class="pn-dec" href="#">
                            <span class="up-down"><img src="../image/site/decrease.png" alt=""></span>
                        </a>
                    </span>
                件</span>
                    <span>库存${product.stock}件</span>
                </div>

                <div class="pd-buy">
                    <a href="#">
                        <button class="buy">立即购买</button>
                    </a>
                    <a href="#">
                        <button class="cart">
                            <i class="fas fa-shopping-cart"></i>加入购物车
                        </button>
                    </a>
                </div>
            </div>
        </div>
    </div>

    <div class="p-details">
        <div class="pd-top">
            <a class="detail" href="#">商品详情</a>
            <a class="review" href="#">累计评价 <span>19</span></a>
        </div>

        <div class="pd-property">
            <div>产品参数</div>
            <div class="pp-list clear-fix">
                <#list propertyValues as propertyValue>
                    <span>${propertyValue.property.name}: ${propertyValue.value}</span>
                </#list>
            </div>
        </div>

        <div>
            <img src="#" alt="">
        </div>
    </div>
</div>

