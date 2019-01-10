<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="all-pro-wrap box-center cf">
	<div class="main-content-wrap fl" >
		<div class="all-book-list" style="margin-left: 15%">
			<div class="book-img-text">
				<ul class="all-img-list cf" style="width:1000px" >
					<c:forEach items="${requestScope.bookList }" var="book">
						<li data-bid="${book.bno}" style="display: block;line-height:40px;float:left">
							<div class="book-img-box">
								<a href="bookDetail?bno=${book.bno}" data-bno="${book.bno}" target="_blank"> <img
									src="${ctx }/img/bookcontent/${book.img}.jpg">
								</a>
							</div>
							<div class="book-mid-info">
								<h4>
									<a href="bookDetail?bno=${book.bno}" data-bno="${book.bno}" target="_blank">${book.bname}</a>
								</h4>
								<p class="author">
									<img src="${ctx}/img/user.f22d3.png"><a class="name"
										href="" data-wno="" target="_blank">${book.writer.wname}</a><em>|</em><a
										href="" target="_blank" data-cno="">${book.category.cname }</a><em>|</em><span>${book.state ==0?"连载中":"完结"}</span>
								</p>
								<p class="intro">${book.intro }</p>
								<p class="update"></p>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</div>




