package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.model.Comment;
import alkemy.challenge.Challenge.Alkemy.model.News;
import alkemy.challenge.Challenge.Alkemy.service.CommentService;
import alkemy.challenge.Challenge.Alkemy.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    NewsService newsService;

    @Autowired
    CommentService commentService;

    @GetMapping
    public Page<News> listNews(@PageableDefault(size = 10, page = 0) Pageable pageable) {
        return newsService.findAll(pageable);
    }

    //@PreAuthorize("hasRole(ROLE_ADMIN)") en un comienzo, esto lo filtro con los antMatcher
    @GetMapping("/{id}")
    public News bringNews(@PathVariable long id) {
        return newsService.bringById(id);
    }

    //Listar todos los comentarios de un post
    @GetMapping("/{id}/comments")
    public List<Comment> listComments(@PathVariable Long id) {
        return commentService.listComments(id);
    }

    @PostMapping
    public News newNews(@RequestBody @Valid News news) {
        return newsService.create(news);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        newsService.delete(id);
        return "redirect:/news";

    }

}
