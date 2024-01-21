package cwx.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cwx.mapper.EmpMapper;
import cwx.pojo.Emp;
import cwx.pojo.PageBean;
import cwx.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

//员工业务实现类
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    //简单分页查询
//    @Override
//    public PageBean page(Integer page, Integer pageSize) {
//        //1、获取总记录数
//        Long count = empMapper.count();
//
//        //2、获取分页查询结果列表
//        Integer start = (page - 1) * pageSize; //计算起始索引 , 公式: (页码-1)*页大小
//        List<Emp> empList = empMapper.list(start, pageSize);
//
//        //3、封装PageBean对象
//        return new PageBean(count, empList);
//    }

    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        //1. 设置分页参数
        PageHelper.startPage(page, pageSize);

        //2. 执行查询
        List<Emp> empList = empMapper.list(name, gender, begin, end);
        
        Page<Emp> p = (Page<Emp>) empList;
        

        //3. 封装PageBean对象
        PageBean pageBean;
        pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    @Override
    public Emp login(Emp emp) {
        return empMapper.getByUsernameAndPassword(emp);
    }
}