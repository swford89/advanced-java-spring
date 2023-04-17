package platform.codingnomads.co.springdata.lab.models;

import lombok.*;
import platform.codingnomads.co.springdata.lab.models.Area;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "cities")
@ToString
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String cityName;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Route route;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Area upperLimit;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Area lowerLimit;

    @Builder
    City(String cityName, Route someRoute) {
        this.cityName = cityName;
        this.route = someRoute;
        this.upperLimit = someRoute.getOrigin();
        this.lowerLimit = someRoute.getDestination();
    }
}
