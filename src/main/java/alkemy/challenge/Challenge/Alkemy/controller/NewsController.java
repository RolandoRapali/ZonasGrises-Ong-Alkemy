package alkemy.challenge.Challenge.Alkemy.controller;

import alkemy.challenge.Challenge.Alkemy.model.News;
import alkemy.challenge.Challenge.Alkemy.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    NewsService newsService;

    //@PreAuthorize("hasRole(ROLE_ADMIN)") en un comienzo, esto lo filtro con los antMatchers
    @GetMapping("/{id}")
    public News bringNews(@PathVariable long id) {
        News news = newsService.bringById(id);
        return news;
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
