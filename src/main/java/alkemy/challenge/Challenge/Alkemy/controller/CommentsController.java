package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.model.Comments;
import alkemy.challenge.Challenge.Alkemy.service.CommentsService;
import alkemy.challenge.Challenge.Alkemy.util.Message;
import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    private CommentsService commentsService;
    
    @PostMapping()
    public ResponseEntity<?> createComment(@RequestBody Comments comments) {
        if(comments.getPost_id() == null)
            return new ResponseEntity(new Message("El campo es obligatorio!"), 
                    HttpStatus.BAD_REQUEST);
        if(comments.getUserId() == null)
            return new ResponseEntity(new Message("El campo es obligatorio!"), 
                    HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(comments.getBody()))
            return new ResponseEntity(new Message("El campo es obligatorio!"), 
                    HttpStatus.BAD_REQUEST);
        
        Comments commentCreated = new Comments(comments.getPost_id(), 
                comments.getBody(), comments.getUserId(), comments.getNewsId());
        commentsService.save(commentCreated);
        return new ResponseEntity(new Message("Comentario creado"), 
                HttpStatus.OK);
    }

//  Listar todos los comentarios de un post
    @GetMapping("/news/{id}/comments")
    public List<Comments> listComments(@PathVariable Long id) {
        return commentsService.listComments(id);
    }
    
//  Devuelve todos los comentarios, solo el campo body
    @GetMapping("/comments")
    public ResponseEntity<List<Comments>> getBodies() {
        List<String> list = commentsService.ListBody();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateComment(@PathVariable Long id, @RequestBody Comments comment) {
        //busco el comentario por su id
        Optional<Comments> commentAct = commentsService.findById(id);
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
        commentsService.update(commentAct.get(), comment);
        return ResponseEntity.ok("comentario actualizado con éxito");
    }
}

