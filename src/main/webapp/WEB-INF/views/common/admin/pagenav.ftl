<nav aria-label="Page navigation example" style="margin-top: 100px;">
    <div class="container">
        <div class="page-nav">
            <ul class="pagination">
                <li class="page-item">
                    <a class="page-link" href="?currentPage=${pageInfo.prePage}<#if pageParam??>${pageParam}</#if>"
                       aria-label="Previous" <#if !pageInfo.hasPreviousPage>onclick="return false"</#if>>
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <#list 1..pageInfo.pages as no>
                    <li class="page-item">
                        <a class="page-link" href="?currentPage=${no}<#if pageParam??>${pageParam}</#if>">${no}</a>
                    </li>
                </#list>
                <li class="page-item">
                    <a class="page-link"
                       href="?currentPage=${pageInfo.nextPage}<#if pageParam??>${pageParam}</#if>" aria-label="Next"
                       <#if !pageInfo.hasNextPage>onclick="return false"</#if>>
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>
