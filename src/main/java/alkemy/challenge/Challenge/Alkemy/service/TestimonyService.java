package alkemy.challenge.Challenge.Alkemy.service;

import alkemy.challenge.Challenge.Alkemy.model.Testimony;
import alkemy.challenge.Challenge.Alkemy.repository.TestimonyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TestimonyService {

    @Autowired
    private TestimonyRepository testimonyRepository;

    public Testimony save(Testimony testimony) {
        return testimonyRepository.save(testimony);
    }

    public void testimonialUpdate(Testimony testimony) {
        testimonyRepository.save(testimony);
    }

    public Page<Testimony> getPageTestimony(Pageable pageable){
        return testimonyRepository.findAll(pageable);
    }

    public void softDelete(Testimony testimony) {
        testimony.setDeleted(true);
        testimonyRepository.save(testimony);
    }

    public Optional<Testimony> findById(Long id) {
        return testimonyRepository.findByIdAndDeletedFalse(id);
    }
}
