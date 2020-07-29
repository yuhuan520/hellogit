package com.java.springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.springboot.entity.Emp;
import com.java.springboot.mapper.EmpMapper;
import com.java.springboot.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @program: springBoot_emp
 * @description: 业务层实现类
 * @author: Mr.Yu
 * @create: 2020-07-28 17:05
 **/
@Service
@Transactional(readOnly = false)
public class EmpServiceImpl implements EmpService {
    //注入EmpMapper

    @Autowired
    private EmpMapper empMapper;
    //分页查询员工业务接口
    @Override
    public Map<String, Object> findPageEmp(Integer page,Integer limit) throws Exception{

        Map<String,Object> map = new HashMap<String, Object>();
        PageHelper.startPage(page,limit);
        PageInfo<Emp> pageInfo = new PageInfo<>(empMapper.selectPageEmp());
        map.put("data",pageInfo.getList());
        map.put("count",pageInfo.getTotal());
        return map;
    }

    @Override
    public String scEmpByEmpno(Integer empno) throws Exception {
        if(empMapper.deleteEmpByEmpno(empno)==1){
            return "delSuccess";
        }else {
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
    @Override
    public String updEmpByEmpno(Emp emp) throws Exception {
        if(empMapper.updEmpByEmpno(emp)==1){
            return "updSuccess";
        }else {
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
    @Override
    public String insEmp(Emp emp) throws Exception {
        if(empMapper.insEmp(emp)==1){
            return "saveSuccess";
        }else {
            return "fail";
        }
    }
}
