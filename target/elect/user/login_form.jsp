<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>登录 - 当当网</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
        <script type="text/javaScript" src="../js/jquery-1.8.3.min.js"></script>
        <script type="text/javascript" src="../js/login-form.js"></script>
	</head>
	<body>

		<%@include file="../common/head1.jsp"%>

		<div class="enter_part">

			<%@include file="../common/introduce.jsp"%>

			<div class="enter_in">
				<div class="bj_top"></div>
				<div class="center">
					<div style="height: 30px; padding: 5px; color: red"
						id="divErrorMssage">

					</div>
					<div class="main">
						<h3>
							登录当当网
						</h3>

						<form method="post" action="login_form.user" id="ctl00" onsubmit="return checkSubmit()">
							<ul>
								<li>
									<span>请输入Email地址：</span>
									<input type="text" name="name" id="txtUsername" class="textbox" />
                                    <span id="usernameMsg" style="float: right"></span>
								</li>
                                <br/>
								<li>
									<span class="blank">密码：</span>
									<input type="password" name="password" id="txtPassword" class="textbox" />
                                    <span id="passwordMsg" style="float: right"></span>
								</li>
                                <br/>
                                &nbsp&nbsp&nbsp&nbsp&nbsp<span style="color: red">${login_error}</span>
								<li>
									<input type="submit" id="btnSignCheck" class="button_enter"
										value="登 录" />
								</li>
							</ul>
							<input type="hidden" name="uri" value="${uri}" />
						</form>
					</div>
					<div class="user_new">
						<p>
							您还不是当当网用户？
						</p>
						<p class="set_up">
							<a href="register_form.jsp">创建一个新用户&gt;&gt;</a>
						</p>
					</div>
				</div>
			</div>
		</div>

		<%@include file="../common/foot1.jsp"%>

	</body>
</html>

