<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="searchProducts">

	<c:forEach items="${ps}" var="p">
		<div class="bookUnit" price="${p.promotePrice}">
			<a href="foreproduct?pid=${p.id}"> <img class="bookImage"
				src="img/productSingle/${p.firstProductImage.id}.jpg">
			</a> <span class="bookPrice">¥<fmt:formatNumber type="number"
					value="${p.promotePrice}" minFractionDigits="2" /></span> <a
				class="bookLink" href="foreproduct?pid=${p.id}">
				${fn:substring(p.name, 0, 50)} </a> <a class="tmallLink"
				href="foreproduct?pid=${p.id}">天猫专卖</a>

			<div class="show1 bookInfo">
				<span class="monthDeal ">月成交 <span class="bookDealNumber">${p.saleCount}笔</span></span>
				<span class="bookReview">评价<span class="bookReviewNumber">${p.reviewCount}</span></span>
				<span class="wangwang"><img src="img/site/wangwang.png"></span>
			</div>

		</div>
	</c:forEach>
	<c:if test="${empty ps}">
		<div class="noMatch">
			没有满足条件的书籍
			<div>
				<div style="clear: both"></div>
			</div>
		</div>
	</c:if>
</div>
