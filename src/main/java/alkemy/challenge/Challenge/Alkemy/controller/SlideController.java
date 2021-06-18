package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.service.AmazonClientService;
import alkemy.challenge.Challenge.Alkemy.model.Slide;
import alkemy.challenge.Challenge.Alkemy.service.SlideService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/slides")
public class SlideController {

    @Autowired
    private SlideService slideService;

    @Autowired
    private AmazonClientService amazonClientService;

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
