<#include "../../common/admin/header.ftl">
<#include "../../common/admin/navbar.ftl">


<div class="container">
    <div class="bread-control">
        <nav aria-label="breadcrumb">
            <div class="row">
                <ol class="breadcrumb col-11">
                    <li class="breadcrumb-item"><a href="#">すべての分類</a></li>
                    <li class="breadcrumb-item"><a href="#">${category.name}</a></li>
                    <li class="breadcrumb-item active" aria-current="page">商品</li>
                </ol>
                <button type="button" class="btn btn-primary add-button" onclick="openProductEditModal(null)">追加</button>
            </div>
        </nav>
    </div>

    <div>
        <input id="deleteUrl" type="hidden">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">写真</th>
                <th scope="col">商品名称</th>
                <th scope="col">サブタイトル</th>
                <th scope="col">値段</th>
                <th scope="col">割引</th>
                <th scope="col">在庫数</th>
                <th scope="col">写真管理</th>
                <th scope="col">属性設定</th>
                <th scope="col">編集</th>
                <th scope="col">削除</th>
            </tr>
            </thead>
            <tbody>
            <#list products as product>
                <tr>
                    <td>${product.id}</td>
                    <td>
                        <img src="#" alt="暂无图片">
                    </td>
                    <td>${product.name}</td>
                    <td>${product.subtitle}</td>
                    <td>${product.originalPrice}</td>
                    <td>${product.promotePrice}</td>
                    <td>${product.stock}</td>
                    <td><a href="/jishop/admin/image/list?pid=${product.id}"><i class="fas fa-images"></i></a></td>
                    <td><a href="/jishop/admin/pvalue/edit?pid=${product.id}"><i class="fas fa-tasks"></i></a></td>
                    <td>
                        <a href="#" onclick="openProductEditModal(${product.id})">
                            <input type="hidden" id="productName${product.id}" value="${product.name}">
                            <input type="hidden" id="productSubtitle${product.id}" value="${product.subtitle}">
                            <input type="hidden" id="productOriginalPrice${product.id}" value="${product.originalPrice}">
                            <input type="hidden" id="productPromotePrice${product.id}" value="${product.promotePrice}">
                            <input type="hidden" id="productStock${product.id}" value="${product.stock}">
                            <input type="hidden" id="categoryId${product.id}" value="${product.cid}">
                            <i class="fas fa-edit" data-toggle="modal"></i>
                        </a>
                    </td>
                    <td>
                        <a href="#" onclick="openProductDeleteModal(${product.id})">
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
<#include "../../admin/product/edit.ftl">
<#include "../../admin/product/delete.ftl">
<#include "../../common/admin/footer.ftl">