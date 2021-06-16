package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.model.Testimony;
import alkemy.challenge.Challenge.Alkemy.service.TestimonyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/listTestimony")
    public Page<Testimony> listTestimony(@PageableDefault(size = 10, page = 0) Pageable pageable){
        Page<Testimony> list = testimonyService.getPageTestimony(pageable);
        if (list.isEmpty()) {
            return null;
        } else{
            return list;
        }
    }
}
