package alkemy.challenge.Challenge.Alkemy.service;

import alkemy.challenge.Challenge.Alkemy.model.Contact;
import alkemy.challenge.Challenge.Alkemy.repository.ContactRepository;
import alkemy.challenge.Challenge.Alkemy.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public ResponseEntity<?> createContact(Contact contact) {
        if (contact.getName().isBlank() || contact.getName().isEmpty()) {
            return new ResponseEntity(new Message("el campo del nombre no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        if (contact.getEmail().isBlank() || contact.getEmail().isEmpty()) {
            return new ResponseEntity(new Message("el campo del email no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        contactRepository.save(contact);
        return new ResponseEntity(new Message("el contacto ha sido creado con exito"), HttpStatus.OK);
    }

    public List<Contact> bringAllContacts() {
        return contactRepository.findAll();

    }

    public List<Contact> listContact(Long id) {
        return contactRepository.findAllById(id);
    }
}
