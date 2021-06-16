package alkemy.challenge.Challenge.Alkemy.service;

import alkemy.challenge.Challenge.Alkemy.model.Comments;
import alkemy.challenge.Challenge.Alkemy.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CommentsService {
    
    @Autowired
    private CommentsRepository commentsRepository;
    
    public void save(Comments comment) {
        commentsRepository.save(comment);
    }
}
