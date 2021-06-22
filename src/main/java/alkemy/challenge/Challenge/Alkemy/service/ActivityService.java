package alkemy.challenge.Challenge.Alkemy.service;

import alkemy.challenge.Challenge.Alkemy.model.Activity;
import alkemy.challenge.Challenge.Alkemy.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public Optional<Activity> getActivitiesByID(Long id) {
        return activityRepository.findById(id);
    }

    public ResponseEntity<Activity> updateActivities(Long activitiesId, Activity activityDetails) {
        if (activityRepository.existsById(activitiesId)) {
            Activity activity = activityRepository.getById(activitiesId);
            activity.setName(activityDetails.getName());
            activity.setContent(activityDetails.getContent());
            activity.setImage(activityDetails.getImage());
            activity.setDeleted(activityDetails.isDeleted());
            final Activity updateActivity = activityRepository.save(activity);
            return ResponseEntity.ok(updateActivity);
        } else {
            return (ResponseEntity<Activity>) ResponseEntity.notFound();
        }
    }

    public void save(Activity activity) {
        activityRepository.save(activity);
    }
}
