$(function () {
    //验证邮箱
    $('#txtEmail').blur(checkEmail);

    //验证昵称
    $('#txtNickName').blur(checkNickName);

    //验证密码
    $('#txtPassword').blur(checkPassword);

    //确认密码
    $('#txtRepeatPass').blur(checkPassword1);

    //确认验证码
    $('#txtVerifyCode').blur(checkCode)
});

function checkEmail() {
    var mail = $("#txtEmail").val().trim();
    var flag=false;
    if (mail == ""||mail==null) {
        $('#email_info').css('color', 'red');
        $('#email_info').get()[0].innerText = "邮箱不能为空哦";
        return false;
    }
    var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if (filter.test(mail)) {
        $.ajax({
            url: "checkEmail.user",
            data:{'email': mail},
            async: false,
            success:function (data) {
                if (data == "true") {
                    $('#email_info').css('color', 'green');
                    $('#email_info').text("邮箱合法！");
                    flag = true;
                } else {
                    $('#email_info').css('color', 'red');
                    $('#email_info').get()[0].innerText = "邮箱已存在，换个吧！"
                }
            }
            }
        )
        return flag;
    } else {
        $('#email_info').css('color', 'red');
        $('#email_info').get()[0].innerText = "邮箱格式错误。。";
        return false;
    }
}
function checkNickName() {
    var nickname=$('#txtNickName').val().trim();
    if(nickname==""||nickname==null){
        $('#name_info').css('color','red');
        $('#name_info').text("昵称不能为空哦");
        return false;
    }
    var filter = /^[\u4e00-\u9fa5a-zA-Z0-9_]+$/;
    if (nickname.length >= 4 && nickname.length < 20 && filter.test(nickname)) {
        $('#name_info').css('color','green');
        $('#name_info').text("昵称合法");
        return true;
    }else {
        $('#name_info').css('color','red');
        $('#name_info').text("昵称不合法哦，按照规定修改吧");
        return false;
    }
}
function checkPassword() {
    var password=$('#txtPassword').val().trim();
    if(password==""||password==null){
        $('#password_info').css('color','red');
        $('#password_info').text("密码不能为空哦！");
        return false;
    }
    var filter = /^[a-zA-Z0-9]+$/;
    if (password.length >= 6 && password.length < 20 && filter.test(password)) {
        $('#password_info').css('color','green');
        $('#password_info').text("密码合法");
        return true;
    }else {
        $('#password_info').css('color','red');
        $('#password_info').text("密码不合法哦，按照规定修改吧");
        return false;
    }
}
function checkPassword1() {
    var repeatPass=$('#txtRepeatPass').val().trim();
    if(repeatPass==""||repeatPass==null){
        $('#password1_info').css('color','red');
        $('#password1_info').text("请确认密码！");
        return false;
    }
    var password=$('#txtPassword').val().trim();
    if(repeatPass==password && repeatPass!=""){
        $('#password1_info').css('color','green');
        $('#password1_info').text("密码一致");
        return true;
    }else {
        $('#password1_info').css('color','red');
        $('#password1_info').text("密码不一致");
        return false;
    }
}
function checkCode() {
    var flag=false;
    var verifyCode=$('#txtVerifyCode').val().trim();
    if(verifyCode==""||verifyCode==null){
        $('#number_info').css('color','red');
        $('#number_info').text("验证码不能为空哦！")
        return flag;
    }
    $.ajax({
        url: 'checkVerifyCode.user',
        data: {'verifyCode': verifyCode},
        async: false,
        success: function (data) {
            if (data == "true") {
                $('#number_info').css('color', 'green');
                $('#number_info').text("验证码合法！");
                flag = true;
            } else {
                $('#number_info').css('color', 'red');
                $('#number_info').get()[0].innerText = "验证码有误，请重新输入吧！"
            }
        }
    })
    return flag;
}

function checkForm() {
    return checkEmail()&&checkNickName()&&checkPassword()&&checkPassword1()&&checkCode();
}
