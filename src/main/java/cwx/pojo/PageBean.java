package cwx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页查询结果封装类
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {

    private Long total;//总记录数
    private List rows;//数据列表

}
