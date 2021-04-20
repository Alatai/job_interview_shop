<#include "../../common/admin/header.ftl">
<#include "../../common/admin/navbar.ftl">


<div class="container">
    <div class="bread-control">
        <nav aria-label="breadcrumb">
            <div class="row">
                <ol class="breadcrumb col-11">
                    <li class="breadcrumb-item"><a href="#">サイト管理</a></li>
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
                <th scope="col">ユーザネーム</th>
            </tr>
            </thead>
            <tbody>
            <#list users as user>
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
</div>


<#include "../../common/admin/pagenav.ftl">
<#include "../../common/admin/footer.ftl">