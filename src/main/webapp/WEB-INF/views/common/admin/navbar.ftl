<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="#">JI SHOP 管理</a>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item <#if categories??>active</#if>">
                    <a class="nav-link" href="/jishop/admin/category/list">分類管理</a>
                </li>
                <li class="nav-item <#if users??>active</#if>">
                    <a class="nav-link" href="/jishop/admin/user/list">ユーザ管理</a>
                </li>
                <li class="nav-item <#if orders??>active</#if>">
                    <a class="nav-link" href="/jishop/admin/order/list">オーダー管理</a>
                </li>
            </ul>
        </div>
    </div>
</nav>