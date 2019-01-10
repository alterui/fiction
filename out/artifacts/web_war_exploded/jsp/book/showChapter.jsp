<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="loaded">
<head>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<title>${book.bname }_${book.writer.wname }_${book.category.cname }</title>
<link rel="stylesheet" href="${ctx}/css/vote_popup.css">
<link rel="stylesheet" href="${ctx}/js/layui/css/layui.css" media="all">
<script src="${ctx}/js/layui/layui.all.js"></script>
<script src="${ctx}/js/layui/layui.js"></script>
<script src="${ctx}/js/jquery-2.1.1.js"></script>
<script type="text/javascript">
	layui.use('element', function() {
		var element = layui.element;

	});

	function audioStop() {
		var audio = document.getElementById("au");
		audio.pause();
	}
	function audioReload() {
		var audio = document.getElementById("au");
		audio.load();
	}
	function audioPlay() {
		var audio = document.getElementById("au");
		var url = $(".j_chapterName").data("url");
		var audioSrc = audio.currentSrc;
		if(audioSrc==""){
			var xhr = new XMLHttpRequest(); //配置请求方式、请求地址以及是否同步 
			xhr.open('get', 'speak?url=' + url, true);
			//设置请求结果类型为blob
			xhr.responseType = 'blob';
			//请求成功回调函数 
			xhr.onload = function(e) {
				if (this.status == 200) {//请求成功 //获取blob对象 
					var blob = this.response; //获取blob对象地址，并把值赋给容器 
					audio.src = window.URL.createObjectURL(blob);
				} else {
					alert("音频加载失败,请稍候再试")
				}
			};
			xhr.send(null);
		}else{
			audio.play();
		}
		/* var form = new FormData();
		/* form.append("url",url); 
		 */
	}
	$(function() {

	})
</script>
</head>
<body class="theme-0">
	<div class="share-img">
		<img src="${ctx }/img/index.png" width="300" height="300">
	</div>
	<div class="wrap">
		<div class="float-button layui-btn-container">
			<button class="layui-btn layui-btn-sm layui-btn-radius"
				onclick="audioPlay()">播放</button>
			<br />
			<button class="layui-btn layui-btn-sm layui-btn-radius"
				onclick="audioStop()">暂停</button>
			<br />
			<button class="layui-btn layui-btn-sm layui-btn-radius"
				onclick="audioReload()">重听</button>
		</div>
		<div id="readHeader" class="read-header" data-l1="">
			<div class="wrap-center cf">
				<div class="left-nav fl">
					<div class="logo">
						<a class="logo-ico"></a>
					</div>
					<ul>
						<li class="site"><a class="pin-logo" target="_blank"
							href="/qidian"><span></span></a>
							<div class="dropdown">
								<a href=""> 起点女生</a> <a href=""> 我家的小说</a> <a href=""> 你家的小说</a>
							</div></li>
						<li class="app"><cite>手机阅读</cite></li>
						<li class=""><cite>最近阅读</cite></li>
						<li class="qucik-nav"><cite>快速导航</cite></li>

					</ul>
				</div>
				<div class="read-login fr">
					<ul>
						<li id="min-search">
							<form action="" method="get">
								<input id="searchSubmit" class="submit-input" type="submit" />
								<input id="pin-input" class="pin-input hide" name="kw"
									type="text" placeholder="xxxx" />
								<lable id="pin-search" for="searchSubmit"> <em
									class="iconfont" style="margin-top: 120%"> </em> </lable>
							</form>
						</li>
						<li class="line"></li>
						<li class="sign-out"><a id="pin-login" href="javascript:">登录
						</a> <a class="reg" href="javascript:" target="_blank">注册 </a></li>
						<li><a target="_blank">充值</a></li>
					</ul>
				</div>
			</div>
		</div>

		<div class="read-main-wrap font-faily01" style="font-size: 18px">
			<div id="j_chapterBox">
				<div style="display: none">
					<audio src="" controls="controls" autoplay="autoplay" id="au">
					</audio>
				</div>
				<!-- <div class="text-wrap " id="j_textWrap"></div> -->

				<div class="main-text-wrap">
					<div class="text-head">
						<a class="book-mark" href="javascript:" title="书签"> </a>
						<!-- 章节名称 -->
						<h3 data-url="${chapter.churl }" class="j_chapterName">${chapter.chname }</h3>
						<!--章节信息  -->
						<div class="text-info cf">
							<div class="info fl">
								<!--书籍名称  -->
								<a href="">${book.bname }</a>
								<!--作者名称  -->
								<a href="">${book.writer.wname }</a>
								<!--字数  -->
								<i>${chapter.wordcount }</i>
								<!--更新时间 -->
								<i>${fn:substring(chapter.createtime,0,19 )}</i>
							</div>
						</div>
						<!-- 章节内容 -->
						<div class="read-content j_readContent">
							<c:forEach items="${chapterList }" var="str">
								<p>${str}</p>
							</c:forEach>
						</div>

					</div>

				</div>

				<div class="chapter-control dib-wrap">
					<a href="chapter?bno=${book.bno }&chno=${chapter.preid}">上一章</a><span>|</span><a
						href="bookDetail?bno=${book.bno }">目录</a><span>|</span><a
						href="chapter?bno=${book.bno }&chno=${chapter.nextid}">下一章</a>
				</div>
			</div>

		</div>
	</div>


</body>

</html>