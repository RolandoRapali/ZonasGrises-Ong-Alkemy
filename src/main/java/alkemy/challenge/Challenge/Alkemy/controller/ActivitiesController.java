package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.exception.ActivitiesNotFoundException;
import alkemy.challenge.Challenge.Alkemy.model.Activities;
import alkemy.challenge.Challenge.Alkemy.repository.ActivitiesRepository;
import alkemy.challenge.Challenge.Alkemy.service.ActivitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Optional;
import javax.validation.Valid;

public class ActivitiesController {

    @Autowired
    private ActivitiesService activitiesService;

    @GetMapping(path = "/activities/{name_id}")
    public Optional<Activities> getActivitiesByID(@PathVariable Long id) {
        Optional<Activities> a = ActivitiesService.getActivitiesByID(id);
        if (null == a) {
            throw new ActivitiesNotFoundException("Activities with ID[" + id + "] not found");
        }
        return a;
    }

    /*Endpoint para actualizar actividades */
    @PutMapping("/activities/{id}")
    public ResponseEntity<Activities> updateActivities(@PathVariable(value = "id") Long activitiesId,
            @Valid @RequestBody Activities activitiesDetails) {
        return activitiesService.updateActivities(activitiesId, activitiesDetails);
    }
}
