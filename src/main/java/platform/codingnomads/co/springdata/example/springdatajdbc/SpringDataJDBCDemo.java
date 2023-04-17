package platform.codingnomads.co.springdata.example.springdatajdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.core.env.Environment;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringDataJDBCDemo implements CommandLineRunner {

    private static final String MYSQL_DB_PASSWORD = System.getenv("MYSQL_DB_PASSWORD");

    @Autowired
    JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJDBCDemo.class);
    }

    @Override
    public void run(String... strings) {

        try {
            //create employee table using the JdbcTemplate method "execute"
            jdbcTemplate.execute("CREATE TABLE employees (id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                    "first_name VARCHAR(255) NOT NULL,last_name  VARCHAR(255) NOT NULL);");
            jdbcTemplate.execute("CREATE TABLE students (id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                    "first_name VARCHAR(255) NOT NULL, last_name VARCHAR(255) NOT NULL," +
                    "course_name VARCHAR(255) NOT NULL)");
        } catch (Exception e) {
            //nothing
        }

        //create a list of first and last names
        List<Object[]> splitUpNames = Stream.of("Java Ninja", "Spring Guru", "Java Guru", "Spring Ninja")
                .map(name -> name.split(" "))
                .collect(Collectors.toList());

        List<Object[]> studentValues = Stream.of("Scott Ford Python", "Bob Barker Java", "Emma Watson Go")
                .map(name -> name.split(" "))
                .collect(Collectors.toList());

        //for each first & last name pair insert an Employee into the database
        for (Object[] name : splitUpNames) {
            jdbcTemplate.execute(String.format("INSERT INTO employees(first_name, last_name) VALUES ('%s','%s')", name[0], name[1]));
        }
        for (Object[] values : studentValues) {
            jdbcTemplate.execute(String.format("INSERT INTO students(first_name, last_name, course_name) VALUES ('%s', '%s', '%s')",
            values[0], values[1], values[2]));
        }

        //query the database for Employees with first name Java
        jdbcTemplate.query(
                "SELECT id, first_name, last_name FROM employees WHERE first_name = 'Java'",
                        (rs, rowNum) -> new Employee(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
                )
                //print each found employee to the console
                .forEach(employee -> System.out.println(employee.toString()));
        jdbcTemplate.query(
                "SELECT id, first_name, last_name, course_name FROM students",
                (rs, rowNum) -> new Student(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("course_name"))
                ).forEach(student -> System.out.println(student.toString()));

        //truncate the table
        jdbcTemplate.execute("TRUNCATE TABLE employees;");
        jdbcTemplate.execute("TRUNCATE TABLE students");
        //delete the table
        jdbcTemplate.execute("DROP TABLE employees");
        jdbcTemplate.execute("DROP TABLE students");
    }
}
