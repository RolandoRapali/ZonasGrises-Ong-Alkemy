package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.model.News;
import alkemy.challenge.Challenge.Alkemy.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    NewsService newsService;

    @PreAuthorize("hasRole(ROLE_ADMIN)")
    @GetMapping("/{id}")
    public News bringNews(@PathVariable long id) {
        News news = newsService.bringById(id);
        return news;
    }

    @PreAuthorize("hasRole(ROLE_ADMIN)")
    @PutMapping("/{id}")
    public ResponseEntity<News> updateNews(@PathVariable Long id, @RequestBody @Valid News news) {
        News newsAux = newsService.bringById(id);
        if (!(newsAux == null)) {
            newsService.update(newsAux, news);
            return ResponseEntity.ok(newsAux);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
