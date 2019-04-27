<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>
	<div class="">
		<div class="row page-header text-center">
			<h1 class="page-header text-center text-primary">欢迎使用本系统,数据无价谨慎操作</h1>
		</div>
		
		<c:if test="${adminName==null}" var="login">
		<div class="row page-header text-center">
			<h1 class="page-header text-center text-warning">请
			<a href="<c:url value='/admin/login.jsp'/>">登录</a>
			先!</h1>
		</div>
		</c:if>
		<c:if test="${!login}">
		<div class="row page-header text-center">
			<h1 class="page-header text-center text-warning">管理员 
				<a>${adminName}</a>
			</h1>
		</div>
		</c:if>

	</div>
</body>

</html>
