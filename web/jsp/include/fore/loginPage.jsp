<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script type="text/javascript">
	var show_num = [];
	$(function() {
		draw(show_num);
	})
	function canv() {
		draw(show_num);
	}

	
	layui.use('form', function() {
		var form = layui.form;
		form.on('submit(loginDemo)', function(data) {

			/*禁止使用其他触发/!**!/!*/
			$(".layui-btn").attr("disabled","disabled");
			var json = data.field;
			var val = $("#input-val").val().toLowerCase();
			var num = show_num.join("");
			if (val == num) {
				var url = "/login";
				$.post(url, json, function(data) {
					if (data.result) {
						layer.msg(data.msg);
						
						parent.location.reload();
						// 获得frame索引
						var index = parent.layer.getFrameIndex(window.name);
						//关闭当前frame
						parent.layer.close(index);
					} else {
						layer.msg(data.msg);
						draw(show_num);

                        $(".layui-btn").removeAttr("disabled");
					}

				}, "json");
				return false;
			} else {
				layer.msg('验证码错误！请重新输入！');
				draw(show_num);
				$(".layui-btn").removeAttr("disabled");
				return false;
			}
		});

	});

	
</script>

	<div
		style="width: 100%; height: 100%; overflow: hidden; "
		id="lg">
		<div
			style="margin-left: auto; margin-right: auto; width: 90%; height: 100%; margin-top: 50px; position: relative;">
			<form class="layui-form" action="/index.jsp">
				<div class="layui-form-item" style="">
					<label class="layui-form-label">用户名</label>
					<div class="layui-input-inline">
						<input type="text" name="uaccout" required lay-verify="required"
							placeholder="请输入用户名" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item" style="">
					<label class="layui-form-label">密码框</label>
					<div class="layui-input-inline">
						<input type="password" name="upwd" required
							lay-verify="required" placeholder="请输入密码" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item" style="">
					<label for="L_vercode" class="layui-form-label">图片验证码</label>
					<div class="layui-input-inline">
						<input type="text" required lay-verify="required"
							placeholder="请输入验证码不区分大小写" autocomplete="off" class="layui-input"
							id="input-val">
					</div>
				</div>
				<div class="layui-form-item" style="">
					<div class="layui-form-mid"
						style="padding: 0px 0 !important; margin-left: 10%">
						<canvas id="canvas" width="100px" height="43px" onclick="canv()"></canvas>
						<span style="vertical-align: middle; line-height: 43px">点击图片刷新验证码</span>
					</div>
				</div>
				<div class="layui-form-item" style="">
					<div class="layui-input-block"> 
						<button class="layui-btn" type="submit" lay-submit lay-filter="loginDemo">登录</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>
		</div>
	</div>
