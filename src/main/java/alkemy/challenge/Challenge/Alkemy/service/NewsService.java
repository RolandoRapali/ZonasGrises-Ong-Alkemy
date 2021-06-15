package alkemy.challenge.Challenge.Alkemy.service;

import alkemy.challenge.Challenge.Alkemy.model.News;
import alkemy.challenge.Challenge.Alkemy.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    public News bringById(long id) {
        return newsRepository.findById(id);
    }

    public News update(News newsAux, News news) {
        newsAux.setName(news.getName());
        newsAux.setImage(news.getImage());
        newsAux.setContent(news.getContent());
        newsAux.setCategoryId(news.getCategoryId());
        newsAux.setDeleted(news.isDeleted());
        newsRepository.save(newsAux);
        return newsAux;
    }

    @Transactional
    public void delete(long id) {
        boolean exists = newsRepository.existsById(id);
        if (exists) {
            newsRepository.deleteById(id);
        } else {
            throw new IllegalStateException("El id " + id + "que buscas no existe");
        }
    }

    public News create(News news) {
        return newsRepository.save(news);
    }
}
