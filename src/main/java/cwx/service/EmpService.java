package cwx.service;

import cwx.pojo.Emp;
import cwx.pojo.PageBean;

import java.time.LocalDate;

//员工业务规则
public interface EmpService {
    //简单分页查询
//    PageBean page(Integer page, Integer pageSize);
    
    //标准动态分页查询-条件分页查询
    /**
     * 条件分页查询
     * @param page     页码
     * @param pageSize 每页展示记录数
     * @param name     姓名
     * @param gender   性别
     * @param begin   开始时间
     * @param end     结束时间
     * @return page bean 对象
     */
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    //登录
    Emp login(Emp emp);
}