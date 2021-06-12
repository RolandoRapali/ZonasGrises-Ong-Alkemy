package alkemy.challenge.Challenge.Alkemy.service;

import alkemy.challenge.Challenge.Alkemy.model.Testimony;
import alkemy.challenge.Challenge.Alkemy.repository.TestimonyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestimonyService {

    @Autowired
    private TestimonyRepository testimonyRepository;

    public void testimonialUpdate(Testimony testimony) {
        testimonyRepository.save(testimony);
    }
}
