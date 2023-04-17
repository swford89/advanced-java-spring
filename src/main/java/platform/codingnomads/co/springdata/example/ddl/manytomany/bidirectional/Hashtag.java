package platform.codingnomads.co.springdata.example.ddl.manytomany.bidirectional;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Hashtag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false)
    private String tag;

    @Column(nullable = false)
    @ManyToMany(mappedBy = "hashtags")
    private Set<Post> posts;

}
