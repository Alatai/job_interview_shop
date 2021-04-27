<#include "../../common/shop/header.ftl">
<#include "../../common/shop/navbar.ftl">

<script type="text/javascript">
    $(function () {
        let stock = ${product.stock};

        // 在庫切り
        if (stock === 0) {
            $('#add2CartBtn').attr('disabled', 'disabled');
            $('#buyCurrently').attr('disabled', 'disabled');
        }

        // 購入数追加
        $('#purchaseNum').keyup(function () {
            let num = $(this).val();
            num = parseInt(num);

            if (isNaN(num))
                num = 1;
            if (num <= 0)
                num = 1;
            if (num > stock)
                num = stock;

            $(this).val(num);
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
                                $('#add2CartBtn').attr('disabled', 'disabled');
                                $('#add2CartBtn').css("background-color", "lightgray");
                                $('#add2CartBtn').css("border-color", "lightgray");
                                $('#add2CartBtn').css("color", "black");

                                $("#cartNum").html(${Session["cartNum"]} + 1);
                            }
                        }
                    });
                } else {
                    $('#loginModal').modal();
                }
            });
        });

        // すぐ購入する
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
                }
            });

            return true;
        });

        // 商品詳細と評価、クリックして交換
        $('.jir-content').hide();

        $('#productDetail').click(function () {
            $('#productReviews').removeClass('selected');
            $(this).addClass('selected');

            $('.jir-content').hide();
            $('.pd-property').show();
            $('#detailImage').show();

        });

        $('#productReviews').click(function () {
            $('#productDetail').removeClass('selected');
            $(this).addClass('selected');

            $('#detailImage').hide();
            $('.pd-property').hide();
            $('.jir-content').show();
        });
    });
</script>

<div class="product-panel">
    <div class="ji-product">
        <div class="pd-img clear-fix">
            <img style="width: 400px;"
                 src="../image/single/<#if product.productImages[0].type =='type_single'>${product.productImages[0].name}</#if>"
                 alt="写真なし">
        </div>

        <div class="pd-info">
            <div class="pd-title">${product.name}</div>
            <div class="pd-subtitle">${product.subtitle}</div>

            <div class="pd-price">
                <div class="price-panel">
                    <div class="op-price">
                        <span class="op-desc">原価</span>
                        <span class="op-symbol">￥</span>
                        <span class="op-num">${product.originalPrice}</span>
                    </div>

                    <div class="pro-price">
                        <span class="pro-desc">今の値段</span>
                        <span class="pro-symbol">￥</span>
                        <span class="pro-num">${product.promotePrice}</span>
                    </div>
                </div>

                <div class="sale-review">
                    <div>販売量 <span> ${product.saleCount}</span></div>
                    <div>評価数 <span> ${product.reviewCount}</span></div>
                </div>

                <div class="pd-num">
                    <span>数</span>
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
                    <span>在庫${product.stock}件</span>
                </div>

                <div class="pd-buy">
                    <a href="#">
                        <button id="buyCurrently" class="buy">今すく買う</button>
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
            <a id="productDetail" class="detail selected" href="#">商品詳細</a>
            <a id="productReviews" class="review " href="#">評価数 <span>${product.reviewCount}</span></a>
        </div>

        <div class="pd-property">
            <div>商品属性</div>
            <div class="pp-list clear-fix">
                <#list propertyValues as propertyValue>
                    <span>${propertyValue.property.name}: ${propertyValue.value}</span>
                </#list>
            </div>
        </div>

        <div id="detailImage">
            <#list product.detailImages as detailImage>
                <img src="../image/detail/${detailImage.name}" alt="">
            </#list>
        </div>

        <div class="jir-content">
            <#list reviews as review>
                <div class="jir-item clear-fix">
                    <div class="jir-info">
                        <div class="jir-desc">${review.content}</div>
                        <div class="jir-date">${review.createdDate?string("yyyy-MM-dd HH:mm:ss")}</div>
                    </div>
                    <div class="jir-user">
                        ${review.user.name}
                    </div>
                </div>
            </#list>
        </div>
    </div>

</div>

<#include "../../shop/product/loginModal.ftl">
<#include "../../common/shop/footer.ftl">
