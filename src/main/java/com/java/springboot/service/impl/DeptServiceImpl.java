package com.java.springboot.service.impl;

import com.java.springboot.entity.Dept;
import com.java.springboot.mapper.DeptMapper;
import com.java.springboot.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: springBoot_emp
 * @description: 部门信息业务层
 * @author: Mr.Yu
 * @create: 2020-07-29 15:26
 **/
@Service
@Transactional(readOnly = false)
public class DeptServiceImpl implements DeptService {
    //注入部门Mapper
    @Autowired
    private DeptMapper deptMapper;
    /**
     * @Description: 查询所有部门信息
     * @Param: []
     * @return:
     * @Author: Mr.Yu
     * @Date:
     */
    @Override
    public List<Dept> findAllDept() throws Exception {
        return deptMapper.selectAllDept();
    }
}
