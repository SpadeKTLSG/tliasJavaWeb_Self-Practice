package cwx.controller;

import cwx.pojo.Emp;
import cwx.pojo.Result;
import cwx.service.EmpService;
import cwx.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {
    
    @Autowired
    EmpService empService;
    
/*    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        log.info("登录：{}",emp);
        Emp e = empService.login(emp);
        return e!=null?Result.success(e): Result.error("用户名或密码错误");
    }
    // http://localhost:8080/login*/

    //有令牌的登录
    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        //调用业务层：登录功能
        Emp loginEmp = empService.login(emp);

        //判断：登录用户是否存在
        if(loginEmp !=null ){
            
            //自定义信息,封装到Map中,生成令牌
            Map<String , Object> claims = new HashMap<>();
            claims.put("id", loginEmp.getId());
            claims.put("username",loginEmp.getUsername());
            claims.put("name",loginEmp.getName());

            //使用JWT工具类，生成身份令牌
            String token = JwtUtils.generateJwt(claims);
            return Result.success(token); //传递令牌
        }
        return Result.error("用户名或密码错误");
    }
}
