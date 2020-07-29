package com.java.springboot.service;

import com.java.springboot.entity.Dept;

import java.util.List;

/**
* @Description: 部门业务层接口
* @Param:
* @return:
* @Author: Mr.Yu
* @Date:
*/
public interface DeptService {
    /**
     * @Description: 查询所有部门信息
     * @Param: []
     * @return:
     * @Author: Mr.Yu
     * @Date:
     */
    List<Dept> findAllDept() throws Exception;
}
