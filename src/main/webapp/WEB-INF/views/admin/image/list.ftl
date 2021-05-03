<#include "../../common/admin/header.ftl">
<#include "../../common/admin/navbar.ftl">


<div class="container">
    <div class="bread-control">
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="javascript:">すべての分類</a></li>
                <li class="breadcrumb-item"><a href="/jishop/admin/product/list?cid=${category.id}">${category.name}</a>
                </li>
                <li class="breadcrumb-item">
                    <a href="javascript:">
                        <#if product.name?length gt 10>
                            ${product.name?substring(0, 10)}
                        <#else>
                            ${product.name}
                        </#if>
                    </a>
                </li>
                <li class="breadcrumb-item active" aria-current="page">商品写真管理</li>
            </ol>
        </nav>
    </div>

    <div class="row">
        <div class="card col" style="width: 18rem;">
            <div class="card-body">
                <div>
                    <h5 class="card-title">商品写真</h5>
                    <p class="card-text">商品の写真（normal size）</p>
                    <form action="add" method="post" enctype="multipart/form-data">
                        <input type="file" name="image">
                        <input type="hidden" name="pid" value="${product.id}">
                        <input type="hidden" name="type" value="type_single">
                        <button type="submit" class="btn btn-primary">提出</button>
                    </form>
                </div>

                <div class="image-table">
                    <input id="deleteUrl" type="hidden">
                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">商品写真</th>
                            <th scope="col">削除</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list singleImages as singleImage>
                            <tr>
                                <td>${singleImage.id}</td>
                                <td>
                                    <a href="../../image/single/${singleImage.name}">
                                        <img height="50px" src="../../image/single/${singleImage.name}" alt="暂无图片">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:" onclick="openImageDeleteModal(${singleImage.id})">
                                        <i class="fas fa-trash-alt"></i>
                                    </a>
                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <div class="card col" style="width: 18rem;">
            <div class="card-body">
                <div>
                    <h5 class="card-title">商品紹介</h5>
                    <p class="card-text">商品を紹介するための写真（large size）</p>
                    <form action="add" method="post" enctype="multipart/form-data">
                        <input type="file" name="image">
                        <input type="hidden" name="pid" value="${product.id}">
                        <input type="hidden" name="type" value="type_detail">
                        <button type="submit" class="btn btn-primary">提出</button>
                    </form>
                </div>


                <div class="image-table">
                    <input id="deleteUrl" type="hidden">
                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">商品宣伝写真</th>
                            <th scope="col">削除</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list detailImages as detailImage>
                            <tr>
                                <td>${detailImage.id}</td>
                                <td>
                                    <a href="../../image/detail/${detailImage.name}">
                                        <img height="50px" src="../../image/detail/${detailImage.name}" alt="暂无图片">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:" onclick="openImageDeleteModal(${detailImage.id})">
                                        <i class="fas fa-trash-alt"></i>
                                    </a>
                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>


<#include "../../admin/image/delete.ftl">
<#include "../../common/admin/footer.ftl">