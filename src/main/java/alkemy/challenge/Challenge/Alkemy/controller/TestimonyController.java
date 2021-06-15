package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.model.Testimony;
import alkemy.challenge.Challenge.Alkemy.service.TestimonyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testimonials")
public class TestimonyController {

    @Autowired
    private TestimonyService testimonyService;

    // The endpoint of type PUT to update the resource from testimony
    @PutMapping("/{name}")
    public ResponseEntity<?> saveResource(@RequestBody Testimony testimony,
            @PathVariable("name") String name) {
        //calls the method save from the repository

        testimonyService.testimonialUpdate(testimony);
        // prints a ok message
        return ResponseEntity.ok("resource saved");

    }
}
