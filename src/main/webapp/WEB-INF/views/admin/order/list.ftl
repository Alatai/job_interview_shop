<#include "../../common/admin/header.ftl">
<#include "../../common/admin/navbar.ftl">


<div class="container" style="min-width: 1340px;">
    <div class="bread-control">
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="#">サイト管理</a></li>
                <li class="breadcrumb-item active"
                    aria-current="page">オーダー管理
                </li>
            </ol>
        </nav>
    </div>

    <div>
        <input id="deleteUrl" type="hidden">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">状態</th>
                <th scope="col">金額</th>
                <th scope="col">商品数</th>
                <th scope="col">客名</th>
                <th scope="col">オーダー日時</th>
                <th scope="col">支払い日時</th>
                <th scope="col">配達日時</th>
                <th scope="col">確認日時</th>
                <th scope="col">操作</th>
            </tr>
            </thead>
            <tbody>
            <#list orders as order>
                <!-- Order -->
                <tr>
                    <td>${order.id}</td>
                    <td>${order.statusDesc}</td>
                    <td>￥${order.amount}</td>
                    <td>${order.number} 個</td>
                    <td>${order.user.name}</td>
                    <td>${order.createdDate?string("yyyy-MM-dd HH:mm:ss")}</td>
                    <td><#if order.paidDate??>${order.paidDate?string("yyyy-MM-dd HH:mm:ss")}</#if></td>
                    <td><#if order.deliveredDate??>${order.deliveredDate?string("yyyy-MM-dd HH:mm:ss")}</#if> </td>
                    <td><#if order.confirmedDate??>${order.confirmedDate?string("yyyy-MM-dd HH:mm:ss")}</#if></td>
                    <td>
                        <!-- <a href="#" onclick="showItems()"><i class="fas fa-tasks"></i></a>| -->
                        <a href="/jishop/admin/order/deliver?id=${order.id}"><i class="fas fa-truck"></i></a>
                    </td>
                </tr>
            </#list>

            <!-- OrderItem -->
            <tr>
                <table id="orderItems" class="table col-10 item-table">
                    <tr>
                        <#list orders as order>
                            <#list order.orderItems as orderItem>
                                <td>
                                    <img style="width: 50px;"
                                         src="../../image/single/<#if orderItem.product.productImages[0].type =='type_single'>${orderItem.product.productImages[0].name}</#if>"
                                         alt="暂无图片">
                                </td>
                                <td>${orderItem.product.name}</td>
                                <td>数 ${orderItem.number} 個</td>
                                <td>単価 ￥${orderItem.product.promotePrice}</td>
                            </#list>
                        </#list>
                    </tr>
                </table>
            </tr>

            </tbody>
        </table>
    </div>
</div>


<#include "../../common/admin/pagenav.ftl">
<#include "../../common/admin/footer.ftl">