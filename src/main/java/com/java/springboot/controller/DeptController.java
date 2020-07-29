package com.java.springboot.controller;

import com.java.springboot.entity.Dept;
import com.java.springboot.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: springBoot_emp
 * @description: 部门控制层
 * @author: Mr.Yu
 * @create: 2020-07-29 15:21
 **/
@Controller
@RequestMapping("/dept")
public class DeptController {

    //依赖注入deptService
    @Autowired
    private DeptService deptService;
    /**
    * @Description: 初始化部门信息
    * @Param: []
    * @return:
    * @Author: Mr.Yu
    * @Date:
    */
    @RequestMapping("/loadAllDept")
    @ResponseBody
    public List<Dept> loadAllDept(){
        try {
            return deptService.findAllDept();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
