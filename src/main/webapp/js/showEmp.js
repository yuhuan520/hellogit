layui.use(['jquery','layer','table','form','laydate'], function() {
    var $ = layui.jquery,   //jquery
        layer = layui.layer,  //弹出层
        table = layui.table,  //数据表格
        form = layui.form,  //表单
        laydate = layui.laydate;   //日期


    //初始化部门数据
    loadAllDept();

    //日期时间选择器
    laydate.render({
        elem: '#hiredate'
        ,type: 'datetime'
        ,format:'yyyy/MM/dd HH:mm:ss'
    });

    //日期时间选择器
    laydate.render({
        elem: '#hiredate2'
        ,type: 'datetime'
        ,format:'yyyy/MM/dd HH:mm:ss'
        ,value:new Date()
    });

//采用数据表格的方法集渲染，将数据渲染到容器中
    //第一个实例
    //默认情况下此函数会向服务端自动传参数：page当前页；limit每一页查询的数据条数（必传）
    //当首次进到此表格中时：page=1;默认情况下limit=10
    table.render({
        elem: '#demo' //数据存放的容器，为table标签，其id="demo"
        ,height: 312  //容器高度
        ,width: 1200
        ,url: '/emp/getPageEmp' //数据接口或者访问服务器端的数据路径
        ,limit:5   //自定义每一页的数据条数
        ,limits:[2,3,5,8,10]
        ,even:true  //逐行背景色深浅不一
        ,page: true //开启分页
        ,cols: [[ //表头  field: 'id'表示从实体对象的属性中取到数据放入容器里
            //title: 'ID'表示为表格的每一列标题
            //单元格的宽度
            // fixed: 'left'  将此列居左
            //field: 'empno'可以取到对象JSON数据中的普通数据
            {field: 'empno', title: '员工编号', align:'center', width:100, sort: true}
            ,{field: 'ename', title: '姓名', align:'center',width:120}
            ,{field: 'job', title: '工作', width:120, align:'center',sort: true}
            ,{field: 'sal', title: '工资', width:100,align:'center'}
            ,{field: 'mgr', title: '上司编号', width: 100,align:'center', sort: true}
            ,{field: 'hiredate', title: '入职时间', width: 180,align:'center'}
            ,{field: 'comm', title: '奖金', width: 100, align:'center',sort: true}
            //templet:'<div>{{d.dept.dname}}</div>' 模板：取到对象中对象属性的属性值（员工对象中的部门对象属性的部门名称属性值）
            //d为员工对象,dept为员工对象中部门对象的属性名,dname为部门对象的属性名
            ,{field: 'dname', title: '部门名称', width: 100, align:'center',sort: true,templet:'<div>{{d.dept.dname}}</div>'}
            ,{field: 'loc', title: '地址', width: 120, align:'center',sort: true,templet:'<div>{{d.dept.loc}}</div>'}
            //操作列toolbar: '#barDemo'为操作模板，为工具条
            ,{fixed: 'right',title: '操作', width:150, align:'center', toolbar: '#barDemo'}
        ]]
    });

    //监听工具条，'tool(test)'中的test与容器中的lay-filter="test"保持一致
    table.on('tool(test)', function(obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）

        if(layEvent==='del'){//删除
            layer.confirm('真的删除行么', function(index) {
                delEmpByEmpno(obj);
                layer.close(index);//关闭当前弹窗
            });
        }else if(layEvent==='edit'){//修改
            //do something
            //1.弹出修改界面
            layer.open({
                type:1,
                title:"员工修改页面",
                area:['400px','600px'],
                anim: 3,
                shade:0.5,
                content:$("#updDiv")
            });
            //2.将选中的员工数据回显到修改界面
            //给表单赋值，除开下拉框之外均可以直接赋值
            form.val("form-upd", { //formTest 即 class="layui-form" 所在元素属性 lay-filter="" 对应的值
                "empno": data.empno // "name": "value"
                ,"ename": data.ename
                ,"job": data.job
                ,"mgr": data.mgr
                ,"sal": data.sal
                ,"hiredate": data.hiredate
                ,"comm": data.comm
            });
            $("#selectedUpdOpt").replaceWith('<option value="'+data.dept.deptno+','+data.dept.dname+','+data.dept.loc+'"selected id="selectedUpdOpt">'+data.dept.dname+'</option>');
            form.render('select');//渲染下拉框
            form.on('submit(demo1)', function(data){//submit(demo1)与按钮中的lay-filter="demo1"值保持一致
                updEmp(data.field,obj);
                layer.closeAll();  //关闭所有弹框
                return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
            });


        }
    });

    function delEmpByEmpno(obj){
        $.ajax({
            type:"post",
            url:"/emp/delEmpByEmpno",
            data:{"empno":obj.data.empno},
            success:function (data) {
                if(data==='delSuccess'){
                    layer.msg('数据删除成功。。', {icon: 1,time:2000,anim: 4,shade:0.5});
                    obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                }else {
                    layer.msg('数据删除失败。。', {icon: 2,time:2000,anim: 3,shade:0.5});
                }
            },
            error:function () {
                layer.msg('服务器异常', {icon: 3,time:2000,anim: 6,shade:0.5});
            }

        });

    }
    //初始化部门数据
    function loadAllDept() {
        $.ajax({
            type:"post",
            url:"/dept/loadAllDept",
            success:function (data) {
                var deptStr='<option value="" selected id="selectedUpdOpt">--部门信息--</option>';
                $.each(data,function (i,dept) {
                    deptStr += '<option value="'+dept.deptno+','+dept.dname+','+dept.loc+'">'+dept.dname+'</option>';

                });
                $("#deptUpdSel").html(deptStr);
                $("#deptSaveSel").html(deptStr);
                form.render('select');//渲染下拉框
            },
            error:function () {
                layer.msg('服务器异常', {icon: 3,time:2000,anim: 6,shade:0.5});
            }

        });
    }
    //修改员工信息
    function updEmp(jsonEmp,obj) {
        var attrDept=jsonEmp.dept.split(",");
        delete jsonEmp['dept'];
        jsonEmp['dept.deptno']=attrDept[0];
        $.ajax({
            type:"post",
            url:"/emp/updEmpByEmpno",
            data:jsonEmp,
            success:function (data) {
                console.log(data);
                if(data==='updSuccess'){
                    layer.msg('数据修改成功。。', {icon: 1,time:2000,anim: 4,shade:0.5});
                    //同步更新缓存对应的值
                    obj.update({  //  field: 'ename':修改后的数据
                        ename: jsonEmp.ename
                        ,job: jsonEmp.job
                        ,mgr: jsonEmp.mgr
                        ,sal: jsonEmp.sal
                        ,hiredate: jsonEmp.hiredate
                        ,comm: jsonEmp.comm
                    });
                    obj.tr.children().eq(7).find("div").text(attrDept[1]);
                    obj.tr.children().eq(8).find("div").text(attrDept[2]);
                }else {
                    layer.msg('数据修改失败。。', {icon: 2,time:2000,anim: 3,shade:0.5});
                }
            },
            error:function () {
                layer.msg('服务器异常', {icon: 3,time:2000,anim: 6,shade:0.5});
            }

        });
    }
    //添加数据
    $("#saveBtnUI").click(function () {
        //1.弹出修改界面
        layer.open({
            type:1,
            title:"员工修改页面",
            area:['400px','600px'],
            anim: 3,
            shade:0.5,
            content:$("#saveDiv")
        });
        form.on('submit(demo2)', function(data){//submit(demo1)与按钮中的lay-filter="demo1"值保持一致
            saveEmp(data.field);
            layer.closeAll();  //关闭所有弹框
            return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
        });
    });
    //添加数据ajax操作
    function saveEmp(jsonEmp){
        var attrDept=jsonEmp.dept.split(",");
        delete jsonEmp['dept'];
        jsonEmp['dept.deptno']=attrDept[0];
        $.ajax({
            type:"post",
            url:"/emp/saveEmp",
            data:jsonEmp,
            success:function (data) {
                if(data==='saveSuccess') {
                    layer.msg('数据添加成功。。', {icon: 1, time: 2000, anim: 4, shade: 0.5});
                }else {
                    layer.msg('数据添加失败。。', {icon: 2,time:2000,anim: 3,shade:0.5});
                }
            },
            error:function () {
                layer.msg('服务器异常', {icon: 3,time:2000,anim: 6,shade:0.5});
            }

        });
    }

});