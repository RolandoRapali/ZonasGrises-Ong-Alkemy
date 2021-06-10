package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.exception.ActivitiesNotFoundException;
import alkemy.challenge.Challenge.Alkemy.model.Activities;
import alkemy.challenge.Challenge.Alkemy.repository.ActivitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

public class ActivitiesController {

    @Autowired
    private ActivitiesRepository activitiesRepository;

    @RequestMapping(path = "/activities/{name}/{content}", method = RequestMethod.GET)
    public Optional<Activities> validateActivities(@PathVariable String name, @PathVariable String content){

        Optional<Activities> a = ActivitiesService.getPublicationByname(name);
        if (null == a)
            throw new ActivitiesNotFoundException("Activities with name[" + name + "] not found");

        Optional<Activities> a = ActivitiesService.getPublicationByconten(content);
        if (null == a)
            throw new ActivitiesNotFoundException("Activities with Content[" + content + "] not found");


        return a;

    }




}
