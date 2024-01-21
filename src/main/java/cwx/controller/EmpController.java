package cwx.controller;

import cwx.pojo.PageBean;
import cwx.pojo.Result;
import cwx.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

//员工管理控制器
@Slf4j
@RestController
@RequestMapping("/emps") //抽取公共的请求路径
public class EmpController {

    @Autowired
    private EmpService empService;

//    //简单的分页查询
//    @GetMapping
//    public Result page(@RequestParam(defaultValue = "1") Integer page,
//                       @RequestParam(defaultValue = "10") Integer pageSize) {
//
//        log.info("分页查询:page={},pageSize={}", page, pageSize);
//
//        //调用service的page方法
//        PageBean pageBean = empService.page(page, pageSize);
//        return Result.success(pageBean);
//    }
//    // http://localhost:8080/emps?page=1&pageSize=10
    
    //标准动态分页查询-条件分页查询
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        //记录日志
        log.info("分页查询，参数：{},{},{},{},{},{}", page, pageSize,name, gender, begin, end);
        //调用业务层分页查询功能
        PageBean pageBean = empService.page(page, pageSize, name, gender, begin, end);
        //响应
        return Result.success(pageBean);
    }

    
}