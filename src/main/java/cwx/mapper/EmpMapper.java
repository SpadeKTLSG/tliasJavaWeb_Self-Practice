package cwx.mapper;

import cwx.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    //获取总记录数
    @Select("select count(*) from emp")
    public Long count();


//    //简单获取当前页的结果列表
//    @Select("select * from emp limit #{start}, #{pageSize}")
//    public List<Emp> list(Integer start, Integer pageSize);

    //标准动态分页查询-条件分页查询:
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    //登录
    @Select("select id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time " +
            "from emp " +
            "where username=#{username} and password =#{password}")
    Emp getByUsernameAndPassword(Emp emp);
}