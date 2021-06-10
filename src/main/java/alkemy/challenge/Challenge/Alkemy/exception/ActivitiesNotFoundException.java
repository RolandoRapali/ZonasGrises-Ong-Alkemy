package alkemy.challenge.Challenge.Alkemy.exception;

import alkemy.challenge.Challenge.Alkemy.model.Activities;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ActivitiesNotFoundException extends RuntimeException {

    public ActivitiesNotFoundException(String message) {
        super(message);
    }
}
