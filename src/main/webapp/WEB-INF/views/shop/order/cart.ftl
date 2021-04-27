<#include "../../common/shop/header.ftl">
<#include "../../common/shop/navbar.ftl">


<script type="text/javascript">
    $(function () {
        // 削除
        $('.deleteItem').click(function () {
            let id = $(this).data('id');
            $('#deleteId').val(id);
            $('#deleteConfirm').modal();
        });

        // 削除確認
        $('#confirmBtn').click(function () {
            $('#deleteConfirm').modal('hide');

            // データベース更新
            let id = $('#deleteId').val();

            $.ajax({
                url: 'http://localhost:8080/jishop/order/deleteCartItem',
                type: 'type',
                contentType: 'application/json;charset=UTF-8',
                data: JSON.stringify({'id': id}),
                success: function (ret) {
                    if ('success' === ret) {
                        $('#orderItem' + id).remove();
                        $("#cartNum").html(${Session["cartNum"]} - 1);
                    } else {
                        location.href = 'http://localhost:8080/jishop/user/login';
                    }
                }
            });
        });

        // すべてを選択する
        $('.selectAll').click(function () {
            if (this.checked) {
                $('input[type="checkbox"]').prop("checked", true)
            } else {
                $('input[type="checkbox"]').prop("checked", false)
            }

            calculateAmount();
            changeBtn();
        });

        // 選択する
        $('.itemInfo').click(function () {
            if (this.checked) {
                $(this).prop("checked", true)
            } else {
                $(this).prop("checked", false)
            }

            if ($('.itemInfo:checked').length === Number($("#cartNum").html())) {
                $('.selectAll').prop("checked", true);
            } else {
                $('.selectAll').prop("checked", false);
            }

            calculateAmount();
            changeBtn();
        });

        // 数を増加
        $('.increase').click(function () {
            console.log(123);
            let id = $(this).data('id');
            let price = $(this).data('price');
            let stock = $('#stock' + id).val();
            let num = $('#num' + id).val();

            num++;

            if (num > stock) {
                num = stock;
            }

            // データベース更新
            updateCartItem(id, num, price);
        });

        // 数を減少
        $('.decrease').click(function () {
            let id = $(this).data('id');
            let price = $(this).data('price');
            let num = $('#num' + id).val();

            num--;

            if (num <= 0) {
                num = 1;
            }

            // データベース更新
            updateCartItem(id, num, price);
        });

        // 数値入力
        $('.numInput').keyup(function () {
            let id = $(this).data('id');
            let price = $(this).data('price');
            let stock = $('#stock' + id).val();
            let num = $(this).val();

            num = parseInt(num);

            if (isNaN(num))
                num = 1;
            if (num <= 0)
                num = 1;
            if (num > stock)
                num = stock;

            // データベース更新
            updateCartItem(id, num, price);
        });

        // 会計
        $('.jic-btn').click(function () {
            let params = "";

            $('.itemInfo').each(function () {
                if(this.checked) {
                    let id = $(this).data('id');
                    params += "&oiId=" + id;
                }
            });

            params = params.substring(1);
            location.href = "http://localhost:8080/jishop/order/submitOrder?" + params;
        });
    });

    // 金額と数の計算
    function calculateAmount() {
        let total = 0;
        let amount = 0;

        $('.itemInfo').each(function () {
            if (this.checked) {
                amount += $(this).data('price') * $(this).data('num');
                total++;
            }
        });

        $('.jic-price').html('￥' + Number(amount).toFixed(2));
        $('#selectedNum').html(total);
    }

    // ボタンの変更
    function changeBtn() {
        let hasSelected = false;

        $('input[type="checkbox"]').each(function () {
            if (this.checked) {
                hasSelected = true;
            }
        });

        if (hasSelected) {
            $('.jic-btn').css('background-color', '#f40');
            $('.jic-btn').removeAttr('disabled');
        } else {
            $('.jic-btn').css('background-color', '#aaa');
            $('.jic-btn').attr('disabled');
        }
    }

    //　データベースの更新
    function updateCartItem(id, num, price) {
        $('#num' + id).val(num);
        $('#subtotal' + id).html('￥' + Number(price * num).toFixed(2));

        // バックエンド
        $.ajax({
            url: 'http://localhost:8080/jishop/order/updateCartItem',
            type: 'post',
            contentType: 'application/json;charset=UTF-8',
            data: JSON.stringify({'id': id, 'num': num}),
            success: function (ret) {
                if ('success' !== ret) {
                    location.href = 'http://localhost:8080/jishop/user/login';
                }
            }
        });
    }
