<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="head.jsp"%>
<div style="width: 100%; height: 100%; position: relative;">
	<div
		style="width: 80%; height: 20%; margin-left: auto; margin-right: auto; position: relative;">
		<div style="float: left; margin-top: 2%">
			<img src="${pageContext.request.contextPath}/img/logo.jpg" />
		</div>
		<div
			style="float: left; margin-top: 4%; margin-left: 10px; position: relative;">
			<span style="font-size: 25px; font-family: 黑体;">|用户注册 </span>
		</div>
	</div>
	<div
		style="width: 80%; margin-left: auto; margin-right: auto; margin-top: 10%">
		<div style="margin-top: 10px; position: relative;">
			<hr class="layui-bg-green">
		</div>

		<div style="width: 35%; margin-left: auto; margin-right: auto">
			<form class="layui-form"  method="post">
				<div class="layui-form-item" style="margin-top: 7%">
					<label class="layui-form-label">用户名</label>
					<div class="layui-input-inline"
						style="line-height: 60px; vertical-align: middle">
						<input type="text" name="uaccout" required
							lay-verify="required|username" placeholder="请输入用户名"
							autocomplete="off" class="layui-input" id="uname">
					</div>
				</div>
				<div class="layui-form-item" style="margin-top: 7%">
					<label class="layui-form-label">昵称</label>
					<div class="layui-input-inline"
						style="line-height: 60px; vertical-align: middle">
						<input type="text" name="nickname" required lay-verify="required"
							placeholder="请输入昵称" autocomplete="off" class="layui-input"
							id="fullname">
					</div>
				</div>
				<div class="layui-form-item" style="margin-top: 7%">
					<label class="layui-form-label">密码</label>
					<div class="layui-input-inline">
						<input type="password" name="password" required
							lay-verify="required|pass" placeholder="请输入密码" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item" style="margin-top: 7%">
					<label class="layui-form-label">确认密码</label>
					<div class="layui-input-inline">
						<input type="password" name="password2" required
							lay-verify="required|pass" placeholder="请输入密码" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item" style="margin-top: 6%">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit lay-filter="regDemo">立即提交</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

<script>
	//Demo
	var time = 1;

	layui.use('form', function() {
		var form = layui.form;
		//监听提交
		form.on('submit(regDemo)', function(data) {
			//var json = JSON.stringify(data.field);
			$(".layui-btn").attr("disabled","disabled");
			var json = data.field;
			var url = "/register";
			$.post(url, json, function(data) {
				if (data.result) {
					//layer.msg(data.msg);
					//setTimeout("skipIndex()", 3000);
					setInterval("skipIndex()", 1000);
				} else {
					layer.msg(data.msg)
					$(".layui-btn").removeAttr("disabled");
				}
				//layer.close();
				//window.location.href="./index.jsp";

			}, "json");
			return false;
		});
		var item = document.getElementById("uname");
		form.verify({
			/* 正则校验用户名   */
			username : [ /^([a-zA-Z]{12})|([\w]{1,12})$/, '用户名为6-12位不能全为数字' ],
			pass : [ /^[\S]{1,12}$/, '密码必须6到12位，且不能出现空格' ],
		});
	});
	function skipIndex(msg) {
		layer.msg("注册成功" + time + "秒后跳转首页")
		if (time == 0) {
			window.location.href = "/";
		}
		time--;

	}
</script>
<%@include file="foot.jsp"%>