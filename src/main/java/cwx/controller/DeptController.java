package cwx.controller;

import cwx.pojo.Dept;
import cwx.pojo.Result;
import cwx.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//部门管理控制器,限制访问方法为GET
@Slf4j //lombok提供的日志注解
@RequestMapping("/depts") //抽取出来到注解的访问路径
@RestController
public class DeptController {
    //正式开工:需要首先注入service对象:
    @Autowired //自动注入
    private DeptService deptService; //声明一个service对象

    // 访问部门
    //限定访问方法为GET: 两种方法:
    //1. @GetMapping("/dept") ,推荐
    //2. @RequestMapping(value="/dept", method=GET)
    @GetMapping //访问路径
    public Result list() {
        log.info("查询全部部门数据"); //采用更好的方法来记录日志

        //调用deptservice的list方法,返回结果,由于是全部的结果,所以要List<Dept>包装后返回
        List<Dept> deptList = deptService.list();

        return Result.success(deptList);
    }
    // http://localhost:8080/depts


    // 删除部门
    @DeleteMapping("/{id}") //完整的路径为:/depts/{id}
    public Result delete(@PathVariable Integer id) {
        log.info("根据id删除部门:{}", id);

        //调用delete方法
        deptService.delete(id);

        return Result.success();
    }
    // http://localhost:8080/depts/1
    
    // 新增部门
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        log.info("新增部门:{}", dept);

        //调用add方法
        deptService.add(dept);

        return Result.success();
    }
    // http://localhost:8080/depts
    
    // 修改部门,自己写,需要先查询,再修改
    // TODO 查看接口文档
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        log.info("修改部门:{}", dept);

        //调用update方法
        deptService.update(dept);

        return Result.success();
    }
}