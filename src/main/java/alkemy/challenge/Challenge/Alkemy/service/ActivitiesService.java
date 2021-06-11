package alkemy.challenge.Challenge.Alkemy.service;

import alkemy.challenge.Challenge.Alkemy.model.Activities;
import alkemy.challenge.Challenge.Alkemy.repository.ActivitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivitiesService {

    @Autowired
    private static ActivitiesRepository activitiesRepository;

    public static Activities getActivitiesByID(Long id) {
        return activitiesRepository.getById(id);
    }
}
