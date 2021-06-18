package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.model.Contact;
import alkemy.challenge.Challenge.Alkemy.service.ContactService;
import alkemy.challenge.Challenge.Alkemy.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping("")
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
        if (contact.getName().isBlank() || contact.getName().isEmpty()) {
            return new ResponseEntity(new Message("el campo del nombre no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        if (contact.getEmail().isBlank() || contact.getEmail().isEmpty()) {
            return new ResponseEntity(new Message("el campo del email no puede estar vacio"), HttpStatus.BAD_REQUEST);
        } else {
            contactService.createContact(contact);
            return new ResponseEntity(new Message("el contacto ha sido creado con exito"), HttpStatus.OK);
        }
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
