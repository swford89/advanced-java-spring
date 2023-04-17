package platform.codingnomads.co.springweb.resttemplate.POST.postForEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import platform.codingnomads.co.springweb.resttemplate.POST.models.*;

import java.util.Objects;

@SpringBootApplication
public class PostForEntityMain {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(PostForEntityMain.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
//            Task newTask = Task.builder()
//                    .name("learn how to use postForEntity()")
//                    .description("Testing task post.")
//                    //be sure to use valid user id
//                    .userId(380)
//                    .completed(false)
//                    .build();
//
//            ResponseEntity<TaskResponseObject> responseEntity = restTemplate
//                    .postForEntity("http://demo.codingnomads.co:8080/tasks_api/tasks", newTask, TaskResponseObject.class);
//
//            if (responseEntity.getStatusCode().equals(HttpStatus.CREATED)) {
//                System.out.println(Objects.requireNonNull(responseEntity.getBody()));
//            } else {
//                System.out.println(Objects.requireNonNull(responseEntity.getBody()).getError());
//            }

            User createdUser = User.builder()
                    .email("barnaby_bubble@email.com")
                    .firstName("Barnaby")
                    .lastName("Bubble")
                    .build();

            System.out.println("\nPostForEntityMain: \n" + createdUser);

            ResponseEntity<UserResponseObject> postResponseEntity = restTemplate
                    .postForEntity("http://demo.codingnomads.co:8080/tasks_api/users", createdUser, UserResponseObject.class);
            if (postResponseEntity.getStatusCode().equals(HttpStatus.CREATED)) {
                System.out.println(Objects.requireNonNull(postResponseEntity.getBody()));
            } else {
                System.out.println(Objects.requireNonNull(postResponseEntity.getBody().getError()));
            }
        };
    }
}
