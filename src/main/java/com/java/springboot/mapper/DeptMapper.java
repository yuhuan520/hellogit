package com.java.springboot.mapper;


import com.java.springboot.entity.Dept;

import java.util.List;

public interface DeptMapper {
    /**
    * @Description: 查询所有部门信息
    * @Param: []
    * @return:
    * @Author: Mr.Yu
    * @Date:
    */
    List<Dept> selectAllDept() throws Exception;
}
