<%@page contentType="text/html;charset=utf-8"  isELIgnored="false"%>
<%@page import="java.util.Date" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="../css/book.css" rel="stylesheet" type="text/css" />
		<link href="../css/second.css" rel="stylesheet" type="text/css" />
		<link href="../css/secBook_Show.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
        <style type="text/css">
            #shopCart:hover{
                padding-left: 2px;
            }
        </style>
        <script type="text/javascript">
            function checkUser(id,user_id){
                if (${user==null}){
                    alert("请先登录哦！");
                    location="../user/login_form.jsp";
                }else{
                    $.post("shop.cart",{id:id,userId:user_id});
                }
            }
        </script>
	</head>
	
	<body>
		<!-- 头部开始 -->
		<%@include file="../common/head.jsp"%>
		<!-- 头部结束 -->
		<div style="width: 962px; margin: auto;">
			<a href='#' ><img
					src="../images/default/book_banner_081203.jpg" border="0" /> </a>
		</div>

		<div class="book">
			<!--左栏开始-->
			<div id="left" class="book_left">

			</div>
			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">

				<!--图书信息-->
				<div class=second_c_border1 id="recommend">
				<h2>
					图书信息
				</h2>
				<div id=__bianjituijian/danpin>
					<div class=second_c_02>

					        <div class=second_c_02_b1_3 style="width: 250px;margin:0px;float: left" >
								<img src="../productImages/${book.product.product_pic}" width=200 border=1/>
                            </div>
                            <div class=second_c_02_b1_4 style="float: left;margin-top:50px;">
                                丛书名称：${book.product.product_name}
                                <div class=line_xx></div>
                                <table cellpadding="4px" cellspacing="4px" width="100%">
                                    <tr><td>作者：${book.author}</td></tr>
                                    <tr><td>出版社：${book.publishing}</td></tr>
                                    <tr><td>所属类别：${style}</td></tr>
                                    <tr><td>上架时间：<fmt:formatDate value="${Date(book.product.add_time)}" pattern="yyyy-MM-dd HH:mm:ss"/></td></tr>
                                </table>
                                <h6>
                                    <span class="del">定价：￥${book.product.fixed_price}</span>
                                    <span class="red">当当价：￥${book.product.dang_price}</span>
                                    节省：￥${book.product.fixed_price-book.product.dang_price}
                                </h6>
                                <span class="list_r_list_button"> </span>
                                <a href="javascript:;" onclick="checkUser(${book.id},${user.id})">
                                    <img src='../images/buttom_goumai.gif' id="shopCart"/> </a>
                                <span style="color:red;" id='cartinfo${book.id}/>'></span>
                            </div>

					</div>
				</div>
				</div>

				<!--图书信息-->

				<!--详细信息-->
				<div class="book_c_border2" id="hot">
				<h2>
					详细信息
				</h2>
				<div class="book_c_04">
					<table class="t_xxxx">
						<caption>丛书名称：${book.product.product_name}</caption>
						<tr><td width="50%">作者：${book.author}</td><td>出版社:${book.publishing}</td></tr>
						<tr>
							<td>出版时间：<fmt:formatDate value="${Date(book.publish_time)}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<td>印刷时间：${book.print_time}</td></tr>
						<tr><td>版次：${book.which_edtion}</td><td>印次：${book.print_number}</td></tr>
						<tr><td>字数：${book.word_number}</td><td>页数：${book.total_page}</td></tr>
						<tr>
							<td>ISBN：${book.isbn}</td>
							<td>上架时间：<fmt:formatDate value="${Date(book.product.add_time)}" pattern="yyyy-MM-dd HH:mm:ss"/></td></tr>
						<tr></tr>
					</table>
				</div>
				<div class="clear"></div>
				</div>
				<!--详细信息-->

				<!--书籍简介-->
				<div class="book_c_border2" id="new">
					<h2>
						书籍简介
					</h2>
					<table class="t_xxxx">
						<tr>
							<td>
								书籍简介：<p>${book.product.description}</p>
							</td>
						</tr>
						<tr>
							<td>
								作者简介：<p>${book.author_summary}</p>
							</td>
						</tr>
						<tr>
							<td>
								书籍目录：<p>${book.catalogue}</p>
							</td>
						</tr>
					</table>
				</div>
				<!--书籍简介-->

				<div class="clear">
				</div>
			</div>
			<!--中栏结束-->



			<!--右栏开始-->
			<div class="book_right">
				<div class="book_r_border2" id="__XinShuReMai">
					<div class="book_r_b2_1x" id="new_bang">
						<h2 class="t_xsrm">
							新书热卖榜
						</h2>
						<div id="NewProduct_1_o_t" onmouseover="">
							<h3 class="second">
								<span class="dot_r"> </span><a href='main.main' >更多&gt;&gt;</a>
							</h3>
						</div>
					</div>
				</div>
			</div>
			<!--右栏结束-->
			<div class="clear"></div>
		</div>
		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>
