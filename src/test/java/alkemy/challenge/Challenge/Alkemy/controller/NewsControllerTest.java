package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


class NewsControllerTest {

    @Autowired
    UserService userService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void listNews() {
    }

    @Test
    void bringNews() {
        System.out.print(userService.findById(1L));
    }

    @Test
    void listComments() {
    }

    @Test
    void newNews() {
    }

    @Test
    void delete() {
    }
}