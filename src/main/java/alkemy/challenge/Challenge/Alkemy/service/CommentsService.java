package alkemy.challenge.Challenge.Alkemy.service;

import alkemy.challenge.Challenge.Alkemy.model.Comments;
import alkemy.challenge.Challenge.Alkemy.repository.CommentsRepository;
import java.util.ArrayList;
import java.util.List;
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
    public List<Comments> listComments(Long id) {
        return commentsRepository.findByNewsId(id);
    }
    
    public List<String> ListBody() {
        List<Comments> listComents = commentsRepository.findAll();
        List<String> listBody = new ArrayList<>();
        listComents.forEach(c -> {
            listBody.add(c.getBody());
        });
        return listBody;
    }
            
}

