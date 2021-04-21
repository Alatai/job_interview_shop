<#include "../../common/shop/header.ftl">
<#include "../../common/shop/navbar.ftl">
<#include "../../common/shop/search.ftl">

<script type="text/javascript" src="js/slider.js"></script>

<div class="main">
    <div class="row">
        <div class="slider">
            <ul>
                <li>
                    <a href="#"><img src="../jishop/image/site/slider01.jpg" alt=""></a>
                </li>
            </ul>
        </div>

        <#list categories as category>
            <div class="category">
                <div class="header clear-fix">
                    <div class="left">
                        <h2 class="name"><a href="#">${category.name}</a></h2>
                    </div>

                    <div class="right">
                        <a href="#" class="more">更多 &gt;</a>
                    </div>
                </div>
                <div class="content clear-fix">
                    <#list category.products as product>
                        <#if product_index < 4>
                            <div class="product">
                                <div class="image-link">
                                    <a href="#">
                                        <img src="../jishop/image/single/<#if product.productImages[0].type =='type_single'>${product.productImages[0].name}</#if>"
                                             alt="暂无图片">
                                    </a>
                                </div>
                                <div class="info">
                                    <div class="tags">
                                        <span></span>
                                        <span class="tag limit">${product.name}</span>
                                    </div>
                                    <h4 class="name">
                                        <a href="#">${product.subtitle}</a>
                                    </h4>
                                    <p class="price">
                        <span class="op">
                            <span>￥</span><span>${product.promotePrice}</span>
                        </span>
                                        <span class="pp">
                            <span>￥</span><span>${product.originalPrice}</span>
                        </span>
                                    </p>
                                </div>
                            </div>
                        </#if>
                    </#list>
                </div>
            </div>
        </#list>
    </div>
</div>


<#include "../../common/shop/footer.ftl">

