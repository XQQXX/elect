<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

	<head>
		<title>产品修改页面</title>

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
			$(function() {
				$("#sub_ok").click(function() {
					$("form").submit();
				});
				
				$("")
			});
		</script>

		<style type="text/css">
			body {
				font-size: 10pt;
			}
			
			.img_p5 {
				padding-top: 5px;
			}
			
			.mycenter {
				margin-top: 10%;
			}
		</style>
	</head>

	<body>

		<div id="html_top" class="navbar-inverse  navbar-static-top navbar-fixed-top" role="navigation">
			<jsp:include page="/admin/admin/top.jsp"></jsp:include>
		</div>

		<div class="container mycenter">
			<div id="html_left" class="row col-lg-3">
				<jsp:include page="/admin/admin/left.jsp"></jsp:include>
			</div>
			<div id="html_content" class="row col-lg-9 col-lg-offset-0">

				<h2 class="page-header text-center text-primary">图书简介</h2>
				<div class="">
					<form id="form" action="<c:url value='/admin/handleBook.book'/>" method="post">
					<div class="row">
						<div class="col-lg-2 img_p5">
							<input class="" type="hidden" id="CMethod" name="method" value="" />
						</div>
						<div class="col-lg-2 img_p5">
							<input class="" type="hidden" name="id" value="${requestScope.book.id }" />
						</div>
						<div class="col-lg-2 img_p5">
							<a href=""><img src="<c:url value='../productImages/${book.product.product_pic}'/>" style="height: 170px;width: 120px"/></a>
						</div>
						<div class="col-lg-3">
							<p class="nav nav-stacked">
								<div class="form-group">
									<label>书名:</label>
									<input class="form-control"  name="name"  value="${requestScope.book.product.product_name }"/>
								</div>
								<div class="form-group">
									<label>作者：</label>
									<input class="form-control" name="author" value="${requestScope.book.author }"/>
								</div>
							</p>
						</div>

						<div class="col-lg-3">
							<p class="nav nav-stacked">
								<div class="form-group">
									<label>单价(元)：</label>
									<input class="form-control"  name="price" value="${requestScope.book.product.fixed_price }"/>
								</div>

								<div class="form-group">
										<label for="InputCount">状态:</label>
										<input class="form-control" readonly="readonly" id="InputCount" type="text" size="3" name="count" value="${book.product.has_seleted}" />
								</div>
								
								<div class="form-group">
										<input class="form-control"  type="hidden"  name="image" value="${book.product.product_pic}" />
								</div>
							</p>
						</div>
                        <div class="col-lg-3" style="width: 427px;">
							<p class="nav nav-stacked">
								<div class="form-group">
                            <div style="float:left;margin-right: 28px" >
                            <label class="">一级分类：</label><br/>
                            <select name="parent_id" class="form-control dropdown" style="width: 183.75px" id="first">
                                    <option>${cates.get(1)}</option>
                            <c:forEach items="${category}" var="first" >
                                    <option value="${first.key.id}">${first.key.name}</option>
                            </c:forEach>
                            </select>
                            </div>
                            <div style="padding-left:20px">
                            <label class="">二级分类：</label><br/>
                            <select name="cate_id" class="form-control dropdown" style="width: 183.75px" id="second">
                                    <option>${cates.get(0)}</option>
                            </select>
                            </div>
									<!--<input class="form-control" value="${requestScope.book.id }" readonly="readonly" />-->
								</div>
								<label>操作</label>
								<div>
									<button type="submit" class="btn btn-danger " name="method" value="del" onclick="setMethodDelete();" style="width: 183.75px;margin-right: 25px">删除图书</button>
									<button class="btn btn-danger " type="submit" name="method" value="mod" onclick="setMethodUpdate();" style="width: 183.75px"/>修改图书</button>
								</div>
							</p>
						</div>
					</div>
                    </form>
				</div>
			</div>
		</div>
	</body>
	<script type="text/javascript">
			function setMethodDelete(){
				if(confirm('是否真要删除该图书？')){
					alert("已经确认了");
					document.getElementById("CMethod").value = 'delete';
					//$("#CMethod").text('delete');
				}
				else{
					alert("没有确定");
				}
			}
			
			function setMethodUpdate(){
				if(confirm('是否真要修改该图书？')){
					alert("已经确认了");
					document.getElementById("CMethod").value = 'update';
					//$("#CMethod").text('update');
				}
				else{
					alert("没有确定");
				}
			}

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
</html>
