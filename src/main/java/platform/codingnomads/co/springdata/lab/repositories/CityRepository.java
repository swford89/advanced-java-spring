package platform.codingnomads.co.springdata.lab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import platform.codingnomads.co.springdata.lab.models.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    City findByCityName(String cityName);
}
