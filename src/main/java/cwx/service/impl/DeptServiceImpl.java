package cwx.service.impl;

import cwx.mapper.DeptMapper;
import cwx.pojo.Dept;
import cwx.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

//部门业务实现类
@Slf4j
@Service
public class DeptServiceImpl implements DeptService {
    //Service要调用数据库,需要注入dao对象
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    @Override
    public void delete(Integer id) {
        deptMapper.deleteById(id);
    }

    @Override
    public void add(Dept dept) {
        //需要补全的属性:createTime,updateTime
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    @Override
    public void update(Dept dept) {
        //需要补全的属性:updateTime
        dept.setUpdateTime(LocalDateTime.now());
//        deptMapper.update(dept);
    }
}