package platform.codingnomads.co.springdata.example.dml.usingqueryannotation.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import platform.codingnomads.co.springdata.example.dml.usingqueryannotation.models.SoilType;

import java.util.List;

@Repository
public interface SoilTypeRepo extends JpaRepository<SoilType, Long> {

    @Query(value = "SELECT * FROM soil_types ORDER BY ph", nativeQuery = true)
    List<SoilType> findAllOrderByPhDesc();

    @Query(value = "SELECT * FROM soil_types WHERE ph > :ph", nativeQuery = true)
    List<SoilType> findByPhGreaterThan(@Param("ph") double ph);

    @Query(value = "SELECT * FROM soil_types WHERE dry = true", nativeQuery = true)
    List<SoilType> findByDry(boolean trueBool);

    @Query(value = "SELECT * FROM soil_types WHERE dry = false AND ph < :ph", nativeQuery = true)
    List<SoilType> findByNotDryAndPhLessThan(@Param("ph") double ph);

    @Query(value = "SELECT * FROM soil_types WHERE name = :name", nativeQuery = true)
    List<SoilType> findByName(@Param("name") String name);


}
