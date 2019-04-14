<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<h2>
	<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>热销图书
</h2>
<div class="book_c_04">

	<!--热销图书A开始-->
    <c:forEach var="product" items="${hotBook}">
	<div class="second_d_wai">
		<div class="img">
			<a href="#" target='_blank'><img
					src="../productImages/${product.product_pic}" border=0 /> </a>
		</div>
		<div class="shuming">
			<a href="#" target="_blank">${product.product_name}</a><a href="#" target="_blank"></a>
		</div>
		<div class="price">
			定价：￥${product.fixed_price}
		</div>
		<div class="price">
			当当价：￥${product.dang_price}
		</div>
	</div>
	<div class="book_c_xy_long"></div>
    </c:forEach>
	<!--热销图书A结束-->

</div>
<div class="clear"></div>