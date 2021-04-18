$(function () {

});

function openDeleteModal(id) {
    let url = "http://localhost:8080/jishop/admin/category/delete?id=" + id;
    $('#deleteUrl').val(url);
    $('#deleteCategory').modal();
}

function deleteConfirm() {
    window.location.href = $.trim($("#deleteUrl").val());
}

function openEditModal(id) {
    if (id != null) {
        let categoryId = $('#categoryId' + id).val()
        let categoryName = $('#categoryName' + id).val()

        $('#id').val(categoryId);
        $('#name').val(categoryName);

        $('#editForm').attr('action', 'update');
    }

    $('#editModal').modal();
}