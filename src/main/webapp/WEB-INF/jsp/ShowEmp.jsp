<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() +request.getContextPath()+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath %>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>员工显示页面</title>
    <!--在页面中引入相关的layui的css和js文件-->
    <link rel="stylesheet" href="/lib/layui/css/layui.css" />
    <script type="text/javascript" src="/lib/layui/layui.js" ></script>
</head>
<body>
<div align="center">
    <h1>员工数据显示页面
        <button id="saveBtnUI" type="button" class="layui-btn layui-btn-sm">
            <i class="layui-icon">&#xe608;</i> 添加员工
        </button>
    </h1>
    <!--数据存放的容器-->
    <table id="demo" lay-filter="test"></table>
</div>
<jsp:include page="updEmp.jsp"></jsp:include>
<jsp:include page="saveEmp.jsp"></jsp:include>
</body>
<!--引入自定义的js文件-->
<script type="text/javascript" src="/js/showEmp.js" ></script>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit"><i class="layui-icon">&#xe642;</i>修改</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon">&#xe642;</i>删除</a>
</script>
</html>