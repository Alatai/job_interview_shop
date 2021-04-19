<#include "../../common/admin/header.ftl">
<#include "../../common/admin/navbar.ftl">

<div class="container">
    <div class="bread-control">
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="#">サイト管理</a></li>
                <li class="breadcrumb-item"><a href="list?cid=${category.id}">${category.name}</a></li>
                <li class="breadcrumb-item active" aria-current="page">属性</li>
            </ol>
        </nav>
    </div>

    <div>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">属性名称</th>
                <th scope="col">編集</th>
                <th scope="col">削除</th>
            </tr>
            </thead>
            <tbody>
            <#list properties as property>
                <tr>
                    <td>${property.id}</td>
                    <td>${property.name}</td>
                    <td>
                        <a href="#" onclick="openPropertyEditModal(${property.id})">
                            <input id="propertyName${property.id}" value="${property.name}" type="hidden">
                            <input id="propertyId${property.id}" value="${property.id}" type="hidden">
                            <input id="categoryId${property.id}" value="${property.cid}" type="hidden">
                            <i class="fas fa-edit" data-toggle="modal" data-target="#editCotegory"></i>
                        </a>
                    </td>
                    <td>
                        <a href="#" onclick="openPropertyDeleteModal(${property.id})">
                            <input id="deleteUrl" type="hidden">
                            <i class="fas fa-trash-alt"></i>
                        </a>
                    </td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
</div>

<div class="container">
    <button type="button" class="btn btn-primary" data-toggle="modal" onclick="openPropertyEditModal(null)">追加</button>
</div>


<#include "../../common/admin/pagenav.ftl">
<#include "../../admin/property/edit.ftl">
<#include "../../admin/property/delete.ftl">
<#include "../../common/admin/footer.ftl">