$(function () {

    $('#txtUsername').blur(checkEmail);

    $('#txtPassword').blur(checkPassword);
});
function checkPassword() {
    var password=$('#txtPassword').val().trim();
    if(password==""||password==null){
        $('#passwordMsg').css('color','red');
        $('#passwordMsg').text("密码不能为空哦");
        return false;
    }else{
        $('#passwordMsg').text("");
        return true;
    }
}
function checkEmail() {
    var username=$('#txtUsername').val().trim();
    if(username==""||username==null){
        $('#usernameMsg').css('color','red');
        $('#usernameMsg').text("邮箱不能为空哦");
        return false;
    }else {
        $('#usernameMsg').text("");
        return true;
    }
}

function checkSubmit() {
    return checkEmail()&&checkPassword();
}