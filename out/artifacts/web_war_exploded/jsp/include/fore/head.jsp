<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${ctx}/css/book.css">
<link rel="stylesheet" href="${ctx}/js/layui/css/layui.css" media="all">
<script src="${ctx}/js/layui/layui.all.js"></script>
<script src="${ctx}/js/layui/layui.js"></script>
<script src="${ctx}/js/jquery-2.1.1.js"></script>
<script src="${ctx}/js/login.js"></script>
<script>
//注意：导航 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function(){
  var element = layui.element;
  
});
</script>
<title>小说网</title>
</head>
<body>
