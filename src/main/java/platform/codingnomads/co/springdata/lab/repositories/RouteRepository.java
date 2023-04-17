package platform.codingnomads.co.springdata.lab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import platform.codingnomads.co.springdata.lab.models.Route;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
    List<Route> findByCodeStartingWith(String codePrefix);
    List<Route> findByCodeEndingWith(String codeSuffix);
    Route findByCode(String queryCode);
}
