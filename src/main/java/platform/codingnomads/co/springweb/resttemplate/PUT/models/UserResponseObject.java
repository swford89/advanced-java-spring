package platform.codingnomads.co.springweb.resttemplate.PUT.models;

import lombok.Data;

@Data
public class UserResponseObject {
    User data;
    Error message;
    String status;
}
