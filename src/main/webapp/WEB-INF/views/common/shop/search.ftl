<div class="func-nav">
    <div class="row">
        <div class="left">
            <a class="logo" href="index">
                <img src="../jishop/image/site/logo.png" alt="Job Interview Shop">
                <span>Job Interview Shop</span>
            </a>
        </div>

        <div class="search">
            <div class="wrap">
                <i class="fas fa-search"></i>
                <input type="text">
                <span>検索キーワード</span>
            </div>

            <div class="button">
                <span>検索</span>
            </div>

            <div class="word-list">
                <#list 0..3 as i>
                    <a class="hot-list">${categories[i].name}</a>
                </#list>
            </div>
        </div>
    </div>
</div>