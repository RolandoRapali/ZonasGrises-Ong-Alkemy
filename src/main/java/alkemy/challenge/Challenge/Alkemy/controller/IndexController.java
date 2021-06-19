package alkemy.challenge.Challenge.Alkemy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @RequestMapping("/")
    String index(){
        return "index";
    }
}
