<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>

<title>后台管理系统</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="content-type" content="text/html;charset=utf-8">

<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/fileinput.min.css'/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/bootstrap.css'/>" />
<script src="<c:url value='/js/jquery-1.8.3.min.js'/>" type="text/javascript"
	charset="utf-8"></script>


<script src="<c:url value='/js/bootstrap.min.js'/>"
	type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/js/application.js'/>" type="text/javascript"
	charset="utf-8"></script>


<script src="<c:url value='/js/fileinput.min.js'/>"
	type="text/javascript" charset="utf-8"></script>


</head>

<body>
	<div id="html_top" class="navbar-inverse  navbar-static-top"
		role="navigation">
		<jsp:include page="top.jsp"></jsp:include>
	</div>
	<div>
	<div class="container mycenter">
			<div id="html_left" class="col-lg-3">
				<jsp:include page="/admin/admin/left.jsp"></jsp:include>
			</div>
			<div id="html_content" class="col-lg-9 col-lg-offset-0">
				<jsp:include page="/admin/admin/welcom.jsp"></jsp:include>
			</div>
		</div>
	</div>
</body>

</html>