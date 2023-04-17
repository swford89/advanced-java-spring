package platform.codingnomads.co.springdata.example.dml.lifecyclecallback;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PrintEntity {

    @Id
    @GeneratedValue
    private Long id;

    // write your methods here
    @PrePersist
    public void introduction() {
        System.out.println("\nHello! My name is Scott Ford and I'm learning Java and Spring.");
    }

    @PreUpdate
    public void pythonProgramming() {
        System.out.println("\nI use to study python.");
    }

    @PostPersist
    public void confirmation() {
        System.out.println("\nData has been saved in the database.");
    }

    @PostLoad
    public void loadComplete() {
        System.out.println("\nData has been loaded.");
    }

}
