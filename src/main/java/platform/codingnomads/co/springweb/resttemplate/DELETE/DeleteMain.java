package platform.codingnomads.co.springweb.resttemplate.DELETE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import platform.codingnomads.co.springweb.resttemplate.DELETE.models.TaskResponseObject;
import platform.codingnomads.co.springweb.resttemplate.DELETE.models.Task;
import platform.codingnomads.co.springweb.resttemplate.DELETE.models.User;
import platform.codingnomads.co.springweb.resttemplate.DELETE.models.UserResponseObject;

@SpringBootApplication
public class DeleteMain {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(DeleteMain.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {

            /**
             * DEMO content
             */
            Task newTask = Task.builder()
                    .name("should be deleted")
                    .description("used in a delete RestTemplate example. If you see this something went wrong. Oops")
                    //be sure to enter a valid user id
                    .userId(607)
                    .completed(false)
                    .build();

            //POST new task to server
            TaskResponseObject responseObject = restTemplate
                    .postForObject("http://demo.codingnomads.co:8080/tasks_api/tasks/", newTask, TaskResponseObject.class);

            //confirm data was returned & avoid NullPointerExceptions
            if (responseObject == null) {
                throw new Exception("The server did not return anything. Not even a ResponseObject!");
            } else if (responseObject.getData() == null) {
                throw new Exception("The server encountered this error while creating the task:" + responseObject.getError().getMessage());
            } else {
                newTask = responseObject.getData();
            }

            System.out.println("The task was successfully created");
            System.out.println(newTask);

            //delete the newTask using the ID the server returned
            restTemplate.delete("http://demo.codingnomads.co:8080/tasks_api/tasks/" + newTask.getId());
            System.out.println("The task was also successfully deleted");

            //try to GET, verify record was deleted
            try {
                restTemplate.getForEntity(
                        "http://demo.codingnomads.co:8080/tasks_api/tasks/" + newTask.getId(), TaskResponseObject.class);
            } catch (HttpClientErrorException e) {
                System.out.println(e.getMessage());
            }

            //delete using exchange()
            HttpEntity<Task> httpEntity = new HttpEntity<>(newTask);
            try {
                restTemplate.exchange("http://demo.codingnomads.co:8080/tasks_api/tasks/"
                        + newTask.getId(), HttpMethod.DELETE, httpEntity, TaskResponseObject.class);
            } catch (HttpClientErrorException e) {
                System.out.println(e.getMessage());
            }

            /**
             * delete() and exchange()
             */
            // create user and post to server
            User tempUser = new User();
            tempUser.setEmail("randomRempEmail@email.com");
            tempUser.setFirstName("RandomTemp");
            tempUser.setLastName("User");

            UserResponseObject userResponseObject = restTemplate
                    .postForObject("http://demo.codingnomads.co:8080/tasks_api/users/", tempUser, UserResponseObject.class);
            System.out.println(userResponseObject);

            // validate user creation
            if (userResponseObject == null) {
                throw new Exception("No user data was returned after creating a new User.");
            } else if (userResponseObject.getData() == null) {
                throw new Exception("Something went wrong while trying to create a new user.");
            } else {
                tempUser = userResponseObject.getData();
            }

            System.out.println(tempUser);
            System.out.println("New user was successfully created.");

            // delete user
            restTemplate.delete("http://demo.codingnomads.co:8080/tasks_api/users/" + tempUser.getId());
            System.out.println("Temp user deleted.");

            HttpEntity tempHttpEntity = new HttpEntity(tempUser);
            try {
                restTemplate.exchange("http://demo.codingnomads.co:8080/tasks_api/users/" +
                        tempUser.getId(), HttpMethod.DELETE, tempHttpEntity, UserResponseObject.class);
            } catch (HttpServerErrorException e) {
                System.out.println(e.getMessage());
            }
        };
    }
}
