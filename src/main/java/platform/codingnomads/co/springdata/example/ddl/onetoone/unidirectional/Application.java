package platform.codingnomads.co.springdata.example.ddl.onetoone.unidirectional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    private static final String MYSQL_DB_PASSWORD = System.getenv("MYSQL_DB_PASSWORD");

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
