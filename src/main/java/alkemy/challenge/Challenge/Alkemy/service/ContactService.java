package alkemy.challenge.Challenge.Alkemy.service;

import alkemy.challenge.Challenge.Alkemy.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

}
