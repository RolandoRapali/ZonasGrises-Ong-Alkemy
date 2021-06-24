package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.model.Contact;
import alkemy.challenge.Challenge.Alkemy.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.List;

@ApiIgnore
@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping("")
    public ResponseEntity<?> createContact(@RequestBody @Valid Contact contact) {
        return contactService.createContact(contact);
    }

    @GetMapping("")
    public List<Contact> bringAllContacts() {
        return contactService.bringAllContacts();
    }

    @GetMapping("/backoffice/contacts")
    public List<Contact> listContact(@PathVariable long id){
        return contactService.listContact(id);
    }


}
