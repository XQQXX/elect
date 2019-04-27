<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>




<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
<title>订单查询</title>

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


<script type="text/javascript">
	function a_click() {
		alert(("此操作不被支持,订单信息系统自动管理,禁止操作人员非法操作"));
	}
</script>
<style type="text/css">
.mycenter {
	margin-top: 8%;
}

.margin_bottom5px {
	margin-bottom: 5px;
}
</style>
</head>

<body>
	<div id="html_top"
		class="navbar-inverse  navbar-static-top navbar-fixed-top"
		role="navigation">
		<jsp:include page="/admin/admin/top.jsp"></jsp:include>
	</div>

	<div class="container mycenter">
		<div id="html_left" class="col-lg-2">
			<jsp:include page="/admin/admin/left.jsp"></jsp:include>
		</div>
		<div id="html_content" class="col-lg-9 col-lg-offset-0">
			<h1 class="page-header text-center text-primary">订单管理查询</h1>
			<!-- 遍历所有条目 -->
			<c:forEach items="${ requestScope.orders }" var="order">

				<!-- 一个订单条目开始 -->
				<div>

					<!-- 一个订单条目标题 -->
					<div class="row">
						<h4 class="text-info">
							订单：${order.oid } 成交时间：
							<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
								value="${ order.ordertime }" />
							金额： <span> <b class="text-info">${order.total }元</b> <c:choose>
									<c:when test="${order.state eq 1}">
										<a
											href="<c:url value='/OrderServlet?method=loadOrder&oid=${order.oid }'/>">确认付款</a>
									</c:when>
									<c:when test="${order.state eq 2 }">
								等待发货
							</c:when>
									<c:when test="${order.state eq 3 }">
										<a
											href="<c:url value='/OrderServlet?method=confirmOrder&oid=${order.oid }'/>">确认收货</a>
									</c:when>
									<c:when test="${order.state eq 4 }">订单结束</c:when>
								</c:choose>
							</span>
						</h4>
					</div>
					<!--一个订单条目标题结束-->


					<c:forEach items="${order.items}" var="item">
						<!-- 遍历所有订单中的所有条目开始 -->
						<!-- 单个条目开始  -->
						<div class="row">

							<div class="row">
								<div class="col-lg-2 img_p5">
									<a
										href="<c:url value='/BookServlet?method=loadBookByBid&bid=${item.book.bid }'/>">
										<img src="<c:url value='/${item.book.image }'/>" border="0" />
									</a>

								</div>
								<div class="col-lg-3">
									<p class="nav nav-stacked">
									<div class="form-group">
										<label>书名:</label> <input class="form-control"
											value="${item.book.bname }" readonly="readonly" />
									</div>
									<div class="form-group">
										<label>作者：</label> <input class="form-control"
											value="${item.book.author }" readonly="readonly" />
									</div>
									</p>
								</div>
								<div class="col-lg-3">
									<p class="nav nav-stacked">
									<div class="form-group">
										<label>单价：</label> <input class="form-control"
											value="${item.book.price }元" readonly="readonly" />
									</div>

									<div class="form-group">
										<form id="form" action="#" method="post">
											<label for="InputCount">数量:</label> <input
												class="form-control" id="InputCount" type="text" size="3"
												name="count" value="${item.count }" />
										</form>
									</div>
									</p>
								</div>
								<div class="col-lg-3">
									<p class="nav nav-stacked">
									<div class="form-group">
										<label class="">小计</label> <input class="form-control"
											value="${item.subtotal }" readonly="readonly" />
									</div>
									<label>操作</label>
									<div>
										<a class="btn btn-primary" href="#" onclick="a_click();" id="">删除</a>
									</div>
									</p>
								</div>

							</div>

						</div>
						<!-- 单个条目结束-->
					</c:forEach>
					<!-- 遍历所有订单中单的条目结束 -->

				</div>
				<!-- 一个订单条目结束 -->
			</c:forEach>
			<!-- 遍历所有订单结束 -->
		</div>
	</div>
</body>
</html>