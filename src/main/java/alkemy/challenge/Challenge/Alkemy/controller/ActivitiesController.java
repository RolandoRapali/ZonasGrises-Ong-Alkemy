package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.model.Activities;
import alkemy.challenge.Challenge.Alkemy.repository.ActivitiesRepository;
import alkemy.challenge.Challenge.Alkemy.service.ActivitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class ActivitiesController {

    @Autowired
    private ActivitiesService activitiesService;

    @PreAuthorize("hasRole(ROLE_ADMIN)")
    @PostMapping("/activities")
    public ResponseEntity<Activities> createActivities(@RequestBody @Valid Activities activities, BindingResult result) {

        if (result.hasErrors()) {
            return (ResponseEntity<Activities>) ResponseEntity.notFound();
        }
        activitiesService.save(activities);
        return ResponseEntity.ok(activities);
    }
}




