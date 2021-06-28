package alkemy.challenge.Challenge.Alkemy.controller;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import alkemy.challenge.Challenge.Alkemy.model.Role;
import alkemy.challenge.Challenge.Alkemy.model.User;
import alkemy.challenge.Challenge.Alkemy.repository.UserRepository;
import alkemy.challenge.Challenge.Alkemy.service.UserService;

public class UserControllerTest {
    
    @Autowired
    UserService userService;

    UserRepository userRepositoryMockito = Mockito.mock(UserRepository.class);

    @BeforeEach
    void setUp() {
        Role mockRole = new Role("ADMIN", "test role admin");
        Optional<User> mockUser = new User();
        new User("test", "test", "test@test.com", "12345678", "test", mockRole);
        
        Mockito.when(userRepositoryMockito.findById((long) 1)).thenReturn(mockUser);
    }

    @AfterEach
    void tearDown() {
        
    }

    @Test
    void listUsers(){

    }

    @Test
    void deleteUserById(Long id){

    }

    @Test
    void saveUser(User u){

    }

    @Test
    void loginUser(){

    }
}
