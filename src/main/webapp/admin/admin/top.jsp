<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
<title>TOP</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="content-type" content="text/html;charset=utf-8">

<body>
	<div class="container">
		<div class="page-header">
			<div class="text-right">
				<h3 class="text-center text-warning">后台管理
					
				</h3>
			</div>
			<div class="text-right">
				<c:if test="${not empty adminName}">
						<span  class="text-info text-right">欢迎 <a> ${ adminName } 管理员</a></span>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>