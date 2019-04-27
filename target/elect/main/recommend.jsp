<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.Date" %>
<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<h2>
	编辑推荐
</h2>
<div id=__bianjituijian/danpin>
	<div class=second_c_02>

        <c:forEach var="book" items="${recommend}">
        <div class=second_c_02_b1>
			<div class=second_c_02_b1_1>
				<a href='detail.main?id=${book.id}' ><img src="../productImages/${book.product.product_pic}" width=70 border=0 /> </a>
			</div>
			<div class=second_c_02_b1_2>
				<h3>
					<a href='detail.main?id=${book.id}'  title='输赢'>${book.product.product_name}</a>
				</h3>
				<h4>
					作者：${book.author} 著
					<br />
					出版社：${book.publishing}&nbsp&nbsp出版时间：<fmt:formatDate value="${Date(book.publish_time)}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</h4>
				<h5>
					简介:${book.catalogue}
				</h5>
				<h6>
					定价：￥${book.product.fixed_price}&nbsp;&nbsp;当当价：￥${book.product.dang_price}
				</h6>
				<div class=line_xx></div>
			</div>
		</div>
        </c:forEach>

		
	</div>
</div>
