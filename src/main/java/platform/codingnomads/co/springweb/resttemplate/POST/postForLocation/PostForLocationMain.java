package platform.codingnomads.co.springweb.resttemplate.POST.postForLocation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import platform.codingnomads.co.springweb.resttemplate.POST.models.*;

import java.net.URI;
import java.util.Objects;


@SpringBootApplication
public class PostForLocationMain {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(PostForLocationMain.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
//            Task newTask = Task.builder()
//                    .name("Get programming job.")
//                    .description("Apply to multiple companies.")
//                    //be sure to use a valid user id
//                    .userId(380)
//                    .completed(false)
//                    .build();
//
//            //use postForLocation() to get the URL for the new resource
//            URI returnedLocation = restTemplate
//                    .postForLocation("http://demo.codingnomads.co:8080/tasks_api/tasks", newTask, TaskResponseObject.class);
//
//            System.out.println(Objects.requireNonNull(returnedLocation));

//            ResponseEntity<?> responseEntity = restTemplate
//                    .postForEntity("http://demo.codingnomads.co:8080/tasks_api/tasks", newTask, TaskResponseObject.class);
//
//            System.out.println(responseEntity.getHeaders().get("Location"));

            //use postForObject to add new users
            User gwenUser = User.builder()
                    .email("gwen@email.com")
                    .firstName("Gwen")
                    .lastName("Stacey")
                    .build();

            URI returnedLocation = restTemplate
                    .postForLocation("http://demo.codingnomads.co:8080/tasks_api/users", gwenUser, UserResponseObject.class);
            System.out.println(Objects.requireNonNull(returnedLocation));
        };
    }
}
