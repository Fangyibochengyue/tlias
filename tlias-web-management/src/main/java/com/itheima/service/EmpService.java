package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;


import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @return
     */
    PageBean page(Integer page, Integer pageSize ,String name, Short gender,LocalDate begin,LocalDate end);

    /**
     * 批量删除操作
     * @param ids
     */
    void delete(List<Integer> ids);


    /**
     * 新增员工
     * @param emp
     */
    void save(Emp emp);

    /**
     * 根据id来查询员工
     * @param id
     * @return
     */

    Emp getById(Integer id);

    /**
     * 更新员工
     * @param emp
     */

    void updayte(Emp emp);

    /**
     * 员工登录
     * @param emp
     * @return
     */
    Emp login(Emp emp);


}
