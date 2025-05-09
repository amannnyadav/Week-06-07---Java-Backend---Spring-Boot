package org.cg.springintroduction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

class User {
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

@SpringBootApplication
@RestController
public class SpringIntroductionApplication {

    @RequestMapping(value = {"","/","/home"})
    public String home() {
        return "Hello World home";
    }

    @RequestMapping(value = {"/query"},method = RequestMethod.GET)
    public String sayHello(@RequestParam(value = "name",defaultValue = "guest") String name) {
        return "Hello " + name;
    }
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World";
    }
    @GetMapping("/param/{name}")
    public String sayHello2(@PathVariable String name) {
        return "Hello " + name;
    }

    @PostMapping("/post")
    public String sayHello3(@RequestBody User user) {
        return "Hello " + user.getFirstName() + " " + user.getLastName();
    }

    @PutMapping("/put/{firstName}")
    public String sayHello4(@PathVariable String firstName, @RequestParam(value = "lastName") String lastName) {
        return "Hello " + firstName + " " + lastName;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringIntroductionApplication.class, args);
    }

}
