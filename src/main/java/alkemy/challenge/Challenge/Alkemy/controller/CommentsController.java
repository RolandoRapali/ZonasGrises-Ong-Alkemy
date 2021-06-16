package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.model.Comments;
import alkemy.challenge.Challenge.Alkemy.service.CommentsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    @GetMapping("/news/{id}/comments")
    public List<Comments> listComments(@PathVariable Long id) {
        return commentsService.listComments(id);
    }

}
