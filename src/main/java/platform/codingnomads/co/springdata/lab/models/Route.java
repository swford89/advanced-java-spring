package platform.codingnomads.co.springdata.lab.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "routes")
@ToString
public class Route implements Serializable {

    private static final long serialVersionUID = -2624055642258734917L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "origin_area_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_routes_origin_area_id")
    )
    private Area origin;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "destination_area_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_routes_destination_area_id")
    )
    private Area destination;

    // code = "origin-destination"
    @Column(unique = true)
    private String code;

    @Builder
    Route(Area origin, Area destination) {
        this.origin = origin;
        this.destination = destination;
        this.code = origin.getCode() + "-" + destination.getCode();
    }

}
