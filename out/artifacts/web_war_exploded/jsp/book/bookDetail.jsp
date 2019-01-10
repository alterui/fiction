<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="loaded">
<head>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<title>${book.bname }_${book.writer.wname }_${book.category.cname }</title>
<link rel="stylesheet" href="${ctx}/css/emoji.css">
<link rel="stylesheet" href="${ctx}/css/module.css">
<link rel="stylesheet" href="${ctx}/css/layout.css">
<link rel="stylesheet" href="${ctx}/css/book_details.css">
<script src="${ctx}/js/jquery-2.1.1.js"></script>
<script type="text/javascript">
	$(function() {
		$("#j-bookInfoPage").click(function() {
			$(".j_catalog_block").removeClass("act");
			$("#j-bookInfoPage").parent().addClass("act");
			$("#j-catalogWrap").addClass("hidden");
			$(".book-content-wrap").removeClass("hidden");
		});
		$("#j_catalogPage").click(function() {
			$("#j-bookInfoPage").parent().removeClass("act");
			$(".j_catalog_block").addClass("act");
			$(".book-content-wrap").addClass("hidden");
			$("#j-catalogWrap").removeClass("hidden");
		});
		$("div.site-nav li").mouseenter(function(){
			$(this).addClass("act");
		})
		$("div.site-nav li").mouseleave(function(){
			$(this).removeClass("act");
		})
	})
