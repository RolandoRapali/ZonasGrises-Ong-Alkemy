package alkemy.challenge.Challenge.Alkemy.service;

import alkemy.challenge.Challenge.Alkemy.model.Comments;
import alkemy.challenge.Challenge.Alkemy.repository.CommentsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class CommentsService {

    @Autowired
    private CommentsRepository commentsRepository;

    public void save(Comments comment) {
        commentsRepository.save(comment);
    }

    public List<Comments> listComments(Long id) {
        return commentsRepository.findByNewsId(id);
    }
}
