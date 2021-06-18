package alkemy.challenge.Challenge.Alkemy.service;

import alkemy.challenge.Challenge.Alkemy.model.Comments;
import alkemy.challenge.Challenge.Alkemy.repository.CommentsRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentsService {

    @Autowired
    private CommentsRepository commentsRepository;

    public void save(Comments comment) {
        commentsRepository.save(comment);
    }

    //Listar todos los comentarios del id de post
    public List<Comments> listComments(Long comments_id) {
        return commentsRepository.findByNewsId(comments_id);
    }

    public Optional<Comments> findById(Long id) {
        return commentsRepository.findById(id);
    }

    public void update(Comments commentAct, Comments comment) {
        commentAct.setBody(comment.getBody());
        commentAct.setUserId(comment.getUserId());
        commentAct.setNewsId(comment.getNewsId());
        commentsRepository.save(commentAct);
    }

}
