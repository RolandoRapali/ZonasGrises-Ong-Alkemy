package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.model.Testimony;
import alkemy.challenge.Challenge.Alkemy.repository.TestimonialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private TestimonialsRepository testimonialsRepository;
}
