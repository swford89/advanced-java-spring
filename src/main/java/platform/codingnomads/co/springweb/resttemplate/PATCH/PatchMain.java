package platform.codingnomads.co.springweb.resttemplate.PATCH;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import platform.codingnomads.co.springweb.resttemplate.PATCH.models.User;
import platform.codingnomads.co.springweb.resttemplate.PATCH.models.UserResponseObject;

import java.util.Objects;

@SpringBootApplication
public class PatchMain {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(PatchMain.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {

            /**
             * DEMO content
             */
//            //create an empty Task
//            Task task = new Task();
//
//            //be sure to use a valid task id
//            task.setId(169);
//
//            //set fields you want to change. All other fields are null and will not be updated
//            task.setName("use patchForObject()");
//            task.setDescription("this task was updated using patchForObject()");
//
//            //send the PATCH request using the URL, the Task created above and the ResponseObject Class
//            TaskResponseObject taskResponseObject = restTemplate
//                    .patchForObject("http://demo.codingnomads.co:8080/tasks_api/tasks/" + task.getId(), task, ResponseObject.class);
//
//            System.out.println(Objects.requireNonNull(taskResponseObject));
//
//            task.setName("PATCH using exchange()");
//            task.setDescription("This task was updated using PATCH");
//
//            HttpEntity<Task> httpEntity = new HttpEntity<>(task);
//            ResponseEntity<TaskResponseObject> response = restTemplate
//                    .exchange("http://demo.codingnomads.co:8080/tasks_api/tasks/" + task.getId(), HttpMethod.PATCH, httpEntity, ResponseObject.class);
//
//            System.out.println(Objects.requireNonNull(response));

            /**
             * PATCH request
             */
            long userId = 607;

            UserResponseObject userResponseObject = restTemplate
                    .getForObject("http://demo.codingnomads.co:8080/tasks_api/users/" + userId, UserResponseObject.class);

            User patchUserObject;
            if (userResponseObject == null) {
                throw new Exception("No user data returned from server");
            } else if (userResponseObject.getData() == null) {
                throw new Exception("User with ID " + userId + " does not exist.");
            } else {
               patchUserObject = userResponseObject.getData();
            }

            patchUserObject.setEmail("dr.strange@marvel.com");

            UserResponseObject patchResponseObject = restTemplate
                    .patchForObject("http://demo.codingnomads.co:8080/tasks_api/users/" + userId, patchUserObject, UserResponseObject.class);
            System.out.println(Objects.requireNonNull(patchResponseObject));

            /**
             * PATCH request with patchForObject() and exchange()
             */
            User someNewUser = new User();
            someNewUser.setId(609);
            someNewUser.setEmail("rockettherabbit@marvel.com");
            someNewUser.setFirstName("Rocket");
            someNewUser.setLastName("Racoon");

            UserResponseObject rocketResponseObject = restTemplate
                    .patchForObject("http://demo.codingnomads.co:8080/tasks_api/users/" + someNewUser.getId(),
                            someNewUser, UserResponseObject.class);
            System.out.println(Objects.requireNonNull(rocketResponseObject));

            someNewUser.setEmail("beast@xmen.com");
            someNewUser.setFirstName("Hank");
            someNewUser.setLastName("McCoy");
            HttpEntity httpEntity = new HttpEntity(someNewUser);

            ResponseEntity<UserResponseObject> response = restTemplate
                    .exchange("http://demo.codingnomads.co:8080/tasks_api/users/" + someNewUser.getId(),
                            HttpMethod.PATCH, httpEntity, UserResponseObject.class);

            System.out.println(Objects.requireNonNull(response));
        };
    }
}
