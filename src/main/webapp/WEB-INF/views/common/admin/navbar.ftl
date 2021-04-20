<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="#">サイト管理</a>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item <#if categories??>active</#if>">
                    <a class="nav-link" href="/jishop/admin/category/list">分類管理</a>
                </li>
                <li class="nav-item <#if users??>active</#if>">
                    <a class="nav-link" href="/jishop/admin/user/list">ユーザ管理</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#" tabindex="-1" aria-disabled="true">オーダー管理</a>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="検索" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">検索</button>
            </form>
        </div>
    </div>
</nav>