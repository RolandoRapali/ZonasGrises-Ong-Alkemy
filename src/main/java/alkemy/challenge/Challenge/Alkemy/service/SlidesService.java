package alkemy.challenge.Challenge.Alkemy.service;

import alkemy.challenge.Challenge.Alkemy.model.Slides;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface SlidesService {

    public List<Slides> listSlides();

    public void saveSlides(Slides slides);

    public void deleteSlides(Slides slides);

    public Slides findSlides(Slides slides);

}
