package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.model.Activity;
import alkemy.challenge.Challenge.Alkemy.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @PostMapping("/activities")
    public ResponseEntity<Activity> createActivities(@RequestBody @Valid Activity activity) {
        activityService.save(activity);
        return ResponseEntity.ok(activity);
    }


    /*@GetMapping(path = "/{name_id}")
    public Optional<Activity> getActivitiesByID(@PathVariable Long id) {
        Optional<Activity> a = ActivityService.getActivitiesByID(id);
        if (null == a) {
            throw new ActivitiesNotFoundException("Activities with ID[" + id + "] not found");
        }
        return a;
    }
     */

 /*Endpoint para actualizar actividades */
    @PutMapping("/{id}")
    public ResponseEntity<Activity> updateActivities(@PathVariable(value = "id") Long activitiesId,
            @Valid @RequestBody Activity activityDetails) {
        return activityService.updateActivities(activitiesId, activityDetails);
    }
}
