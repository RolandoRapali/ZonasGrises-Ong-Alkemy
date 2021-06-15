package alkemy.challenge.Challenge.Alkemy.service;

import alkemy.challenge.Challenge.Alkemy.model.Testimony;
import alkemy.challenge.Challenge.Alkemy.repository.TestimonyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TestimonyService {

    @Autowired
    private TestimonyRepository testimonyRepository;

    public void testimonialUpdate(Testimony testimony) {
        testimonyRepository.save(testimony);
    }

    public void softDelete(Testimony testimony) {
        testimony.setDeleted(true);
        testimonyRepository.save(testimony);
    }

    public Optional<Testimony> findById(Long id) {
        return testimonyRepository.findByIdAndDeletedFalse(id);
    }
}
