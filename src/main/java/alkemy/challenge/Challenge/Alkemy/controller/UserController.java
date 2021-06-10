package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.model.Testimony;
import alkemy.challenge.Challenge.Alkemy.model.User;
import alkemy.challenge.Challenge.Alkemy.repository.TestimonialsRepository;
import alkemy.challenge.Challenge.Alkemy.repository.UserRepository;
import alkemy.challenge.Challenge.Alkemy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestimonialsRepository testimonialsRepository;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserById(@PathVariable Long id) {
        Optional<User> user = userService.findById(id);
        if (user.isEmpty()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        userService.softDelete(user.get());
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @GetMapping("/listUsers")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @PatchMapping("/users/{id}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable("id") Long id) {

        if (!userRepository.existsById(id)) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        userRepository.save(user);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}

