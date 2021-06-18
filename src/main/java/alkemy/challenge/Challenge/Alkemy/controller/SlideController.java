package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.service.AmazonClientService;
import alkemy.challenge.Challenge.Alkemy.model.Slide;
import alkemy.challenge.Challenge.Alkemy.service.SlideService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/slides")
public class SlideController {

    @Autowired
    private SlideService slideService;

    @Autowired
    private AmazonClientService amazonClientService;
    
    /*listado de slides con la imagen y el orden del mismo*/
    @GetMapping("/")
    public List<String> listSlides(){
        return slideService.listSlides();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Slide> detailSlide(@PathVariable(value = "id") Long id){
        return slideService.detailSlide(id);
    }

    @PostMapping("/")
    public ResponseEntity<Slide> createSlide(@RequestBody @Valid Slide slide, byte[] file){
        slideService.createSlide(file, slide);
        amazonClientService.uploadFile(slideService.convertMultipartFile(file));
        return ResponseEntity.ok(slide);
    }

    @GetMapping("/{id}")
    public List<Slide> listSlidesByOrganizationId(@PathVariable Long id) {
        return slideService.findSlidesByOrganization(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Slide> updateSlide(@PathVariable(value = "id")Long id,
                                             @Valid @RequestBody Slide slideDetails){
                return slideService.updateSlide(id, slideDetails);
            }

    @DeleteMapping("/{id}")
    public ResponseEntity<Slide> deleteSlide(@PathVariable(value = "id") Long id){
        return slideService.deletedSlide(id);
    }
}
