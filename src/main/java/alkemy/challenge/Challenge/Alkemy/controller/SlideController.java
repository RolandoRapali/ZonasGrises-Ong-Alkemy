package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.service.SlideService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/slides")
public class SlideController {

    @Autowired
    private SlideService slideService;

    /*listado de slides con la imagen y el orden del mismo*/
    @GetMapping("/")
    public List<String> listSlides(){
        return slideService.listSlides();
    }
}
