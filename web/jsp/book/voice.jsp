﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
	<meta charset="UTF-8">
	<title>Document</title>
</head>
<body>
	<form action="" method="post">
		<table align="center">
			<tr>
				<td><input type="text" id='val' placeholder='你要装换的文字'></td>
				<td><input type="button" value="提交" onclick="fun()"></td>
			</tr>
		</table>
	</form>
</body>
</html>
<script type="text/javascript">
function fun()
{
	var val=document.getElementById("val").value;
	var zhText = val;
	zhText = encodeURI(zhText);
	document.write("<audio autoplay=\"autoplay\">");
	document.write("<source src=\"http://tts.baidu.com/text2audio?lan=zh&ie=UTF-8&spd=2&text="+ zhText +"\" type=\"audio/mpeg\">");
	document.write("<embed height=\"0\" width=\"0\" src=\"http://tts.baidu.com/text2audio?lan=zh&ie=UTF-8&spd=2&text="+ zhText +"\">");
	document.write("</audio>");
}
</script>
