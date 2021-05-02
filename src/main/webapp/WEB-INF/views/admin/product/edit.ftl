<div class="modal fade" id="editModal" tabindex="-1" aria-labelledby="editLabel" aria-hidden="true">
    <form id="editForm" action="add" method="post" enctype="multipart/form-data">
        <input id="id" name="id" type="hidden">
        <input id="cid" name="cid" type="hidden" value="${category.id}">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="editTitle">商品</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="name">商品名称</label>
                        <input type="text" class="form-control" id="name" name="name" placeholder="商品名称">
                    </div>
                    <div class="form-group">
                        <label for="subtitle">サブタイトル</label>
                        <input type="text" class="form-control" id="subtitle" name="subtitle" placeholder="サブタイトル">
                    </div>
                    <div class="form-group">
                        <label for="originalPrice">原価</label>
                        <input type="text" class="form-control" id="originalPrice" name="originalPrice" placeholder="原価">
                    </div>
                    <div class="form-group">
                        <label for="promotePrice">今の値段</label>
                        <input type="text" class="form-control" id="promotePrice" name="promotePrice" placeholder="今の値段">
                    </div>
                    <div class="form-group">
                        <label for="stock">在庫数</label>
                        <input type="text" class="form-control" id="stock" name="stock" placeholder="在庫数">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">戻る</button>
                    <button type="submit" class="btn btn-primary">提出</button>
                </div>
            </div>
        </div>
    </form>
</div>