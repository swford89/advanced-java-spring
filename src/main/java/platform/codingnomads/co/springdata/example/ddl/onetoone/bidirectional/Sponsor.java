package platform.codingnomads.co.springdata.example.ddl.onetoone.bidirectional;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "sponsors", schema = "codingnomads")
@NoArgsConstructor
@Getter
@Setter
public class Sponsor {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToOne
    private Driver driver;
}
