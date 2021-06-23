package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.model.Contact;
import alkemy.challenge.Challenge.Alkemy.service.ContactService;
import alkemy.challenge.Challenge.Alkemy.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public ResponseEntity<List<Contact>> bringAllContacts() {
        List<Contact> contacts = contactService.bringAllContacts();
        if (contacts.isEmpty()) {
            return new ResponseEntity(new Message("actualmente no se encuentran contactos registrados"), HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(contacts);
        }
    }
    @GetMapping("/backoffice/contacts")
    public List<Contact> listContact(@PathVariable long id){
        return contactService.listContact(id);

    }


}
