package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.model.Slide;
import alkemy.challenge.Challenge.Alkemy.service.SlideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/slides")
public class SlideController {

    @Autowired
    private SlideService slideService;

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
