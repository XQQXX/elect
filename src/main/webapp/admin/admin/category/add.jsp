<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
<title>添加分类</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="content-type" content="text/html;charset=utf-8">

<!-- 引入几种标签 -->
<script src="<c:url value='/js/jquery-1.8.3.min.js'/>" type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/bootstrap.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/css/fileinput.min.css'/>" />

<link rel="stylesheet" type="text/css" href="<c:url value='/css/bootstrap-theme.css'/>" />
<script src="<c:url value='/js/bootstrap.min.js'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/js/fileinput.min.js'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/js/application.js'/>" type="text/javascript" charset="utf-8"></script>

<style type="text/css">
	.mycenter{
		margin-top:10%;
	}
</style>

</head>

<body>
	<div id="html_top"
		class="row navbar-inverse   navbar-static-top navbar-fixed-top"
		role="navigation">
		<jsp:include page="../top.jsp"></jsp:include>
	</div>
	<div class="container  mycenter">
		<div id="html_left" class="row col-lg-2" style="width: 285px">
				<jsp:include page="/admin/admin/left.jsp"></jsp:include>
		</div>
		<div class="col-lg-9 col-lg-offset-0">
			<h1 class="page-header text-center text-info">添加分类</h1>
			<div class="">
		
				<form action="<c:url value='/admin/category.category'/>" method="post">
		
					<div class="">
						<div class="form-inline col-lg-8">
							<input type="hidden" size="30" name="method" class="form-control"
								readonly="readonly" value="add" />
						</div>
                        <div class="form-inline col-lg-8">
                            <input type="hidden" size="30" name="parent_id" class="form-control"
                                   readonly="readonly" value="1" />
                        </div>
						<div class="form-inline col-lg-8">
							<label for="CName">分类名称：</label>

                            <input id="CName" type="text"
								size="30" name="name" class="form-control" />
						</div>
                        <div class="form-inline col-lg-8">
                            <label for="CName">英文名称：</label>

                            <input id="CName10" type="text"
                                   size="30" name="en_name" class="form-control" />
                        </div>
						<div class="col-lg-4">
							<label for="Cput">操作：</label> <input id="Cput" type="submit"
								class=" btn btn-primary form-control" value="添加一级分类" />
						</div>
					</div>
				</form>
                <br/>  <br/>  <br/>  <br/>  <br/> <br/>  <br/><br/>
              <form action="<c:url value='/admin/category.category'/>" method="post">
                <div class="">
                    <div class="form-inline col-lg-8">
                        <input type="hidden" size="30" name="method" class="form-control"
                               readonly="readonly" value="add" />
                    </div>

                    <div class="form-inline col-lg-8">
                        <label for="CName">一级分类：</label><br/>
                        <select class="form-control" name="parent_id" style="width: 519.98px;">
                            <c:forEach items="${category}" var="first">
                                <option value="${first.key.id}">${first.key.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-inline col-lg-8">
                        <label for="CName">分类名称：</label>
                        <input id="CName12" type="text"
                               size="30" name="name" class="form-control" />
                    </div>
                    <div class="form-inline col-lg-8">
                        <label for="CName">英文名称：</label>
                        <input id="CName11" type="text"
                               size="30" name="en_name" class="form-control" />
                    </div>
                    <div class="col-lg-4">
                        <label for="Cput">操作：</label> <input id="Cput1" type="submit"
                                                             class=" btn btn-primary form-control" value="添加二级分类" />
                    </div>
                </div>
            </form>


            <div class="text-danger text-center">
                <p style="font-size: 20px;">${msg}</p>
            </div>
        </div>
        </div>
	</div>
<script type="text/javascript">
    $(function () {
        $('#CName1').blur(function () {
            var txt=$(this).val();
            if(txt<=2&&txt!=""){
                $('#CName1succ').text("合法");
            }else{
                $('#CName1succ').text("分类不合法");
            }
        })
    })
</script>
</body>

</html>
