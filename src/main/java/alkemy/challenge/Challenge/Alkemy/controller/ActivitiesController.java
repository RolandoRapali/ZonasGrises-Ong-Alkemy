package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.exception.ActivitiesNotFoundException;
import alkemy.challenge.Challenge.Alkemy.model.Activity;
import alkemy.challenge.Challenge.Alkemy.service.ActivitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.Optional;

public class ActivitiesController {

    @Autowired
    private ActivitiesService activitiesService;

    @GetMapping(path = "/activities/{name_id}")
    public Optional<Activity> getActivitiesByID(@PathVariable Long id) {
        Optional<Activity> a = ActivitiesService.getActivitiesByID(id);
        if (null == a) {
            throw new ActivitiesNotFoundException("Activities with ID[" + id + "] not found");
        }
        return a;
    }

    /*Endpoint para actualizar actividades */
    @PutMapping("/activities/{id}")
    public ResponseEntity<Activity> updateActivities(@PathVariable(value = "id") Long activitiesId,
                                                     @Valid @RequestBody Activity activityDetails) {
        return activitiesService.updateActivities(activitiesId, activityDetails);
    }
}
