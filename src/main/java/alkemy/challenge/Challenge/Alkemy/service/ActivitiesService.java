package alkemy.challenge.Challenge.Alkemy.service;

import alkemy.challenge.Challenge.Alkemy.model.Activity;
import alkemy.challenge.Challenge.Alkemy.repository.ActivitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ActivitiesService {

    @Autowired
    private ActivitiesRepository activitiesRepository;

    public static Optional<Activity> getActivitiesByID(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ResponseEntity<Activity> updateActivities(Long activitiesId, Activity activityDetails) {
        if (activitiesRepository.existsById(activitiesId)) {
            Activity activity = activitiesRepository.getById(activitiesId);
            activity.setName(activityDetails.getName());
            activity.setContent(activityDetails.getContent());
            activity.setImage(activityDetails.getImage());
            activity.setDeleted(activityDetails.isDeleted());
            final Activity updateActivity = activitiesRepository.save(activity);
            return ResponseEntity.ok(updateActivity);
        } else {
            return (ResponseEntity<Activity>) ResponseEntity.notFound();
        }
    }
}
