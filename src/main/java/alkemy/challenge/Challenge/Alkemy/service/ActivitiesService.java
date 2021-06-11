package alkemy.challenge.Challenge.Alkemy.service;

import alkemy.challenge.Challenge.Alkemy.model.Activities;
import alkemy.challenge.Challenge.Alkemy.repository.ActivitiesRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ActivitiesService {

    @Autowired
    private ActivitiesRepository activitiesRepository;

    public static Optional<Activities> getActivitiesByID(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ResponseEntity<Activities> updateActivities(Long activitiesId,Activities activitiesDetails) {
        if (activitiesRepository.existsById(activitiesId)) {
            Activities activities = activitiesRepository.getById(activitiesId);
            activities.setName(activitiesDetails.getName());
            activities.setContent(activitiesDetails.getContent());
            activities.setImage(activitiesDetails.getImage());
            activities.setDeleted(activitiesDetails.isDeleted());
            activities.setActivitiesDate(activitiesDetails.getActivitiesDate());
            final Activities updateActivities = activitiesRepository.save(activities);
            return ResponseEntity.ok(updateActivities);
        } else {
            return (ResponseEntity<Activities>) ResponseEntity.notFound();
        }
    }
}
