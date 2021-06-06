package alkemy.challenge.Challenge.Alkemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import alkemy.challenge.Challenge.Alkemy.dto.User;
import alkemy.challenge.Challenge.Alkemy.service.UserService;

@Controller
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private UserService userService;

    /*Endpoint para guardar Usuario en la base de datos*/
    @PostMapping("/login")
    public String saveUser(@Validated @ModelAttribute User u, BindingResult result, Model model){
        /*Verifico que no haya errores con los datos del usuario*/
        if (result.hasErrors()) {
            System.out.println("ok:false");
            System.out.println("Problems with date");
            return "redirect:/auth/login";
        }else{
            model.addAttribute("user", userService.saveUser(u));
            System.out.println("New registered user.");
            System.out.println("User:" + u.toString());
        }
        return "redirect:/auth/login/";
    }

    /*Loguear Usuario*/
    @GetMapping("/login/")
    public String login(Model model){
        model.addAttribute("login", new User());
        return "loginView";
    }
}