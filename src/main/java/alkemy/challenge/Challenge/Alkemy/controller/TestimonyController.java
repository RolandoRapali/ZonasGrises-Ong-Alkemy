package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.model.Testimony;
import alkemy.challenge.Challenge.Alkemy.service.TestimonyService;
import alkemy.challenge.Challenge.Alkemy.util.Message;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/testimonials")
public class TestimonyController {

    @Autowired
    private TestimonyService testimonyService;

    @PostMapping
    public ResponseEntity<?> newTestimony(@RequestBody @Valid Testimony testimony) {
        if (StringUtils.isBlank(testimony.getName())) {
            return new ResponseEntity(new Message("El campo 'nombre' está vacío"),
                    HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(testimony.getContent())) {
            return new ResponseEntity(new Message("El campo 'content' está vacío"),
                    HttpStatus.BAD_REQUEST);
        }
        testimonyService.save(testimony);
        return ResponseEntity.ok("testimonio creado con éxito");
    }

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
