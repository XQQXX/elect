<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
<title>产品浏览</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="content-type" content="text/html;charset=utf-8">

<script src="<c:url value='/js/jquery-1.8.3.min.js'/>" type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/bootstrap.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/css/bootstrap-theme.css'/>" />
<script src="<c:url value='/js/bootstrap.min.js'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/js/application.js'/>" type="text/javascript" charset="utf-8"></script>



<script type="text/javascript">
	
</script>

<style type="text/css">
.pad1 {
	margin-right: 2%;
}

.mycenter {
	margin-top: 15%;
}
</style>
</head>

<body>
	<div id="html_top"
		class="navbar-inverse  navbar-static-top navbar-fixed-top"
		role="navigation">
		<jsp:include page="../top.jsp"></jsp:include>
	</div>
	<div class="container">
		<div class="mycenter">
			<div id="html_left" class="row col-lg-3">
				<jsp:include page="/admin/admin/left.jsp"></jsp:include>
			</div>
			<div id="html_content" class="col-lg-9 col-lg-offset-0">

				<!-- 开始 -->
				<c:forEach items="${requestScope.bookList }" var="book">
					<div class="col-lg-3 pad1" style="width: 240px;height: 270px">
						<div class="thumbnail">
							<div class=" ">
								<a
									href="<c:url value='/admin/bookDetail.book?id=${ book.id }'/>">
									<img src="<c:url value='../productImages/${book.product.product_pic}'/>" style="width: 120px;height: 170px" border="0" />
								</a>
							</div>
							<div class="caption" >
								<a class="btn btn-info"
									href="<c:url value='/admin/bookDetail.book?id=${ book.id }'/>" style="display: block;text-align: center;">${book.product.product_name }</a>
							</div>
						</div>
					</div>
				</c:forEach>

				<!-- 结束 -->

			</div>
		</div>

		<div>
			<jsp:include page="/common/foot1.jsp"></jsp:include>
		</div>

	</div>
</body>

</html>

