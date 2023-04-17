package platform.codingnomads.co.springweb.resttemplate.POST.models;

import lombok.Data;

@Data
public class UserResponseObjectList {
    User[] data;
    Error error;
    String status;
}
