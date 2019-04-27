<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>菜单</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
</head>

<body>
	<div class="">
	<div>
	<h2 class="page-header text-primary">产品管理系统</h2>
		<div class="form-group row">
			<!-- 第一个 -->
			<div class="dropdown">
				<a data-toggle="dropdown" class="btn btn-primary btn-block" href="#">分类管理</a>
				<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
					<li>
                        <a href="<c:url value='/admin/categoryList.category'/>">查看分类</a>
					</li>
					<li>
						<a href="<c:url value='/admin/admin/category/add.jsp'/>">添加分类</a>
					</li>
				</ul>
			</div>
		</div>
		<!-- 第一个 -->

		<div class="row form-group">
			<!-- 第二个 -->
			<div class="dropdown">
				<a data-toggle="dropdown" class="btn btn-primary   btn-block" href="#">图书管理</a>
				<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
					<li>
						<a href="<c:url value='/admin/bookList.book'/>">查看图书</a>
					</li>
					<li>
						<a href="<c:url value='/admin/admin/book/add.jsp'/>">添加图书</a>
					</li>
				</ul>
			</div>
		</div>
		<!-- 第二个 -->

		<div class="row form-group">
			<!-- 第三个 -->
			<div class="dropdown">
				<a data-toggle="dropdown" class="btn btn-primary   btn-block" href="#">订单管理</a>
				<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
					<li>
						<a href="<c:url value='/ManagerOrderServlet?method=All_ORDERS'/>">所有订单</a>
					</li>
					<li>
						<a href="<c:url value='/ManagerOrderServlet?method=all_no_pay'/>">未付款订单</a>
					</li>
					<li>
						<a href="<c:url value='/ManagerOrderServlet?method=all_pay_ok'/>">已付款订单</a>
					</li>
					<li>
						<a href="<c:url value='/ManagerOrderServlet?method=all_no_receiving'/>">未收货订单</a>
					</li>
					<li>
						<a href="<c:url value='/ManagerOrderServlet?method=all_finish'/>">已完成订单</a>
					</li>
				</ul>
			</div>
		</div>
		<!-- 第三个 -->

	</div>
	</div>
</body>
</html>
