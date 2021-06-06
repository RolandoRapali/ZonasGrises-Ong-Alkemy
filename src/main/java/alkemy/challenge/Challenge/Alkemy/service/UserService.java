package alkemy.challenge.Challenge.Alkemy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import alkemy.challenge.Challenge.Alkemy.dto.User;
import alkemy.challenge.Challenge.Alkemy.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository uRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    /*Guargar un usuario en la base de datos*/
    public User saveUser(User u){
        u.setPassword(passwordEncoder.encode(u.getPassword())); //encriptasion de la contrasena
        return uRepository.save(u);
    }
}