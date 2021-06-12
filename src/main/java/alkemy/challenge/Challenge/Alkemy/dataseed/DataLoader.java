package alkemy.challenge.Challenge.Alkemy.dataseed;

import alkemy.challenge.Challenge.Alkemy.model.Activity;
import alkemy.challenge.Challenge.Alkemy.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    ActivityRepository activityRepository;
    
    @Override
    public void run(String... args) throws Exception {
        loadActivitiesData();
    }
    
    private void loadActivitiesData() {
        if (activityRepository.count() == 0) {
            Activity activity1 = new Activity(
                    "NombreActividadPRUEBA1",
                    "SoyElContenidoActividad",
                    "SoyUnaImagenActividad");
            Activity activity2 = new Activity(
                    "NombreActividadPRUEBA2",
                    "SoyElContenidoActividad",
                    "SoyUnaImagenActividad");
            activityRepository.save(activity1);
            activityRepository.save(activity2);
        }
        System.out.println(activityRepository.count());
    }
    
}
