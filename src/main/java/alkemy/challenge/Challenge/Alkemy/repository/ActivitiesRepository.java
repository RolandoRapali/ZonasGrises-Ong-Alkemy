package alkemy.challenge.Challenge.Alkemy.repository;

import alkemy.challenge.Challenge.Alkemy.model.Activities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ActivitiesRepository extends JpaRepository<Activities, String> {

    public abstract Activities showActivities( String name);


    boolean existsById(Long activitiesId);

    Activities getById(Long activitiesId);
}
