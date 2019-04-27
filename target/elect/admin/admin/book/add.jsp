<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
<title>添加产品页面</title>

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

		
</head>

<style>
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
	
	<div class="container mycenter">
		<div class="">
			<div class="col-lg-2" style="width: 285px">
				<jsp:include page="../left.jsp"></jsp:include>
			</div>
			<div class="col-lg-9 col-lg-offset-0">
				<div class="page-header text-center text-primary">
					<h1>添加图书</h1>
				</div>
				<div class="">
					<p class="text-danger">${msg }</p>
					<form action="<c:url value='/admin/addBook.book'/>"  method="post" enctype="multipart/form-data">

						<div class="form-group">
							<label>图书名称：</label>
							<input class="form-control" type="text" name="product_name" />
						</div>

						<div class="form-group">
							<label>图书描述：</label>
							<input class="form-control" type="text" name="description" />
						</div>

						<div class="form-group">
							<label>图书图片：</label>
							<input  class="file" type="file" name="product_pic" />
						</div>
						

						<div class="form-group">
							<label>图书单价：</label>
							<input class="form-control" type="text"  name="fixed_price" />
						</div>

						<div class="form-group">
							<label>图书折扣价：</label>
							<input class="form-control" type="text" name="dang_price" />
						</div>

						<div class="form-group">
							<label> 图书作者：</label>
							<input class="form-control" type="text" name="author" />
						</div>

						<div class="form-group">
							<label> 出版社：</label>
							<input class="form-control" type="text" name="publishing" />
						</div>

                        <div class="form-group">
                        <label> 图书分类：</label>
                        <div class="">
                            <select name='parent_id' class="form-control dropdown" style="width:400px;float: left;margin-right: 25px" id="first">
                                <optgroup>
                                    <c:forEach items="${category}" var="first" varStatus="i">
                                        <option value="${first.key.id}">${first.key.name}</option>
                                    </c:forEach>
                                </optgroup>
                            </select>
                            <select name='cat_id' class="form-control dropdown" onchange="change()" style="width:400px;" id="second">

                            </select>
                        </div>
                    </div>

						<div class="form-group text-right">
							<input class="btn btn-block btn-primary" type="submit"
								value="添加图书" />
						</div>
					</form>
				</div>
			</div>

		</div>
	</div>
<script type="text/javascript">
    $(function () {
        $('#first').change(function () {
            $('#second').empty();
            var id=$(this).val();
            $.post('admin/secondCate.book',{id:id},function (data) {
                $.each(data,function (index, item) {
                    var option=$("<option value="+item.id+">"+item.name+"</option>");
                    $('#second').append(option);
                })
            },'json')
        })
    })
</script>
</body>
</html>
