package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.exception.CustomDeniedAccessHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DenyController {

    @GetMapping("/deny")
    public void accessDenied() throws Exception {
        throw new Exception("User is not authorized");
    }
}
