package alkemy.challenge.Challenge.Alkemy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SlideService {

    @Autowired
    private SlideRepository slideRepository;

    public ResponseEntity<Slide> updateSlide(Long id, Slide slideDetail){
        if (slideRepository.existsById(id)){
            Slide slide = slideRepository.getById(id);
            slide.setImageUrl(slideDetail.getImageUrl());
            slide.setText(slideDetail.getText());
            slide.setSequence(slideDetail.getSequence());
            slide.setCreatedAt(slideDetail.getCreatedAt());
            slide.setUpdatedAt(slideDetail.getUpdatedAt());
            final Slide updatSlide = slideRepository.save(slide);
            return ResponseEntity.ok(updatSlide);
        }
        return (ResponseEntity<Slide>) ResponseEntity.notFound();
    }

    public ResponseEntity<Slide> deletedSlide(Long id){
        if(slideRepository.existsById(id)){
            Slide s = slideRepository.getById(id);
            slideRepository.delete(s);
            return (ResponseEntity<Slide>) ResponseEntity.ok();
        }
        return (ResponseEntity<Slide>) ResponseEntity.notFound();
    }
}
