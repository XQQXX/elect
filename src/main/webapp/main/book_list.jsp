<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<script type="text/javascript" src="../js/prototype-1.6.0.3.js">
    </script>
		<link href="../css/book.css" rel="stylesheet" type="text/css" />
		<link href="../css/second.css" rel="stylesheet" type="text/css" />
		<link href="../css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="../css/list.css" rel="stylesheet" type="text/css" />
        <style type="text/css">
            #shopCart:hover{
              padding-left: 2px;
            }
        </style>
        <script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
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
		&nbsp;

		<!-- 头部开始 -->
		<%@include file="../common/head.jsp"%>
		<!-- 头部结束 -->

		<div style="width: 962px; margin: auto;">
			<a href="#"><img src="../images/default/book_banner_081203.jpg" border="0" /> </a>
		</div>
		<div class='your_position'>
			您现在的位置:&nbsp;
			<a href='main.jsp'>当当图书</a> &gt;&gt;
			<font style='color: #cc3300'><strong>${name.name}</strong> </font>
		</div>

		<div class="book">

			<!--左栏开始-->
			<div id="left" class="book_left">
				<div id="__fenleiliulan">
					<div class=second_l_border2>
						<h2>
							分类浏览
						</h2>
						<ul>
							<li>
								<div>
									<div class=second_fenlei>
                                        <c:forEach items="${categories}" var="first">
                                            <c:set var="totol" value="${totol+first.category_products.size()}"></c:set>
                                        </c:forEach>

                                        <a href="list.main?id=${categories.get(0).parent_id}&parent_id=${name.id}">&middot;全部&nbsp;(${totol})</a>
									</div>
								</div>
							</li>
							<div class="clear"></div>

							<!--2级分类开始-->
							<c:forEach items="${categories}" var="first">
                                     <li>
                                        <div>
                                            <div class=second_fenlei>
                                                &middot;
                                            </div>
                                            <div class=second_fenlei>
                                                <a href="list.main?id=${first.id}&parent_id=${name.id}">${first.name}(${first.category_products.size()})</a>
                                            </div>
                                        </div>
                                    </li>
                                    <div class="clear"></div>
                            </c:forEach>
							<!--2级分类结束-->
							
							<li>
								<div></div>
							</li>
						</ul>
					</div>
				</div>
			</div>

			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">

				<!--图书列表开始-->
				<div id="divRight" class="list_right">

					<div id="book_list" class="list_r_title">
						<div class="list_r_title_text">
							排序方式
						</div>
						<select onchange='' name='select_order' size='1'
							class='list_r_title_ml'>
							<option value="">
								按上架时间 降序
							</option>
						</select>
						<div id="divTopPageNavi" class="list_r_title_text3">

							<!--分页导航开始-->
							<c:if test="${page>1}">
							<div class='list_r_title_text3a'>
								<a name=link_page_next
									href="paging.main?page=${page-1}">
								<img src='../images/page_up.gif' /> </a>
							</div>
                            </c:if>
                            <c:if test="${page<=1}">
							<div class='list_r_title_text3a'>
								<img src='../images/page_up_gray.gif' />
							</div>
                            </c:if>
							<div class='list_r_title_text3b'>
                                <fmt:formatNumber var="c" value="${(bookCats.size()+2)/5}" pattern="#"/>
                                第${page}页/共${c}页
							</div>
                            <c:if test="${page<c}">
							<div class='list_r_title_text3a'>
								<a name=link_page_next
									href="paging.main?page=${page+1}">
									<img src='../images/page_down.gif' /> </a>
							</div>
                            </c:if>
                            <c:if test="${page>=c}">
							<div class='list_r_title_text3a'>
								<img src='../images/page_down_gray.gif' />
							</div>
                            </c:if>
							<!--分页导航结束-->
						</div>
					</div>
					
					<!--商品条目开始-->
                    <div class="list_r_line"></div>
                    <c:forEach items="${bookCat}" var="book">
						<div class="clear"></div>
						<div class="list_r_list">
							<span class="list_r_list_book"><a name="link_prd_img" href='#'>
								<img src="../productImages/${book.product.product_pic}" /> </a> </span>
							<h2>
								<a name="link_prd_name" href='detail.main?id=${book.id}'>${book.product.product_name}</a>
							</h2>
							<h3>
								顾客评分：${book.total_page}
							</h3>
							<h4 class="list_r_list_h4">
								作 者:
								<a href='detail.main?id=${book.id}' name='作者'>${book.author}</a>
							</h4>
							<h4>
								出版社：
								<a href='detail.main?id=${book.id}' name='出版社'>${book.publishing}</a>
							</h4>
							<h4>
								出版时间：<fmt:formatDate value="${Date(book.publish_time)}" pattern="yyyy-MM-dd HH:mm:ss"/>
							</h4>
							<h5>
                                    ${book.catalogue}
							</h5>
							<div class="clear"></div>
							<h6>
								<span class="del">￥${book.product.fixed_price}&nbsp;</span>
								<span class="red">￥${book.product.dang_price}</span>
								节省：￥${book.product.fixed_price-book.product.dang_price}
							</h6>
							<span class="list_r_list_button"> 
							<a href="javascript:;" onclick="checkUser(${book.id},${user.id})">
							<img src='../images/buttom_goumai.gif'  id="shopCart"/> </a>
                                <span id="cartinfo"></span></span>
						</div>
						<div class="clear"></div>
                    </c:forEach>

					
						<!--商品条目结束-->

					<div class="clear"></div>
					<div id="divBottomPageNavi" class="fanye_bottom">
					</div>

				</div>
				<!--图书列表结束-->

			</div>
			<!--中栏结束-->
			<div class="clear"></div>
		</div>

		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>
