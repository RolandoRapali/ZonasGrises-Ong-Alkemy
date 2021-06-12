package alkemy.challenge.Challenge.Alkemy.service;

import alkemy.challenge.Challenge.Alkemy.model.Testimony;
import alkemy.challenge.Challenge.Alkemy.repository.TestimonialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestimonialService {

    @Autowired
    private TestimonialsRepository testimonialsRepository;

    public void testimonialUpdate (Testimony testimony) {
        testimonialsRepository.save(testimony);
    }
}
