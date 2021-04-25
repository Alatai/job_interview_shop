<#include "../../common/shop/header.ftl">
<#include "../../common/shop/navbar.ftl">

<script type="text/javascript">
    $(function () {
        let stock = ${product.stock};

        // 購入数追加
        $('#purchaseNum').keyup(function () {
            let num = $('#purchaseNum').val();
            num = parseInt(num);

            if (isNaN(num))
                num = 1;
            if (num <= 0)
                num = 1;
            if (num > stock)
                num = stock;

            $('#purchaseNum').val(num);
        });

        // 追加click
        $('#increaseNum').click(function () {
            let num = $('#purchaseNum').val();
            num++;
            num = num > stock ? stock : num;

            $('#purchaseNum').val(num);
        });

        // 減少click
        $('#decreaseNum').click(function () {
            let num = $('#purchaseNum').val();
            num--;
            num = num <= 0 ? 1 : num;

            $('#purchaseNum').val(num);
        });

        // ショッピングカート
        $('#add2CartBtn').removeAttr('disable');
        $('#add2Cart').click(function () {
            $.get('http://localhost:8080/jishop/user/checkLogin', function (ret) {
                if ('success' === ret) {
                    let pid = ${product.id};
                    let num = $('#purchaseNum').val();
                    let data = {'pid': pid, 'num': num};

                    $.ajax({
                        url: 'http://localhost:8080/jishop/order/add2Cart',
                        type: 'POST',
                        contentType: 'application/json;charset=UTF-8',
                        data: JSON.stringify(data),
                        success: function (ret) {
                            if ('success' === ret) {
                                $('#add2CartBtn').html('追加しました');
                                $('#add2CartBtn').attr('disable', 'disable');
                                $('#add2CartBtn').css("background-color", "lightgray");
                                $('#add2CartBtn').css("border-color", "lightgray");
                                $('#add2CartBtn').css("color", "black");
                            }
                        }
                    });
                } else {
                    $('#loginModal').modal();
                }
            });
        });

        // スク購入する
        $('#buyCurrently').click(function () {
            $.get('http://localhost:8080/jishop/user/checkLogin', function (ret) {
                if ('success' === ret) {
                    let pid = ${product.id};
                    let num = $('#purchaseNum').val();

                    location.href = 'http://localhost:8080/jishop/order/buyCurrently?pid='
                        + pid + '&num=' + num;
                } else {
                    $('#loginModal').modal();
                }
            });
        });

        //  モーダルログイン
        $('#modalLoginBtn').click(function () {
            let name = $('#name').val();
            let password = $('#password').val();
            let data = {'name': name, 'password': password};

            $.ajax({
                url: 'http://localhost:8080/jishop/user/modalLogin',
                type: 'POST',
                contentType: 'application/json;charset=UTF-8',
                data: JSON.stringify(data),
                success: function (ret) {
                    if (ret === 'success') {
                        location.reload();
                    } else {
                        console.log('error');
                    }
                },
            });

            return true;
        });
    });
</script>

<div class="product-panel">
    <div class="ji-product">
        <div class="pd-img clear-fix">
            <img style="width: 400px;"
                 src="http://localhost:8080/jishop/image/single/<#if product.productImages[0].type =='type_single'>${product.productImages[0].name}</#if>"
                 alt="暂无图片">
        </div>

        <div class="pd-info">
            <div class="pd-title">${product.name}</div>
            <div class="pd-subtitle">${product.subtitle}</div>

            <div class="pd-price">
                <div class="price-panel">
                    <div class="op-price">
                        <span class="op-desc">价格</span>
                        <span class="op-symbol">￥</span>
                        <span class="op-num">${product.originalPrice}</span>
                    </div>

                    <div class="pro-price">
                        <span class="pro-desc">促销价</span>
                        <span class="pro-symbol">￥</span>
                        <span class="pro-num">${product.promotePrice}</span>
                    </div>
                </div>

                <div class="sale-review">
                    <div>销量 <span> ${product.saleCount}</span></div>
                    <div>累计评价 <span> ${product.reviewCount}</span></div>
                </div>

                <div class="pd-num">
                    <span>数量</span>
                    <span>
                    <span class="pn-setting">
                        <input id="purchaseNum" value="1" type="text" placeholder="1">
                    </span>
                    <span class="arrow">
                        <a id="increaseNum" class="pn-inc" href="#">
                            <span class="up-down"><img src="../image/site/increase.png" alt=""></span>
                        </a>

                        <span class="ud-middle"></span>

                        <a id="decreaseNum" class="pn-dec" href="#">
                            <span class="up-down"><img src="../image/site/decrease.png" alt=""></span>
                        </a>
                    </span>
                件</span>
                    <span>库存${product.stock}件</span>
                </div>

                <div class="pd-buy">
                    <a id="buyCurrently" href="#">
                        <button id="buy" class="buy">今すく買う</button>
                    </a>
                    <a id="add2Cart" href="#">
                        <button id="add2CartBtn" class="cart">
                            <i class="fas fa-shopping-cart"></i>カートに入れる
                        </button>
                    </a>
                </div>
            </div>
        </div>
    </div>

    <div class="p-details">
        <div class="pd-top">
            <a class="detail" href="#">商品详情</a>
            <a class="review" href="#">累计评价 <span>${product.reviewCount}</span></a>
        </div>

        <div class="pd-property">
            <div>产品参数</div>
            <div class="pp-list clear-fix">
                <#list propertyValues as propertyValue>
                    <span>${propertyValue.property.name}: ${propertyValue.value}</span>
                </#list>
            </div>
        </div>

        <div>
            <#list product.detailImages as detailImage>
                <img src="../image/detail/${detailImage.name}" alt="">
            </#list>
        </div>
    </div>
</div>

<#include "../../shop/product/loginModal.ftl">
<#include "../../common/shop/footer.ftl">
