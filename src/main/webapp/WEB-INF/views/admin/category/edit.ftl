<div class="modal fade" id="editModal" tabindex="-1" aria-labelledby="editLabel" aria-hidden="true">
    <form action="update" method="post" enctype="multipart/form-data">
        <input id="id" name="id" type="hidden">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="editTitle">商品分類追加</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="name">分類名称</label>
                        <input type="text" class="form-control" id="name" name="name" placeholder="名称">
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