package platform.codingnomads.co.springweb.springrestcontrollers.simpledemo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import platform.codingnomads.co.springweb.resttemplate.POST.models.User;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/api")
public class HelloWorldController {

    @RequestMapping(path = "/hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String hello() {
        return "Hello Spring Developer!";
    }

    @RequestMapping(path = "/hello/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String greeting(@PathVariable(name = "name") String name) {
        return "Hello " + name + "!";
    }

    @RequestMapping(path = "/hello/{name}/detail", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String detail(@PathVariable(name = "name") String name) { return "Hello " + name + ". Here is your account information..."; }

    @RequestMapping(path = "/goodbye", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String goodbye() { return "You are logged out"; }

    @RequestMapping(path = "/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User userDetail() {
        User someUser = User.builder()
                .id(222)
                .email("scottFord@email.com")
                .firstName("Scott")
                .lastName("Ford")
                .build();
        return someUser;
    }

    @RequestMapping(path = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<User> userList() {
        // initialize ArrayList
        ArrayList<User> xmenList = new ArrayList<>();
        // create user: logan
        User logan = User.builder()
                .id(111)
                .email("logan@marvel.com")
                .firstName("Hugh")
                .lastName("Jackman")
                .build();
        xmenList.add(logan);
        // create User: cyclops
        User cyclops = User.builder()
                .id(222)
                .email("cyclops@marvel.com")
                .firstName("Scott")
                .lastName("Summers")
                .build();
        xmenList.add(cyclops);
        // create User: beast
        User beast = User.builder()
                .id(333)
                .email("beast@marvel.com")
                .firstName("Hank")
                .lastName("McCoy")
                .build();
        xmenList.add(beast);
        // create User: jean grey
        User jeanGrey = User.builder()
                .id(444)
                .email("phoenix@marvel.com")
                .firstName("Jean")
                .lastName("Grey")
                .build();
        xmenList.add(jeanGrey);
        // create User: charles xavior
        User charles = User.builder()
                .id(1)
                .email("charles@marvel.com")
                .firstName("Charles")
                .lastName("Xavior")
                .build();
        xmenList.add(charles);
        // return xmenList
        return xmenList;
    }
}




