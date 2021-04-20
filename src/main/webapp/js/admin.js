$(function () {

});

/* common begin */
function deleteConfirm() {
    window.location.href = $.trim($("#deleteUrl").val());
}

/* common end */

/* category begin */
function openCategoryDeleteModal(id) {
    let url = "http://localhost:8080/jishop/admin/category/delete?id=" + id;
    $('#deleteUrl').val(url);
    $('#deleteCategory').modal();
}

function openCategoryEditModal(id) {
    if (id != null) {
        let categoryName = $('#categoryName' + id).val()

        $('#id').val(id);
        $('#name').val(categoryName);

        $('#editForm').attr('action', 'update');
    }

    $('#editModal').modal();
}

/* category end */

/* property begin */
function openPropertyDeleteModal(id) {
    let url = "http://localhost:8080/jishop/admin/property/delete?id=" + id;
    $('#deleteUrl').val(url);
    $('#deleteProperty').modal();
}

function openPropertyEditModal(id) {
    if (id != null) {
        let propertyName = $('#propertyName' + id).val()
        let categoryId = $('#categoryId' + id).val()

        $('#id').val(id);
        $('#name').val(propertyName);
        $('#cid').val(categoryId);

        $('#editForm').attr('action', 'update');
    }

    $('#editModal').modal();
}

/* property end */

/* product begin */
function openProductDeleteModal(id) {
    let url = "http://localhost:8080/jishop/admin/product/delete?id=" + id;
    $('#deleteUrl').val(url);
    $('#deleteProduct').modal();
}

function openProductEditModal(id) {
    if (id != null) {
        let productName = $('#productName' + id).val()
        let productSubtitle = $('#productSubtitle' + id).val()
        let productOriginalPrice = $('#productOriginalPrice' + id).val()
        let productPromotePrice = $('#productPromotePrice' + id).val()
        let productStock = $('#productStock' + id).val()
        let categoryId = $('#categoryId' + id).val()

        $('#id').val(id);
        $('#name').val(productName);
        $('#subtitle').val(productSubtitle);
        $('#originalPrice').val(productOriginalPrice);
        $('#promotePrice').val(productPromotePrice);
        $('#stock').val(productStock);
        $('#cid').val(categoryId);

        $('#editForm').attr('action', 'update');
    }

    $('#editModal').modal();
}

/* product end */

/* productImage begin */
function openImageDeleteModal(id) {
    console.log(id);
    let url = "http://localhost:8080/jishop/admin/image/delete?id=" + id;
    $('#deleteUrl').val(url);
    $('#deleteImage').modal();
}

/* productImage end */

