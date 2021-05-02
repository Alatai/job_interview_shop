<#include "../../common/shop/header.ftl">
<#include "../../common/shop/navbar.ftl">


<script>
    $(function () {
        $('#submitReviews').click(function () {
            let data = [];

            $('textarea[name="content"]').each(function () {
                let content = $(this).val();
                let pid = $(this).data('pid');
                let oid = $(this).data('oid');
                data.push({
                    'pid': pid,
                    'oid': oid,
                    'content': content
                })
            });

            $.ajax({
                url: 'http://localhost:8080/jishop/review/review.do',
                type: 'POST',
                contentType: 'application/json;charset=UTF-8',
                data: JSON.stringify(data),
                success: function (ret) {
                    if ('success' === ret) {
                        location.href = "http://localhost:8080/jishop/order/orders";
                    }
                }
            });
        });
    });
</script>

<div class="ji-review">
    <div class="jir-header clear-fix">
        <h3>商品評価</h3>
    </div>

    <div class="jir-body clear-fix">
        <ul>
            <#list orderItems as orderItem>
                <li class="clear-fix">
                    <div class="jir-product">
                        <a href="../product/detail?id=${orderItem.product.id}">
                            <img style="width: 200px; height: 130px;"
                                 src="../image/single/<#if orderItem.product.productImages[0].type =='type_single'>${orderItem.product.productImages[0].name}</#if>" alt="暂无图片">
                        </a>
                        <span style="position: relative;
    left: 100px;">
                            <#if orderItem.product.name?length gt 10>
                                ${orderItem.product.name?substring(0, 10)}
                            <#else>
                                ${orderItem.product.name}
                            </#if>
                        </span>
                    </div>

                    <div class="jir-main">
                        <div class="jir-bcg">
                            <label for=""></label>
                            <textarea name="content" id="" data-pid="${orderItem.pid}" data-oid="${orderItem.oid}" required></textarea>
                        </div>
                    </div>
                </li>
            </#list>
        </ul>
    </div>

    <div class="jir-submit">
        <button id="submitReviews">評価提出</button>
    </div>
</div>


<#include "../../common/shop/footer.ftl">