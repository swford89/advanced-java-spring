package platform.codingnomads.co.springweb.resttemplate.DELETE.models;

import lombok.Data;

@Data
public class TaskResponseObject {
    Task data;
    Error error;
    String status;
}
