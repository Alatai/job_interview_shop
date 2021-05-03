<#include "../../common/admin/header.ftl">
<#include "../../common/admin/navbar.ftl">


<div class="container">
    <div class="bread-control">
        <nav aria-label="breadcrumb">
            <div class="row">
                <ol class="breadcrumb col-11">
                    <li class="breadcrumb-item"><a href="javascript:">サイト管理</a></li>
                    <li class="breadcrumb-item active" aria-current="page">商品分類</li>
                </ol>
                <button type="button" class="btn btn-primary add-button" onclick="openCategoryEditModal(null)">追加
                </button>
            </div>
        </nav>
    </div>

    <div>
        <input id="deleteUrl" type="hidden">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">分類名称</th>
                <th scope="col">属性管理</th>
                <th scope="col">商品管理</th>
                <th scope="col">編集</th>
                <th scope="col">削除</th>
            </tr>
            </thead>
            <tbody>
            <#list categories as category>
                <tr>
                    <td>${category.id}</td>
                    <td>${category.name}</td>
                    <td><a href="/jishop/admin/property/list?cid=${category.id}"><i class="fas fa-tasks"></i></a></td>
                    <td>
                        <a href="/jishop/admin/product/list?cid=${category.id}"><i class="fas fa-shopping-cart"></i></a>
                    </td>
                    <td>
                        <a href="javascript:" onclick="openCategoryEditModal(${category.id})">
                            <input id="categoryName${category.id}" value="${category.name}" type="hidden">
                            <i class="fas fa-edit" data-toggle="modal" data-target="#editCotegory"></i>
                        </a>
                    </td>
                    <td>
                        <a href="javascript:" onclick="openCategoryDeleteModal(${category.id})">
                            <i class="fas fa-trash-alt"></i>
                        </a>
                    </td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
</div>


<#include "../../common/admin/pagenav.ftl">
<#include "../../admin/category/edit.ftl">
<#include "../../admin/category/delete.ftl">
<#include "../../common/admin/footer.ftl">