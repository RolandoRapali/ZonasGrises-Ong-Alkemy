package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.model.Comment;
import alkemy.challenge.Challenge.Alkemy.service.CommentService;
import alkemy.challenge.Challenge.Alkemy.util.Message;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;
    
    @PostMapping()
    public ResponseEntity<?> createComment(@RequestBody Comment comment) {
        if(comment.getId() == null)
            return new ResponseEntity(new Message("El campo es obligatorio!"), 
                    HttpStatus.BAD_REQUEST);
        if(comment.getUserId() == null)
            return new ResponseEntity(new Message("El campo es obligatorio!"), 
                    HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(comment.getBody()))
            return new ResponseEntity(new Message("El campo es obligatorio!"), 
                    HttpStatus.BAD_REQUEST);
        
        Comment commentCreated = new Comment(comment.getId(),
                comment.getBody(), comment.getUserId(), comment.getNewsId());
        commentService.save(commentCreated);
        return new ResponseEntity(new Message("Comentario creado"), 
                HttpStatus.OK);
    }

//  Listar todos los comentarios de un post
    @GetMapping("/news/{id}/comments")
    public List<Comment> listComments(@PathVariable Long id) {
        return commentService.listComments(id);
    }
    
//  Devuelve todos los comentarios, solo el campo body
    @GetMapping("/comments")
    public ResponseEntity<List<Comment>> getBodies() {
        List<String> list = commentService.ListBody();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateComment(@PathVariable Long id, @RequestBody Comment comment) {
        //busco el comentario por su id
        Optional<Comment> commentAct = commentService.findById(id);
        //si no existe el comentario retorno 404
        if (commentAct.isEmpty()) {
            return new ResponseEntity("no se ha encontrado un comentario con el id: " + id, HttpStatus.NOT_FOUND);
        }
        //validar que el comentario pertenezca al usuario o el usuario sea un administrador
        //retornar 403 si no tiene permiso
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        //valido que el usuario sea el dueño del comentario o que sea administrador
        if (!username.equals(commentAct.get().getUserId().getUsername()) || !commentAct.get().getUserId().getRole().getName().equals("ROLE_ADMIN")) {
            return new ResponseEntity("el usuario no tiene permisos para editar el comentario" + id, HttpStatus.FORBIDDEN);
        }
        //actualizo el comentario
        commentService.update(commentAct.get(), comment);
        return ResponseEntity.ok("comentario actualizado con éxito");
    }
}

