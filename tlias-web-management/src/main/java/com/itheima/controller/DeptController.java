package com.itheima.controller;

import com.itheima.anno.Log;
import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private DeptService deptService;

    //private static Logger log= LoggerFactory.getLogger(DeptController.class);
    //@RequestMapping(value = "/depts",method = RequestMethod.GET)//请求方式为GET
    @Log
    @GetMapping
    public Result list(){
        log.info("查询全部部门的数据");
        //调用service查询部门信息
        List<Dept> deptList=deptService.list();
        return Result.success(deptList);
    }
    //删除部门
    @Log
    @DeleteMapping("{id}")
    public Result delete(@PathVariable Integer id){
    log.info("根据id删除部门：{}",id);
        //调用service来删除部门
        deptService.delete(id);
        return Result.success();
    }

    //新增部门
    @Log
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("新增部门：{}",dept);
        //调用service新增部门
        deptService.add(dept);
        return Result.success();
    }
    //根据id来查询
    @Log
    @GetMapping("{id}")
    public Result  selectId(@PathVariable Integer id){
        log.info("查询id是{}部门的数据",id);
        Dept dd=deptService.selectId(id);
        return Result.success(dd);
    }
    //修改部门
    @Log
    @PutMapping
    public Result update(@RequestBody Dept dept){
        deptService.update(dept);
        return Result.success();
    }

}
