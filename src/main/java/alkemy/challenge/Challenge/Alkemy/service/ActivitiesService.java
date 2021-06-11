package alkemy.challenge.Challenge.Alkemy.service;

import alkemy.challenge.Challenge.Alkemy.exception.ActivitiesNotFoundException;
import alkemy.challenge.Challenge.Alkemy.model.Activities;
import alkemy.challenge.Challenge.Alkemy.repository.ActivitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ActivitiesService {

    @Autowired
    private ActivitiesRepository activitiesRepository;

    public void save(Activities activities) {
        activitiesRepository.save(activities);
    }

}