</script>

<div class="ji-cart ji-container">
    <div class="float-right clear-fix jic-title">
        <span>選択した商品 （運賃除く）</span>
        <span id="" class="jic-price">￥0.00</span>
        <button class="jic-btn" disabled="disabled">会 計</button>
    </div>

    <div class="jic-list">
        <table>
            <thead>
            <tr>
                <th>
                    <input class="selectAll" id="ji-selectAll-1" type="checkbox">
                    <label for="ji-selectAll-1">すべて</label>
                </th>
                <th>商品情報</th>
                <th>単価</th>
                <th>数</th>
                <th>金額</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <#list orderItems as orderItem>
                <tr id="orderItem${orderItem.id}">
                    <td>
                        <input class="itemInfo" type="checkbox" data-id="${orderItem.id}"
                               data-price="${orderItem.product.promotePrice}"
                               data-num="${orderItem.number}">
                        <img style="width: 40px;"
                             src="../image/single/<#if orderItem.product.productImages[0].type =='type_single'>${orderItem.product.productImages[0].name}</#if>"
                             alt="暂无图片">
                    </td>
                    <td class="jic-info">
                        <a href="../product/detail?id=${orderItem.product.id}">${orderItem.product.name}</a>
                        <img title="クレジットカード支払い" src="../image/site/creditcard.png">
                    </td>
                    <td>
                        <span class="jic-op">￥${orderItem.product.originalPrice?string("0.00")}</span>
                        <span class="jic-pp">￥${orderItem.product.promotePrice?string("0.00")}</span>
                    </td>
                    <td class="jic-num">
                        <input type="hidden" id="stock${orderItem.id}" value="${orderItem.product.stock}">
                        <a class="decrease" data-id="${orderItem.id}" data-price="${orderItem.product.promotePrice}"
                           href="#">-</a>
                        <input type="text" id="num${orderItem.id}" data-id="${orderItem.id}" class="numInput"
                               data-price="${orderItem.product.promotePrice}" value="${orderItem.number}"/>
                        <a class="increase" data-id="${orderItem.id}" data-price="${orderItem.product.promotePrice}"
                           href="#">+</a>
                    </td>
                    <td>
                        <span id="subtotal${orderItem.id}"
                              class="jic-pp">￥${(orderItem.product.promotePrice * orderItem.number)?string("0.00")}</span>
                    </td>
                    <td>
                        <a class="deleteItem" href="#" data-id="${orderItem.id}"><i class="fas fa-trash-alt"></i></a>
                    </td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>

    <div class="jic-footer">
        <div class="jic-checkbox">
            <input class="selectAll" id="ji-selectAll-2" type="checkbox">
            <label for="ji-selectAll-2">すべて</label>
        </div>

        <div class="float-right clear-fix">
            <span>選択した商品 <span id="selectedNum" style="color: #f40;">0</span> 件</span>
            <span>合計  （運賃除く）</span>
            <span class="jic-price" style="font-size: 22px;">￥0.00</span>
            <button class="jic-btn jic-downBtn" disabled="disabled">会 計</button>
        </div>
    </div>
</div>


<#include "../../shop/order/deleteModal.ftl">
<#include "../../common/shop/footer.ftl">
