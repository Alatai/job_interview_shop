<#include "../../common/admin/header.ftl">
<#include "../../common/admin/navbar.ftl">


<div class="container">
    <div class="bread-control">
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="#">すべての分類</a></li>
                <li class="breadcrumb-item"><a href="#">${category.name}</a></li>
                <li class="breadcrumb-item"><a href="#">${product.name}</a></li>
                <li class="breadcrumb-item active" aria-current="page">属性</li>
            </ol>
        </nav>
    </div>

    <div>
        <#list propertyValues as propertyValue>
        <div class="input-group col-6 property-edit">

                <div class="input-group-prepend">
                    <span class="input-group-text">${propertyValue.property.name}</span>
                </div>
                <input class="form-control" type="text" aria-label="First name" name="value"
                       value="${propertyValue.value}" data-id="${propertyValue.id}" data-pid="${propertyValue.pid}"
                       data-ptid="${propertyValue.ptid}">

        </div>
        </#list>
        <button type="button" class="btn btn-primary property-confirm"
                onclick="propertyEditConfirm()">確認
        </button>
    </div>
</div>


<#include "../../admin/pvalue/success.ftl">
<#include "../../common/admin/footer.ftl">




