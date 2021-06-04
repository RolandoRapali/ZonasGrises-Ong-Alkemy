package alkemy.challenge.Challenge.Alkemy.service;

import alkemy.challenge.Challenge.Alkemy.dto.User;
import alkemy.challenge.Challenge.Alkemy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> listUsers() {
        return userRepository.findAll();
    }
}
