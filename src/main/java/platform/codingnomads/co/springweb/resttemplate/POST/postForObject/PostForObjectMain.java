package platform.codingnomads.co.springweb.resttemplate.POST.postForObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import platform.codingnomads.co.springweb.resttemplate.POST.models.*;

@SpringBootApplication
public class PostForObjectMain {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(PostForObjectMain.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
//            Task newTask = Task.builder()
//                    .name("learn how to use postForObject() - video demo")
//                    .description("get comfortable using the RestTemplate postForObject() method")
//                    //use a valid user id
//                    .userId(380)
//                    .completed(false)
//                    .build();
//
//            TaskResponseObject taskReturnedByServerAfterPost = restTemplate
//                    .postForObject("http://demo.codingnomads.co:8080/tasks_api/tasks", newTask, TaskResponseObject.class);
//
//            if (taskReturnedByServerAfterPost != null) {
//                System.out.println(taskReturnedByServerAfterPost.toString());
//            }
            //use postForObject to add new users
            User strangeUser = User.builder()
                    .email("drstrange@email.com")
                    .firstName("Stephen")
                    .lastName("Strange")
                    .build();

            UserResponseObject userResponseObject = restTemplate
                    .postForObject("http://demo.codingnomads.co:8080/tasks_api/users", strangeUser, UserResponseObject.class);
            System.out.println(userResponseObject);
        };
    }
}
