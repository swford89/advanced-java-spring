package platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class UserApplication implements CommandLineRunner {

    @Autowired
    UserRepo userRepo;
    public static void main(String[] args) { SpringApplication.run(UserApplication.class); }

    @Override
    public void run(String ...args){
        // build users
        User user1 = User.builder().age(33).firstName("Scott").lastName("Ford").isActive(true).phone("7806664444").build();
        User user2 = User.builder().age(33).firstName("Azhar").lastName("Ishamoo").isActive(false).phone("4035552222").build();
        User user3 = User.builder().age(34).firstName("Natasha").lastName("Sharmoo").isActive(true).phone("4039991111").build();
        User user4 = User.builder().age(32).firstName("Emma").lastName("Watson").isActive(true).phone("2031112222").build();
        User user5 = User.builder().age(37).firstName("Carey").lastName("Mulligan").isActive(false).phone("3015558888").build();
        User user6 = User.builder().age(40).firstName("Brit").lastName("Marling").isActive(true).phone("7809997777").build();

        List<User> createdUsers = Arrays.asList(user1, user2, user3, user4, user5, user6);

        // save users
        if (userRepo.findAll().isEmpty()) {
            userRepo.saveAll(createdUsers);
        }

        Long edmontonAreaCode = Long.valueOf("780");
        System.out.println("\nEDMONTON USERS ***********************");
        List<User> edmontonUsers = userRepo.findByPhoneStartingWith(edmontonAreaCode);
        for (User user : edmontonUsers) {
            System.out.println(user.getFirstName() + " " + user.getLastName() + ": " + user.getPhone());
        }
        System.out.println("\nCALGARY USERS ***********************");
        Long calgaryAreaCode = Long.valueOf("403");
        List<User> calgaryUsers = userRepo.findByPhoneStartingWith(calgaryAreaCode);
        for (User user: calgaryUsers) {
            System.out.println(user.getFirstName() + " " + user.getLastName() + ": " + user.getPhone());
        }
        System.out.println("\nACTIVE USERS ***********************");
        List<User> activeUsers = userRepo.findByIsActiveIsTrue();
        for (User user: activeUsers) {
            System.out.println(user.getFirstName() + " " + user.getLastName() + ": " + user.isActive());
        }
        System.out.println("\nACTIVE and LASTNAME ***********************");
        List<User> activeLastNameQuery = userRepo.findByIsActiveAndLastName(true, "Ford");
        for (User user: activeLastNameQuery) {
            System.out.println(user.getFirstName() + " " + user.getLastName() + ": " + user.isActive());
        }
        System.out.println("\nUSERS BY AGE BOUNDARY ***********************");
        List<User> ageList = userRepo.findByAgeGreaterThanEqual(35);
        for (User user : ageList) {
            System.out.println(user.getFirstName() + " " + user.getLastName() + ": " + user.getAge() + " years old");
        }
        System.out.println("\nUSERS BY AGE DESC SORT ***********************");
        Sort sort = Sort.by(Sort.Direction.DESC, "age");
        List<User> descAgeList = userRepo.findAll(sort);
        for (User user : descAgeList) {
            System.out.println(user.getFirstName() + " " + user.getLastName() + ": " + user.getAge() + " years old");

        }



    }

}
