$(function () {
    $('#address').change(function () {
        var id=$(this).val();
        $.post('findAddress.order',{id:id},function (data) {
            $('#receiveName').val(data.receive_name);
            $('#fullAddress').val(data.full_address);
            $('#postalCode').val(data.postal_code);
            $('#phone').val(data.mobile);
            $('#mobile').val(data.phone);
        },'json')
    });
})