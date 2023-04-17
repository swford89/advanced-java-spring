package platform.codingnomads.co.springweb.resttemplate.PATCH.models;

import lombok.Data;

@Data
public class TaskResponseObject {
    Task data;
    Error error;
    String status;
}
