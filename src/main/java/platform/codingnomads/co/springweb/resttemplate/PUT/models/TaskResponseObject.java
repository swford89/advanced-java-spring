package platform.codingnomads.co.springweb.resttemplate.PUT.models;

import lombok.Data;

@Data
public class TaskResponseObject {
    Task data;
    Error error;
    String status;
}
