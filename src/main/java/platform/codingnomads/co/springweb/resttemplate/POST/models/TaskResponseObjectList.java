package platform.codingnomads.co.springweb.resttemplate.POST.models;

import lombok.Data;

@Data
public class TaskResponseObjectList {
    Task[] data;
    Error error;
    String status;
}
