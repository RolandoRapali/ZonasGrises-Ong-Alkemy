package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.exception.ActivitiesNotFoundException;
import alkemy.challenge.Challenge.Alkemy.model.Activities;
import alkemy.challenge.Challenge.Alkemy.repository.ActivitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

public class ActivitiesController {

    @Autowired
    private ActivitiesRepository activitiesRepository;

    @GetMapping(path="/activities/{name_id}")
    public Optional<Activities> getActivitiesByID(@PathVariable Long id) {

        Optional<Activities> a = ActivitiesService.getActivitiesByID(id);
        if (null == a)
            throw new ActivitiesNotFoundException("Activities with ID[" + id + "] not found");
        return a;

    }
}
    @RequestMapping(path = "/mno/objectKey/{id}/{name}", method = RequestMethod.GET)
    public Book getBook(@PathVariable int id, @PathVariable String name) {
        // code here
    }
