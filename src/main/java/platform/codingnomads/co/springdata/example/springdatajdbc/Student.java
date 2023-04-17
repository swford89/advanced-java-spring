package platform.codingnomads.co.springdata.example.springdatajdbc;

import lombok.Data;

@Data
public class Student {
    private long id;
    private String firstName;
    private String lastName;
    private String courseName;

    Student(long id, String firstName, String lastName, String courseName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.courseName = courseName;
    }

}
