package cwx.mapper;

import cwx.pojo.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {

    //查询全部部门数据
    @Select("SELECT * from dept")
    List<Dept> list();

    //根据id删除部门
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    //新增部门
    @Insert("insert into dept(name,create_time,update_time) values(#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);

    //修改部门
//    
//    void update(Dept dept);
}