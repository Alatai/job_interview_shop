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
        let categoryId = $('#categoryId' + id).val()
        let categoryName = $('#categoryName' + id).val()

        $('#id').val(categoryId);
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
        let propertyId = $('#propertyId' + id).val()
        let propertyName = $('#propertyName' + id).val()
        let categoryId = $('#categoryId' + id).val()

        $('#id').val(propertyId);
        $('#name').val(propertyName);
        $('#cid').val(categoryId);

        $('#editForm').attr('action', 'update');
    }

    $('#editModal').modal();
}

/* property end */