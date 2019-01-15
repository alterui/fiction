<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script>
	$(function() {

		var val = $("#flag").val();
		if (val == "1" && val != "") {
			$("#showtab")[0].style.display = "";
			$("#logintab")[0].style.display = "none";
		} else {
			$("#showtab")[0].style.display = "none";
			$("#logintab")[0].style.display = "";
		}
	})

	layui.use('element', function() {
		var element = layui.element;
	});
	//Demo

	function showLogin() {
		layui.use('layer', function() {
			var layer = layui.layer;
			layer.open({
				type : 2,
				title : '用户登录',
				maxmin : false,
				skin : 'layui-layer-molv',
				shadeClose : true, //点击遮罩关闭层
				area : [ '500px', '400px' ],
				content : [ '${ctx}/jsp/fore/login.jsp', 'no' ]
			//content : $('#lg'),

			//弹框显示的url
			});
		});
	}
	layui.use('carousel', function() {
		var carousel = layui.carousel;
		//建造实例
		carousel.render({
			elem : '#test1',
			width : '100%' //设置容器宽度
			,
			arrow : 'hover', //始终显示箭头
		//,anim: 'updown' //切换动画方式
		});
	});
</script>
<div style="height: 36px; width: 100%; background: #f7f7f7">
	<div
		style="heigth: 36px; margin-left: auto; margin-right: auto; width: 80%;">
		<div style="height: 100%; float: left;">
			<div
				style="width: 100px; background-color: white; float: left; text-align: center">
				<span style="vertical-align: middle; line-height: 36px"
					class="layui-breadcrumb"><a href="${pageContext.request.contextPath}/index.jsp">起点中文网</a></span>
			</div>
			<span id="toptext" class="layui-breadcrumb" style="vertical-align: middle;"lay-separator="|">
				<a href="">娱乐中文网</a> <a href="">八卦中文网</a> <a href="">体育中文网</a>
			</span>
		</div>
		<div style="float: right; display: block;vertical-align: middle;text-align:center" id="logintab">
			<span id="toptext" class="layui-breadcrumb" lay-separator="|">
				<a href="javascript:void(0)" onclick="showLogin()">登录</a> <a
				href="${pageContext.request.contextPath}/jsp/include/fore/register.jsp">注册</a>
			</span>
		</div>
		<div style="float: right; display: none" id="showtab">
			<span id="toptext" class="" lay-separator="|"> <a
				href="javascript:void(0)" onclick="">你好,${loginUser.nickname }</a> <a
				href="javascript:void(0)" onclick="">消息(0)</a> <a href="logout">退出</a>
			</span>
		</div>
	</div>
</div>
<div id="top">
	<div id="top2">
		<img src="${pageContext.request.contextPath}/img/logo.jpg" />
	</div>
	<div id="top3">
		<form class="layui-form" action="showBook" id="searchForm" method="post">
			<div style="width: 50%; float: left">
				<input type="text" name="bname" placeholder="书籍名称"
					class="layui-input" style="width: 100%">
			</div>
			<div style="float: left; width: 20%">
				<input type="submit" class="layui-btn">
			</div>
		</form>
	</div>
	<div id="top4">
		<a id="bookstore" href="" target="_blank"> 我的书架 </a>
	</div>
</div>
<input type="hidden" value="${sessionScope.flag }" id="flag">
