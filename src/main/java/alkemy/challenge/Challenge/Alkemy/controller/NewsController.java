package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.model.News;
import alkemy.challenge.Challenge.Alkemy.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
