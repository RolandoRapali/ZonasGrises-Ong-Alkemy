package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.model.Comments;
import alkemy.challenge.Challenge.Alkemy.service.CommentsService;
import alkemy.challenge.Challenge.Alkemy.util.Message;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
public class CommentsController {
    
    @Autowired
    private CommentsService comentsService;
    
    @PostMapping()
    public ResponseEntity<?> createComment(@RequestBody Comments comments) {
        if(comments.getPost_id() == null)
            return new ResponseEntity(new Message("El campo es obligatorio!"), 
                    HttpStatus.BAD_REQUEST);
        if(comments.getUser_id() == null)
            return new ResponseEntity(new Message("El campo es obligatorio!"), 
                    HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(comments.getBody()))
            return new ResponseEntity(new Message("El campo es obligatorio!"), 
                    HttpStatus.BAD_REQUEST);
        
        Comments commentCreated = new Comments(comments.getPost_id(), 
                comments.getBody(), comments.getUser_id());
        comentsService.save(commentCreated);
        return new ResponseEntity(new Message("Comentario creado"), 
                HttpStatus.OK);
    }
}
