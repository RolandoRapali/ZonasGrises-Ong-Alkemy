package alkemy.challenge.Challenge.Alkemy.service;

import alkemy.challenge.Challenge.Alkemy.model.Comment;
import alkemy.challenge.Challenge.Alkemy.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    //Listar todos los comentarios del id de post
    public List<Comment> listComments(Long comments_id) {
        return commentRepository.findByNewsId(comments_id);
    }

    public Optional<Comment> findById(Long id) {
        return commentRepository.findById(id);
    }

    public void update(Comment commentAct, Comment comment) {
        commentAct.setBody(comment.getBody());
        commentAct.setUserId(comment.getUserId());
        commentAct.setNewsId(comment.getNewsId());
        commentRepository.save(commentAct);
    }

    
    public List<String> ListBody() {
        List<Comment> listComents = commentRepository.findAll();
        List<String> listBody = new ArrayList<>();
        listComents.forEach(c -> {
            listBody.add(c.getBody());
        });
        return listBody;
    }
            
}

