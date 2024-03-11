package com.itheima.service.impl;

import com.itheima.mapper.DeptMapper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Dept;
import com.itheima.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;
    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    //删除整个部门，以及部门内的员工
    @Transactional(rollbackFor = Exception.class)//开启事务，如果没有异常就提交，如果执行失败就回滚
    //rollbackFor = Exception.class 只要出现异常就会回滚
    @Override
    public void delete(Integer id) {
        deptMapper.deleteById(id);//根据ID删除部门数据
        //int i=1/0;
        empMapper.deleteByDeptId(id);//根部部门id删除该部门下的员工

    }
    //新增部门
    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    @Override
    public Dept selectId(Integer id) {
        return deptMapper.select(id);
    }

    @Override
    public void update(Dept dept) {
        dept.setName(dept.getName());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.updateBm(dept);
    }
}
