package alkemy.challenge.Challenge.Alkemy.repository;

import alkemy.challenge.Challenge.Alkemy.model.Slide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlideRepository extends JpaRepository<Slide, Long> {

}