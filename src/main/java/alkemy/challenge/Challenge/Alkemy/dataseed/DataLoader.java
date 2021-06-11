package alkemy.challenge.Challenge.Alkemy.dataseed;

import alkemy.challenge.Challenge.Alkemy.model.Activities;
import alkemy.challenge.Challenge.Alkemy.repository.ActivitiesRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    ActivitiesRepository activitiesRepository;
    
    @Override
    public void run(String... args) throws Exception {
        loadActivitiesData();
    }
    
    private void loadActivitiesData() {
        if (activitiesRepository.count() == 0) {
            Activities activities1 = new Activities(
                    1L, 
                    "NombreActividadPRUEBA1",
                    "SoyElContenidoActividad",
                    "SoyUnaImagenActividad", 
                    false, 
                    new Date());
            Activities activities2 = new Activities(
                    2L, 
                    "NombreActividadPRUEBA2",
                    "SoyElContenidoActividad",
                    "SoyUnaImagenActividad", 
                    false, 
                    new Date());
            activitiesRepository.save(activities1);
            activitiesRepository.save(activities2);
        }
        System.out.println(activitiesRepository.count());
    }
    
}
