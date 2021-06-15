package alkemy.challenge.Challenge.Alkemy.service;

import alkemy.challenge.Challenge.Alkemy.model.Slide;
import alkemy.challenge.Challenge.Alkemy.repository.SlideRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SlideService {

    private final SlideRepository slideRepository;

    public List<Slide> findSlidesByOrganization(Long id) {
        return slideRepository.findByOrganizationIdOrderBySequence(id);
    }
}
