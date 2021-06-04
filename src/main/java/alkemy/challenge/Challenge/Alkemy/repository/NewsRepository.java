package alkemy.challenge.Challenge.Alkemy.repository;

import alkemy.challenge.Challenge.Alkemy.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {


}
