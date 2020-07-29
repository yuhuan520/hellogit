package com.java.springboot.service;

import com.java.springboot.entity.Emp;

import java.util.Map;

public interface EmpService  {
    //分页查询员工业务接口
    Map<String,Object> findPageEmp(Integer page,Integer limit) throws Exception;
    /**
     * @Description: 删除员工信息
     * @Param: [empno]
     * @return:
     * @Author: Mr.Yu
     * @Date:
     */
    String scEmpByEmpno(Integer empno) throws Exception;
    /**
     * @Description: 修改员工信息
     * @Param: [emp]
     * @return:
     * @Author: Mr.Yu
     * @Date:
     */
     String updEmpByEmpno(Emp emp) throws Exception;
    /**
     * @Description: 添加员工信息
     * @Param: [emp]
     * @return:
     * @Author: Mr.Yu
     * @Date:
     */
    String insEmp(Emp emp) throws Exception;
}
