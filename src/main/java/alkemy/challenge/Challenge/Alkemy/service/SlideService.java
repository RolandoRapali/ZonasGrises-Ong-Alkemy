package alkemy.challenge.Challenge.Alkemy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SlideService {

    @Autowired
    private SlideRepository slideRepository;

    public ResponseEntity<Slide> deletedSlide(Long id){
        if(slideRepository.existsById(id)){
            Slide s = slideRepository.getById(id);
            slideRepository.delete(s);
            return (ResponseEntity<Slide>) ResponseEntity.ok();
        }
        return (ResponseEntity<Slide>) ResponseEntity.notFound();
    }

}
