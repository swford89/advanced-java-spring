package platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    //find ALL and SORT by age DESC
    List<User> findAll(Sort sort);

    List<User> findByAgeGreaterThanEqual(int ageBoundary);

    List<User> findByLastNameIs(String lastName);

    List<User> findByFirstNameIs(String firstName);

    List<User> findByIsActiveIsTrue();

    List<User> findByPhoneStartingWith(Long areaCode);

    List<User> findByIsActiveAndLastName(boolean trueBool, String lastName);
}
