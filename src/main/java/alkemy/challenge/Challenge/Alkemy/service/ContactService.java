package alkemy.challenge.Challenge.Alkemy.service;

import alkemy.challenge.Challenge.Alkemy.model.Contact;
import alkemy.challenge.Challenge.Alkemy.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public void createContact(Contact contact) {
        contactRepository.save(contact);
    }

    public List<Contact> bringAllContacts() {
        return contactRepository.findAll();

    }

    public List<Contact> listContact(Long id) {
        return contactRepository.findAllById(id);
    }
}
