package cwx.service;

import cwx.pojo.Dept;

import java.util.List;

//部门业务规则
public interface DeptService {    
    
    //查询全部部门数据
    List<Dept> list();

    //根据id删除部门
    void delete(Integer id);

    //新增部门
    void add(Dept dept);

    //修改部门
    void update(Dept dept);
}