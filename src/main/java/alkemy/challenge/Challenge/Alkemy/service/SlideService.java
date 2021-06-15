package alkemy.challenge.Challenge.Alkemy.service;

import alkemy.challenge.Challenge.Alkemy.model.Slide;
import alkemy.challenge.Challenge.Alkemy.repository.OrganizationRepository;
import alkemy.challenge.Challenge.Alkemy.repository.SlideRepository;
import lombok.RequiredArgsConstructor;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SlideService {
    @Autowired
    private SlideRepository slideRepository;

    public List<String> listSlides(){
        List<Slide> listSlide = slideRepository.findAll();
        List<String> listImageSequence = new ArrayList<>();
        for (Slide s : listSlide) {
            listImageSequence.add(s.getImageUrl());
            listImageSequence.add(s.getSequence());            
        }
        return listImageSequence;
    }
}
