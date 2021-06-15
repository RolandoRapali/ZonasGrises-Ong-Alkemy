package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

}
