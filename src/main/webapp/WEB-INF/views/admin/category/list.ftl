<#include "../../common/admin/header.ftl">
<#include "../../common/admin/navbar.ftl">


<div class="container">
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
                <td><a href="#"><i class="fas fa-tasks"></i></a></td>
                <td><a href="#"><i class="fas fa-shopping-cart"></i></a></td>
                <td>
                    <a href="#" onclick="openEditModal(${category.id})">
                        <input id="categoryName${category.id}" value="${category.name}" type="hidden">
                        <input id="categoryId${category.id}" value="${category.id}" type="hidden">
                        <i class="fas fa-edit" data-toggle="modal" data-target="#editCotegory"></i>
                    </a>
                </td>
                <td>
                    <a href="#" onclick="openDeleteModal(${category.id})">
                        <i class="fas fa-trash-alt"></i>
                    </a>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>

<div class="container">
    <button type="button" class="btn btn-primary" data-toggle="modal" onclick="openEditModal(null)">追加</button>
</div>


<#include "../../common/admin/pagenav.ftl">
<#include "../../admin/category/edit.ftl">
<#include "../../admin/category/add.ftl">
<#include "../../admin/category/delete.ftl">
<#include "../../common/admin/footer.ftl">