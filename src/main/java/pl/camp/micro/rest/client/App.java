package pl.camp.micro.rest.client;

import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

public class App {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8080/user";

        User user = restTemplate.getForObject(url, User.class, new HashMap<>());

        System.out.println(user.getId());
        System.out.println(user.getLogin());
        System.out.println(user.getPassword());

        User userBody = new User(123, "karol", "karol");

        User userFromPost = restTemplate
                .postForObject(url, userBody, User.class, new HashMap<>());

        System.out.println(userFromPost.getId());
        System.out.println(userFromPost.getLogin());
        System.out.println(userFromPost.getPassword());
    }
}
