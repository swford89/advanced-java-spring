package platform.codingnomads.co.springdata.lab;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import platform.codingnomads.co.springdata.lab.models.Area;
import platform.codingnomads.co.springdata.lab.models.Route;
import platform.codingnomads.co.springdata.lab.models.City;
import platform.codingnomads.co.springdata.lab.repositories.AreaRepository;
import platform.codingnomads.co.springdata.lab.repositories.RouteRepository;
import platform.codingnomads.co.springdata.lab.repositories.CityRepository;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringDataLab implements CommandLineRunner {

    private final AreaRepository areaRepository;
    private final RouteRepository routeRepository;
    private final CityRepository cityRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataLab.class);
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {

        if (areaRepository.findAll().size() == 0) {
            final List<Area> areas = areaRepository.saveAll(
                    Arrays.asList(
                            Area.builder().code("G").build(),
                            Area.builder().code("H").build(),
                            Area.builder().code("Y").build(),
                            Area.builder().code("Z").build(),
                            // added area objects
                            Area.builder().code("A").build(),
                            Area.builder().code("B").build(),
                            Area.builder().code("C").build(),
                            Area.builder().code("D").build()
                    )
            );
        }

        if (areaRepository.findAll().size() > 0 && routeRepository.findAll().size() == 0) {
            // get origin and destination codes to build Route
            Area someOrigin1 = areaRepository.findByCode("Y");
            Area someDestination1 = areaRepository.findByCode("Z");
            Area someOrigin2 = areaRepository.findByCode("G");
            Area someDestination2 = areaRepository.findByCode("H");
            Area someOrigin3 = areaRepository.findByCode("A");
            Area someDestination3 = areaRepository.findByCode("B");
            Area someOrigin4 = areaRepository.findByCode("C");
            Area someDestination4 = areaRepository.findByCode("D");

            final List<Route> routes = routeRepository.saveAll(
                    Arrays.asList(
                            Route.builder().origin(someOrigin1).destination(someDestination1).build(),
                            Route.builder().origin(someOrigin2).destination(someDestination2).build(),
                            Route.builder().origin(someOrigin3).destination(someDestination3).build(),
                            Route.builder().origin(someOrigin4).destination(someDestination4).build()
                    )
            );
        }
        // DERIVED ROUTE QUERIES
        routeRepository.findByCodeStartingWith("A").forEach(route -> System.out.println("\nDERIVED PREFIX QUERY: "+ route.getCode()));
        routeRepository.findByCodeEndingWith("D").forEach(route -> System.out.println("\nDERIVED SUFFIX QUERY: " + route.getCode()));
        System.out.println("\nDERIVED findByCode QUERY: "+ routeRepository.findByCode("G-H").getCode());

        Route edmontonRoute = routeRepository.findByCode("A-B");
        Route calgaryRoute = routeRepository.findByCode("C-D");
        Route lethbridgeRoute = routeRepository.findByCode("G-H");

        if (cityRepository.findAll().size() == 0) {
            final List<City> cities = cityRepository.saveAll(
                    Arrays.asList(
                            City.builder().cityName("Edmonton").someRoute(edmontonRoute).build(),
                            City.builder().cityName("Calgary").someRoute(calgaryRoute).build(),
                            City.builder().cityName("Lethbridge").someRoute(lethbridgeRoute).build()
                    )
            );
        }
        // CITY REPO DERIVED QUERIES
        System.out.println("\nDERIVED findByName CITY-REPO QUERY: " + cityRepository.findByCityName("Edmonton").getCityName());
        System.out.println("\nDERIVED findByName CITY-REPO QUERY: " + cityRepository.findByCityName("Calgary").getCityName());
        System.out.println("\nDERIVED findByName CITY-REPO QUERY: " + cityRepository.findByCityName("Lethbridge").getCityName());
    }
}