</script>
</head>
<body>
	<div class="share-img">
		<img src="${ctx }/img/index.png" width="300" height="300">
	</div>
	<div class="wrap">
		<div id="pin-nav" class="pin-nav-wrap need-search" data-l1="">
			<div class="box-center cf">
				<div class="nav-list site-nav fl">
					<ul>
						<li class="site"><a class="pin-logo" href="/qidian"><span></span></a>
							<div class="dropdown">
								<a href=""> 起点女生</a> <a href=""> 我家的小说</a> <a href=""> 你家的小说</a>
							</div></li>
						<li class=""><a href="">玄幻</a></li>
						<li class=""><a href="">玄幻</a></li>
						<li class=""><a href="">玄幻</a></li>
						<li class="more"><a href="javascript:" id="top-nav-more"
							target="" data-eid="qd_A54">更多<span></span></a>
							<div class="dropdown">
								<a href="" target="_blank" data-eid="qd_A169">全部作品</a> <a
									href="" target="" data-eid="qd_A55">二次元</a> <a href=" "
									target="" data-eid="qd_A51">奇幻</a> <a href="" target=""
									data-eid="qd_A57">武侠</a> <a href="" target="" data-eid="qd_A58">悬疑灵异</a>
							</div></li>
					</ul>
				</div>
				<div class="nav-list min-user fr">
					<ul>
						<li id="min-search">
							<form id="formUrl" action="" method="get" target="_blank">
								<label id="pin-search" for="topSearchSubmit" data-eid="qd_A62"><em
									class="iconfont">&#xe60d;</em> </label> <input id="pin-input"
									class="pin-input hide" type="text" name="kw" placeholder="xxxx">
								<input class="submit-input" type="submit" id="topSearchSubmit"
									data-eid="qd_A62">
							</form>
						</li>
						<li class="line"></li>
						<li class="sign-out"><a id="pin-login" href="javascript:"
							data-eid="qd_A64">登录</a> <a class="reg" href="" target="_blank">注册</a></li>
						<li class="sign-in hidden"><a href="" target="_blank"
							data-eid="qd_A65"><i id="nav-user-name"></i><span></span></a>
							<div class="dropdown">
								<a href="" target="_blank" data-eid="qd_A66">消息(<i
									id="top-msg">0</i>)
								</a> <a href="" target="_blank" data-eid="qd_A67">充值</a> <a href=""
									target="_blank" data-eid="qd_A68">个人中心</a> <a href=""
									target="_blank" data-eid="qd_A69">客服中心</a> <a id="exit"
									href="javascript:" data-eid="qd_A70">退出</a>
							</div></li>
						<li class="line"></li>
						<li class="book-shelf" id="top-book-shelf"><a href=""
							target="_blank" data-eid="qd_A63"><em class="iconfont">&#xe60c;</em><i>我的书架
							</i></a></li>
					</ul>
				</div>
			</div>
		</div>

	</div>

	<div class="border-shadow ">
		<span></span> <span></span>
	</div>

	<div class="book-detail-wrap center990">
		<div class="book-information cf" data-l1="2">


			<div class="book-img">
				<a class="J-getJumpUrl" id="bookImg" href="" data-bid="3602691"><img
					src="/qidian/img/bookcontent/${book.img }.jpg"></a>
			</div>

			<div class="book-info ">
				<h1>

					<em>${book.bname }</em> <span><a class="writer" href=""
						target="_blank" data-eid="qd_G08">${book.writer.wname }</a> 著</span>

				</h1>
				<p class="tag">
					<span class="blue">${book.state ==0?"连载":"完结"}</span> <span class="blue">签约</span> <span
						class="blue">VIP</span> <a href="" class="red" target="_blank"
						data-eid="qd_G10">都市</a> <a href="" class="red" target="_blank"
						data-eid="qd_G11">异术超能</a>

				</p>

				<p class="intro">${book.intro }</p>
				<p>
				<p>
					<a class="red-btn J-getJumpUrl " href="" id="readBtn"
						data-eid="qd_G03" data-bid="3602691">免费试读</a><a
						class="blue-btn add-book" id="addBookBtn" href="javascript:"
						data-eid="qd_G05" data-bookId="3602691" data-bid="3602691">加入书架</a>

					<a class="blue-btn" id="topVoteBtn" href="javascript:"
						data-showtype="1" data-eid="qd_G06">投票互动</a> <a class="blue-btn"
						id="downloadAppBtn" href="javascript:">下载App<br>20天免费阅读
					</a>

				</p>

			</div>
			<div class="take-wrap">
				<a class="blue" id="subscribe" href="javascript:" data-eid="qd_G13"><em
					class="iconfont">&#xe636;</em>订阅</a> <i></i> <a class="blue download"
					id="download" href="javascript:" data-eid="qd_G14"><em
					class="iconfont">&#xe644;</em>下载 </a>
			</div>
		</div>
		<div class="content-nav-wrap cf" data-l1="3">
			<div class="nav-wrap fl">
				<ul>
					<li class="act"><a class="lang" id="j-bookInfoPage"
						href="javascript:" data-eid="qd_G15">作品信息</a></li>
					<li class="j_catalog_block "><a class="lang" href="javascript:"
						id="j_catalogPage" data-eid="qd_G16">目录<i><span
								id="J-catalogCount"></span></i></a></li>

				</ul>
			</div>
		</div>
		<div class="catalog-content-wrap  hidden" id="j-catalogWrap" data-l1="14"
			>
			<div class="volume-wrap">
				<c:forEach items="${requestScope.book.volumeList }" var="volume">
					<div class="volume">
						<div class="cover"></div>
						<h3>
							<a class="subscri" href="" target="_blank"> <em class="btn"><b
									class="iconfont"></b>分卷阅读</em>
							</a> ${volume.vname } <i>.</i> 共${volume.chapterCount}章 <span
								class="free">${volume.state==0?"vip":"免费" }</span> <em
								class="count">本卷共 <cite>${volume.wordCount }</cite>字
							</em>
						</h3>
						<ul class="cf">

							<c:forEach items="${volume.chapterList }" var="chapter">
								<li data-chno="${chapter.chno  }"><a href="chapter?bno=${book.bno}&chno=${chapter.chno  }"
									target="_blank" data-chno=""
									title="首发时间:${chapter.createtime } 章节字数:${chapter.wordcount}">${chapter.chname }</a>
								</li>
							</c:forEach>
						</ul>
					</div>

				</c:forEach>

			</div>


		</div>

		<div class="book-content-wrap cf ">

			<div class="left-wrap fl">
				<div class="book-info-detail">
					<cite class="icon-pin"></cite>
					<div class="book-intro">
						<p>

							${book.intro }

						</p>
					</div>
					<div class="book-state" data-l1="4">
						<ul>


							<li><b>作者自定义标签</b>
								<div class="detail">
									<p class="tag-wrap" data-l1="4">


										<a class="tags" href="" target="_blank" data-eid="qd_G70">丹药</a>
										<a class="tags" href="" target="_blank" data-eid="qd_G70">学生</a>
										<a class="tags" href="" target="_blank" data-eid="qd_G70">爆笑</a>


									</p>
								</div></li>
							<li class="update"><b>最近更新</b>
								<div class="detail">
									<p class="cf">
										<a class="blue" href="" data-eid="qd_G19" data-cid=""
											title="第2405章 霸宋前辈的效果" target="_blank">第2405章 霸宋前辈的效果</a><i>&#183;</i><em
											class="time">15小时前</em>
									</p>
								</div></li>
						</ul>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>

</html>