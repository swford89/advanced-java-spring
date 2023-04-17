package platform.codingnomads.co.springweb.resttemplate.PUT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import platform.codingnomads.co.springweb.resttemplate.PUT.models.TaskResponseObject;
import platform.codingnomads.co.springweb.resttemplate.PUT.models.Task;
import platform.codingnomads.co.springweb.resttemplate.PUT.models.User;
import platform.codingnomads.co.springweb.resttemplate.PUT.models.UserResponseObject;

@SpringBootApplication
public class PutMain {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(PutMain.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            /**
             * DEMO CONTENT
             */

//            //use a valid task id
//            int taskId = 321;
//
//            //request Task 5 from server
//            TaskResponseObject taskResponseObject = restTemplate
//                    .getForObject("http://demo.codingnomads.co:8080/tasks_api/tasks/" + taskId, TaskResponseObject.class);
//
//            //confirm data was retrieved & avoid NullPointerExceptions
//            Task taskToUpdate;
//            if (taskResponseObject == null) {
//                throw new Exception("The server did not return anything. Not even a ResponseObject!");
//            } else if (taskResponseObject.getData() == null) {
//                throw new Exception("The task with ID " + taskId + " could not be found");
//            } else {
//                taskToUpdate = taskResponseObject.getData();
//            }
//
//            //update the task information
//            taskToUpdate.setName("Fix code");
//            taskToUpdate.setDescription("Debugged HTTP 400 error.");
//            taskToUpdate.setCompleted(true);
//
//            //use put to update the resource on the server
//            restTemplate.put("http://demo.codingnomads.co:8080/tasks_api/tasks/" + taskToUpdate.getId(), taskToUpdate);
//            //get the task to verify update
//            taskResponseObject = restTemplate.getForObject(
//                    "http://demo.codingnomads.co:8080/tasks_api/tasks/" + taskId, TaskResponseObject.class);
//            System.out.println(taskResponseObject.toString());
//
//            taskToUpdate.setName("Update fixed code task.");
//            taskToUpdate.setDescription("Fixed HTTP 400 error.");
//
//            //create an HttpEntity wrapping the task to update
//            HttpEntity<Task> httpEntity = new HttpEntity<>(taskToUpdate);
//            //use exchange() to PUT the HttpEntity, and map the response to a ResponseEntity
//            ResponseEntity<TaskResponseObject> response = restTemplate.exchange(
//                    "http://demo.codingnomads.co:8080/tasks_api/tasks/" + taskToUpdate.getId(),
//                    HttpMethod.PUT, httpEntity, TaskResponseObject.class);
//            System.out.println(response.toString());

            /**
             * User data update --> exchange() method
             */
            // get user data by id
            long userId = 609;
            UserResponseObject userResponseObject = restTemplate
                    .getForObject("http://demo.codingnomads.co:8080/tasks_api/users/" + userId, UserResponseObject.class);

            // update user data retrieved with get request
            User userToUpdate;
            if (userResponseObject == null) {
                throw new Exception("Server didn't return a user.");
            } else if (userResponseObject.getData() == null) {
                throw new Exception("User with ID " + userId + " wasn't found.");
            } else {
                userToUpdate = userResponseObject.getData();
            }

            // update user
            userToUpdate.setFirstName("Scott");
            userToUpdate.setLastName("Summers");
            userToUpdate.setEmail("scottSummers@xmen.com");

            // put updated user data
            HttpEntity<User> httpEntity = new HttpEntity<>(userToUpdate);
            ResponseEntity<UserResponseObject> updatedResponseEntity = restTemplate
                    .exchange("http://demo.codingnomads.co:8080/tasks_api/users/" + userToUpdate.getId(),
                            HttpMethod.PUT, httpEntity, UserResponseObject.class);
            System.out.println(updatedResponseEntity);

            /**
             * Task update --> exchange() method
             */
            // update another task
            long updateTaskId = 320;

            TaskResponseObject taskResponseObject = restTemplate
                    .getForObject("http://demo.codingnomads.co:8080/tasks_api/tasks/" + updateTaskId, TaskResponseObject.class);

            Task taskToUpdate;
            if (taskResponseObject == null) {
                throw new Exception("Server didn't return a task.");
            } else if (taskResponseObject.getData() == null) {
                throw new Exception("Task with ID " + updateTaskId + " doesn't exist.");
            } else {
                taskToUpdate = taskResponseObject.getData();
            }

            taskToUpdate.setDescription("FIXED.");
            taskToUpdate.setCompleted(true);

            HttpEntity httpEntityTask = new HttpEntity(taskToUpdate);
            ResponseEntity<TaskResponseObject> taskUpdateResponse = restTemplate
                    .exchange("http://demo.codingnomads.co:8080/tasks_api/tasks/" + taskToUpdate.getId(),
                            HttpMethod.PUT, httpEntityTask, TaskResponseObject.class);
            System.out.println(taskUpdateResponse);

            /**
             * HTTP put requests --> put() method
             */
            UserResponseObject drStrangeResponse = restTemplate
                    .getForObject("http://demo.codingnomads.co:8080/tasks_api/users/607", UserResponseObject.class);

            User updateStrangeUser;
            if (drStrangeResponse == null) {
                throw new Exception("No user data was returned from the server.");
            } else if (drStrangeResponse.getData() == null) {
                throw new Exception("No user with the ID " + drStrangeResponse.getData().getId() + " exists.");
            } else {
                updateStrangeUser = drStrangeResponse.getData();
            }

            updateStrangeUser.setEmail("strange@marvel.com");

            try {
                restTemplate.put("http://demo.codingnomads.co:8080/tasks_api/users/" + updateStrangeUser.getId(), updateStrangeUser);
            } catch (HttpClientErrorException e) {
                throw new Exception("Unable to update user with ID " + updateStrangeUser.getId() + ".");
            }

            TaskResponseObject strangeTask = restTemplate
                    .getForObject("http://demo.codingnomads.co:8080/tasks_api/tasks/335/", TaskResponseObject.class);

            Task updateStrangeTask;
            if (strangeTask == null) {
                throw new Exception("No task data was returned from the server.");
            } else if (strangeTask.getData() == null) {
                throw new Exception("No task with the ID " + strangeTask.getData().getId() + " was returned.");
            } else {
                updateStrangeTask = strangeTask.getData();
            }

            updateStrangeTask.setDescription(updateStrangeTask.getDescription() + " --- " + "UPDATED WITH restTemplate put() method.");

            restTemplate.put("http://demo.codingnomads.co:8080/tasks_api/tasks/335/", updateStrangeTask);

        };
    }
}
