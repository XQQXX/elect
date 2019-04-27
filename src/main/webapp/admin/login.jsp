<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>

<title>商城后台管理系统</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="content-type" content="text/html;charset=utf-8">

<script src="<c:url value='/js/jquery-1.8.3.min.js'/>" type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value='../css/bootstrap.css'/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/bootstrap-theme.css'/>" />

<script src="<c:url value='../js/application.js'/>" type="text/javascript"
	charset="utf-8"></script>
<script src="<c:url value='../js/bootstrap.min.js'/>"
	type="text/javascript" charset="utf-8"></script>


<style type="text/css">
</style>
<script type="text/javascript">
			$(function(){
				
				var bool = false;
				$("#exampleInputCname").blur(function() {
					if(!$("#exampleInputCname").val()) {
						$("#unameError").text("账号不能为空");
						bool = false;
					} else {
						$("#unameError").text("");
						bool = true;
					}
				});

				$("#exampleInputPwd").blur(function() {
					if(!$("#exampleInputPwd").val()) {
						$("#pwdError").text("密码不能为空");
						bool = false;
					} else {
						$("#pwdError").text("");
						bool = true;
					}
				});

				$("#go_form").click(function() {
					
					if(bool) {
						$("form").submit();
					}else{
						$("#form_error").text("不能加载,请先输入账户密码");
					}
					
				});
				
			});

			function shengqing() {
				alert("请自主联系管理员,电话12341234");
			}
		</script>
</head>

<body>
	<div class="container">

		<div class="clearfix"></div>
		<div class="row">
			<div class="alert alert-warning alert-dismissable">
				<button type="button" class="close" data-dismiss="alert"
					aria-hidden="true">&times;</button>
				<strong>友情提示!</strong> 为了更好的为您服务,请先登录先 . . .
			</div>
		</div>
		<div class="row">
			<h1 class="page-header text-center text-primary">管理员登录</h1>
		</div>
		<div class="row col-lg-6 col-lg-offset-3">
			<form action="login.admin" method="post">
				<div class="form-group">

					<div class="form-inline">
						<div>
							<label for="exampleInputCname">管理员账号</label> <input type="text"
								name="name" class="form-control" id="exampleInputCname"
								placeholder="Enter AdminName">
						</div>
						<div class="text-right">
							<lable id="unameError" class="text-danger">&nbsp;</lable>
						</div>
					</div>

					<div class="form-inline">
						<div>
							<label for="exampleInputPwd">管理员密码</label> <input type="password"
								name="password" class="form-control" id="exampleInputPwd"
								placeholder="Enter AdminPassWord">
						</div>
						<div class="text-right">
							<label id="pwdError" class="text-danger">&nbsp;</label>
						</div>
					</div>
					<div class="form-inline">
						<div class="text-right">
							<span id="form_error" class="text-danger">${msg }</span>
						</div>
					</div>

					<div class="form-inline">
						<input id="go_form" type="button" class="btn btn-primary"
							value="进入后台" />
					</div>
				</div>
			</form>
		</div>

	</div>
</body>

</html>

