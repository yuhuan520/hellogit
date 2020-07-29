package com.java.springboot.controller;

import com.java.springboot.entity.Emp;
import com.java.springboot.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: springBoot_emp
 * @description: 员工控制类
 * @author: Mr.Yu
 * @create: 2020-07-28 16:56
 **/
@Controller
@RequestMapping("/emp")
public class EmpController {
    //注入员工业务接口
    @Autowired
    private EmpService empService;
    @RequestMapping("/getPageEmp")
    @ResponseBody
    public Map<String,Object> getPageEmp(Integer page, Integer limit){
        if(page==null || limit==null){
            page=1;
            limit=10;
        }
        Map<String,Object> resultMap= new  HashMap<String, Object>();
        try {
            resultMap = empService.findPageEmp(page, limit);
            resultMap.put("code",0);
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("code",0);
            resultMap.put("msg","页面加载异常");

        }
        return resultMap;
    }
    /**
    * @Description: 删除员工信息
    * @Param: [empno]
    * @return:
    * @Author: Mr.Yu
    * @Date:
    */
    @RequestMapping("/delEmpByEmpno")
    @ResponseBody
    public String delEmpByEmpno(Integer empno){

        try {
            return empService.scEmpByEmpno(empno);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
    /**
    * @Description: 修改员工信息
    * @Param: [emp]
    * @return:
    * @Author: Mr.Yu
    * @Date:
    */
    @RequestMapping("/updEmpByEmpno")
    @ResponseBody
    public String updEmpByEmpno(Emp emp){
        try {
            return empService.updEmpByEmpno(emp);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
    /**
     * @Description: 添加员工信息
     * @Param: [emp]
     * @return:
     * @Author: Mr.Yu
     * @Date:
     */
    @RequestMapping("/saveEmp")
    @ResponseBody
    public String saveEmp(Emp emp){
        try {
            return empService.insEmp(emp);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
}
