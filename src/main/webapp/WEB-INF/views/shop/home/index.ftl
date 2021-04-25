<#include "../../common/shop/header.ftl">
<#include "../../common/shop/navbar.ftl">
<#include "../../common/shop/search.ftl">
<#include "../../shop/home/category.ftl">


<div class="ji-products">
    <#list categories as category>
        <#if category_index < 4>
            <div class="p-row clear-fix">
                <div class="left-mark"></div>
                <span class="c-title clear-fix">${category.name}</span>
                <#list category.products as product>
                    <#if product_index < 5>
                        <div class="p-item">
                            <a href="product/detail?id=${product.id}">
                                <img src="../jishop/image/single/<#if product.productImages[0].type =='type_single'>${product.productImages[0].name}</#if>"
                                     alt="暂无图片">
                            </a>
                            <a class="pd-link" href="#">
                                <span class="p-desc">[热销]${product.subtitle}</span>
                            </a>
                            <span class="p-price">${product.promotePrice}</span>
                        </div>
                    </#if>
                </#list>
            </div>
        </#if>
    </#list>
</div>


<#include "../../common/shop/footer.ftl">

