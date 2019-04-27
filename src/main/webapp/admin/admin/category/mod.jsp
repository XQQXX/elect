<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
<title>My JSP 'add.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<script src="<c:url value='/js/jquery-1.8.3.min.js'/>" type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/bootstrap.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/css/fileinput.min.css'/>" />

<link rel="stylesheet" type="text/css" href="<c:url value='/css/bootstrap-theme.css'/>" />
<script src="<c:url value='/js/bootstrap.min.js'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/js/fileinput.min.js'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/js/application.js'/>" type="text/javascript" charset="utf-8"></script>



</head>
<style type="text/css">
.mycenter {
	margin-top: 10%;
}
</style>

<body>

	<div id="html_top"
		class="row navbar-inverse   navbar-static-top navbar-fixed-top"
		role="navigation">
		<jsp:include page="../top.jsp"></jsp:include>
	</div>

	<div class="container  mycenter">
		<div id="html_left" class="row col-lg-3">
			<jsp:include page="/admin/admin/left.jsp"></jsp:include>
		</div>
		<div class="row col-lg-9 col-lg-offset-0">
			<h1 class="page-header text-center text-info">修改分类</h1>
			<div class="container">

				<form action="<c:url value='/admin/category.category'/>"
					method="post">

					<div class="">
						<div class="form-inline col-lg-8">
							<input type="hidden" size="30" name="method" class="form-control"
								readonly="readonly" value="update" />
						</div>

						<div class="form-inline col-lg-8">
							<label for="CID">分类编号：</label> <input id="CID" type="text"
								size="30" name="cid" class="form-control" readonly="readonly"
								value="${cate.id }" />
						</div>

						<div class="form-inline col-lg-8">
							<label for="COLDName">分类名称：</label> <input id="COLDName"
								type="text" size="30" name="oldname" class="form-control"
								readonly="readonly" value="${cate.name}" />
						</div>

						<div class="form-inline col-lg-8">
							<label for="CName">新的分类名称：</label> <input id="CName" type="text"
								size="30" name="name" class="form-control"
								value="${cate.name}" />
						</div>

						<div class="col-lg-8">
							<label for="Cput">操作：</label> <input id="Cput" type="submit"
								class=" btn btn-danger form-control" value="修改分类" />
						</div>

						<div class="col-lg-8 text-danger text-center ">
							<p style="font-size: 20px;">${msg}</p>
						</div>
					</div>
				</form>

			</div>
		</div>
	</div>
</body>

</html>







