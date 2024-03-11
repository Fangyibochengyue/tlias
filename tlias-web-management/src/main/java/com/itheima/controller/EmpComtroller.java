package com.itheima.controller;

import com.itheima.anno.Log;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@Slf4j
public class EmpComtroller {

    @Autowired
    private EmpService empService;
    @Log
    @GetMapping("/emps")
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
        log.info("分页查询 参数{}{}{}{}{}{}",page,pageSize,name,gender,begin,end);
        PageBean pageBean=empService.page(page,pageSize,name,gender,begin,end);
         return Result.success(pageBean);
    }
    //批量删除员工
    @Log
    @DeleteMapping("/emps/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("批量删除员工的id:{}",ids);
        empService.delete(ids);
        return Result.success();
    }
    //新增员工
    @Log
    @PostMapping("/emps")
     public Result save(@RequestBody Emp emp){
        log.info("新增员工:{}",emp);
        empService.save(emp);

        return Result.success();
     }

     //查询回显
    @Log
    @GetMapping("/emps/{id}")
    public Result getById( @PathVariable Integer id){
        log.info("根据id来查询员工信息");
        Emp emp=empService.getById(id);
        return Result.success(emp);
    }

     //修改员工
    @Log
    @PutMapping("/emps")
    public Result uodate(@RequestBody Emp emp){
        log.info("更新员工{}",emp);
        empService.updayte(emp);

        return Result.success();
    }
}
