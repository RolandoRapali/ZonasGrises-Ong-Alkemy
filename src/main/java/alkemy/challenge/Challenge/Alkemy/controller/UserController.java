package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.dto.User;
import alkemy.challenge.Challenge.Alkemy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/a/users")
    public String getUsers(Model model) {
        List<User> usersList = userService.listUsers();
        model.addAttribute("users", new User());
        return "users";
    }
}
