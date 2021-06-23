package alkemy.challenge.Challenge.Alkemy.service;

import alkemy.challenge.Challenge.Alkemy.model.Comment;
import alkemy.challenge.Challenge.Alkemy.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
        return commentRepository.findByNewsId_id(comments_id);
    }

    public Optional<Comment> findById(Long id) {
        return commentRepository.findById(id);
    }

    public ResponseEntity<?> update(Comment comment, Long id) {
        Optional<Comment> commentAct = commentRepository.findById(id);
        if (commentAct.isEmpty()) {
            return new ResponseEntity("no se ha encontrado un comentario con el id: " + id, HttpStatus.NOT_FOUND);
        }
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        if (!username.equals(commentAct.get().getUserId().getUsername()) || !commentAct.get().getUserId().getRole().getName().equals("ROLE_ADMIN")) {
            return new ResponseEntity("el usuario no tiene permisos para editar el comentario" + id, HttpStatus.FORBIDDEN);
        }
        commentAct.get().setBody(comment.getBody());
        commentAct.get().setUserId(comment.getUserId());
        commentAct.get().setNewsId(comment.getNewsId());
        commentRepository.save(commentAct.get());
        return ResponseEntity.ok("comentario actualizado con éxito");
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

