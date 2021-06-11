package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.model.Testimony;
import alkemy.challenge.Challenge.Alkemy.repository.TestimonialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestimonialController {

    @Autowired
    private TestimonialsRepository testimonialsRepository;

    // The endpoint of type PUT to update the resource from testimony
    @PutMapping("/testimonials/{name}")
    public ResponseEntity<?> saveResource(@RequestBody Testimony testimony,
            @PathVariable("name") String name) {
        //calls the method save from the repository
        if (testimony.getName() != null) {
            testimonialsRepository.save(testimony);
            // prints a ok message
            return ResponseEntity.ok("resource saved");
        } else {
            return (ResponseEntity<?>) ResponseEntity.notFound();
        }
    }
}
