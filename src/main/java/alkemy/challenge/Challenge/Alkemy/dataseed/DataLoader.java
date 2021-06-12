package alkemy.challenge.Challenge.Alkemy.dataseed;

import alkemy.challenge.Challenge.Alkemy.model.Activity;
import alkemy.challenge.Challenge.Alkemy.repository.ActivitiesRepository;
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
            Activity activity1 = new Activity(
                    "NombreActividadPRUEBA1",
                    "SoyElContenidoActividad",
                    "SoyUnaImagenActividad");
            Activity activity2 = new Activity(
                    "NombreActividadPRUEBA2",
                    "SoyElContenidoActividad",
                    "SoyUnaImagenActividad");
            activitiesRepository.save(activity1);
            activitiesRepository.save(activity2);
        }
        System.out.println(activitiesRepository.count());
    }
    
}
