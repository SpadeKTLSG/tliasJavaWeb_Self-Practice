package cwx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class CwxmanagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(CwxmanagementApplication.class, args);
    }

    //前端联调: http://localhost:90
}
