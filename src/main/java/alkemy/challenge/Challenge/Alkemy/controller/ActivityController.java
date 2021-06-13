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
public class ActivitiesController {

    @Autowired
    private ActivitiesService activitiesService;

    @PreAuthorize("hasRole(ROLE_ADMIN)")
    @PostMapping("/activities")
    public ResponseEntity<Activities> createActivities(@RequestBody @Valid Activities activities, @BindingResult result) {

        if (resul.hasErrors()) {
            return (ResponseEntity<Activities>) ResponseEntity.notFound();
        }
        activitiesService.save(activities);
        return ResponseEntity.ok(activities);
    }
}

    /*Endpoint para actualizar actividades */
    @PutMapping("/{id}")
    public ResponseEntity<Activity> updateActivities(@PathVariable(value = "id") Long activitiesId,
                                                     @Valid @RequestBody Activity activityDetails) {
        return activityService.updateActivities(activitiesId, activityDetails);
    }
}
