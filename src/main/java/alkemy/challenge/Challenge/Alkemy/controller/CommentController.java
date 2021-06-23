package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.model.Comment;
import alkemy.challenge.Challenge.Alkemy.service.CommentService;
import alkemy.challenge.Challenge.Alkemy.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;
    
    @PostMapping()
    public ResponseEntity<?> createComment(@RequestBody Comment comment) {
        commentService.save(comment);
        return new ResponseEntity(new Message("Comentario creado"), HttpStatus.OK);
    }
    
    //Devuelve todos los comentarios, solo el campo body
    @GetMapping
    public List<String> getBodies() {
        return commentService.ListBody();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateComment(@PathVariable Long id, @RequestBody Comment comment) {
        return commentService.update(comment, id);
    }
}

