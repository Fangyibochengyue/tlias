package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empmapper;

    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @return
     */
//    @Override
//    public PageBean page(Integer page, Integer pageSize) {
//        //获取总记录数
//        Long count = empmapper.count();
//        //获取分页查询结果列表
//        Integer start=(page-1)*pageSize;
//        List<Emp> empList = empmapper.page(start, pageSize);
//        //封装PageBean
//        PageBean pageBean=new PageBean();
//        pageBean.setTotal(count);
//        pageBean.setRows(empList);
//        return pageBean;
//    }
    @Override
    public PageBean page(Integer page, Integer pageSize,String name, Short gender, LocalDate begin, LocalDate end) {
       //设置分页参数
        PageHelper.startPage(page,pageSize);
        //执行查询
        List<Emp> empList = empmapper.list(name, gender, begin, end);
        Page<Emp> p=(Page<Emp>) empList;
        //封装PageBean
        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    @Override
    public void delete(List<Integer> ids) {
        empmapper.delete(ids);
    }

    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empmapper.insert(emp);
    }

    @Override
    public Emp getById(Integer id) {
        return empmapper.getById(id);
    }

    @Override
    public void updayte(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empmapper.update(emp);
    }

    @Override
    public Emp login(Emp emp) {
        return empmapper.getByUsernameAndPassword(emp);
    }
}
