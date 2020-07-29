package com.java.springboot.mapper;

import com.java.springboot.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {
    /**
     * @Description: 分页查询员工
     * @Param: []
     * @return:
     * @Author: Mr.Yu
     * @Date:
     */
    List<Emp> selectPageEmp() throws Exception;

    /**
     * @Description: 删除员工信息
     * @Param: [empno]
     * @return:
     * @Author: Mr.Yu
     * @Date:
     */
    Integer deleteEmpByEmpno(@Param(value = "empno") Integer empno) throws Exception;
    /**
     * @Description: 修改员工信息
     * @Param: [emp]
     * @return:
     * @Author: Mr.Yu
     * @Date:
     */
    Integer updEmpByEmpno(Emp emp) throws Exception;

    /**
     * @Description: 添加员工信息
     * @Param: [emp]
     * @return:
     * @Author: Mr.Yu
     * @Date:
     */
    Integer insEmp(Emp emp) throws Exception;
}
