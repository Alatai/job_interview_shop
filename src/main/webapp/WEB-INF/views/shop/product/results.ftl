<#include "../../common/shop/header.ftl">
<#include "../../common/shop/navbar.ftl">
<#include "../../common/shop/search.ftl">


<div class="jip-container clear-fix">
    <#list products as product>
        <div class="jip-item">
            <div class="jip-wrap">
                <div class="jip-img">
                    <a href="detail?id=${product.id}">
                        <img src="../image/single/<#if product.productImages[0].type =='type_single'>${product.productImages[0].name}</#if>" alt="">
                    </a>
                </div>
                <p class="jip-price"><span>￥</span>${product.promotePrice}</p>
                <p class="jip-title">
                    <a href="">
                        <#if product.name?length gt 20>
                            ${product.name?substring(0, 20)}
                        <#else>
                            ${product.name}
                        </#if>
                    </a>
                </p>
                <p class="jip-info">
                    <span>成交 <span>${product.saleCount}</span></span>
                    <span>评价 <span>${product.reviewCount}</span></span>
                </p>
            </div>
        </div>
    </#list>
</div>



<#include "../../common/shop/footer.ftl">