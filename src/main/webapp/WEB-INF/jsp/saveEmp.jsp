<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>添加</title>
</head>
<body>
    <!--先将界面隐藏起来-->
    <div style="display: none;margin-top: 20px;" id="saveDiv">
        <!--添加员工数据的表单-->
        <form class="layui-form" action="javascript:void(0)" lay-filter="form-save">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">员工姓名：</label>
                    <div class="layui-input-inline">
                        <!--lay-verify="required" 为表单的验证 required非空验证
                            phone手机号验证  email邮箱验证  number数字验证  date日期验证
                            required|phone将多个验证加到一起，非空验证和手机号验证
                        -->
                        <input type="text" name="ename" lay-verify="required" autocomplete="off" class="layui-input" placeholder="请输入员工姓名">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">工作：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="job" lay-verify="required" autocomplete="off" class="layui-input" placeholder="请输入工作">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">工资：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="sal" lay-verify="required|number" autocomplete="off" class="layui-input" placeholder="请输入工资">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">上司编号：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="mgr" id="date" lay-verify="required" placeholder="请输入上司编号" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">入职时间：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="hiredate" id="hiredate2" lay-verify="required" autocomplete="off" class="layui-input" placeholder="yyyy/MM/dd HH:mm:ss">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">奖金：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="comm" lay-verify="required|number" autocomplete="off" class="layui-input" placeholder="请输入奖金">
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">员工部门：</label>
                <div class="layui-inline">
                    <select name="dept" id="deptSaveSel" lay-verify="required"></select>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo2">添加</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>
    </div>
</body>
</html>