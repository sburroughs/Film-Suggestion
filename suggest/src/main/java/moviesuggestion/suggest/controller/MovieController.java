package moviesuggestion.suggest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Sburroughs on 9/3/2016.
 */
@RestController
public class MovieController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
