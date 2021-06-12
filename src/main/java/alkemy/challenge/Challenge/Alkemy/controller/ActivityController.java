package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.exception.ActivitiesNotFoundException;
import alkemy.challenge.Challenge.Alkemy.model.Activity;
import alkemy.challenge.Challenge.Alkemy.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping(path = "/{name_id}")
    public Optional<Activity> getActivitiesByID(@PathVariable Long id) {
        Optional<Activity> a = ActivityService.getActivitiesByID(id);
        if (null == a) {
            throw new ActivitiesNotFoundException("Activities with ID[" + id + "] not found");
        }
        return a;
    }

    /*Endpoint para actualizar actividades */
    @PutMapping("/{id}")
    public ResponseEntity<Activity> updateActivities(@PathVariable(value = "id") Long activitiesId,
                                                     @Valid @RequestBody Activity activityDetails) {
        return activityService.updateActivities(activitiesId, activityDetails);
    }
}
